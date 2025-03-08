package comcripto.cripto.Service;

import java.text.DecimalFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import comcripto.cripto.Model.Cripto;

@Service
public class Servicecripto {
	
private final RestTemplate restTemplate;

public Servicecripto(RestTemplate restTemplate) {
	
	this.restTemplate = restTemplate;
}
 public Cripto buscarCripto (String nome) {
	 
	 String url = String.format("https://api.coingecko.com/api/v3/coins/%s" , nome);
	 
	 ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	 
	 try {
		 
	 ObjectMapper objectMapper = new ObjectMapper();
		 
	JsonNode jsonNode = objectMapper.readTree(response.getBody());
	
	JsonNode moedaNode = jsonNode.get("market_data");
	 
         Cripto cripto = new Cripto();
     
         
         cripto.setNome(nome); // Nome da moeda
         cripto.setPrecoUsd(moedaNode.get("current_price").get("usd").decimalValue()); // Preço em USD
         cripto.setMarketCap(moedaNode.get("market_cap").get("usd").decimalValue());
         return cripto;
     
     
 } catch (Exception e) {
     e.printStackTrace();
     return null;
 
}}}