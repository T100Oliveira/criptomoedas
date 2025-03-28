package comcripto.cripto.Model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import jakarta.persistence.Entity;


public class Cripto {

	
	private String nome;
	
	private BigDecimal marketCap;
	
	

	private BigDecimal precoUsd;

	public String getNome() {
		
		
		
		
		
		

		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getMarketCap() {
        DecimalFormat formatadorMarketCap = new DecimalFormat("#,##0.00");
        String marketCapFormatado = formatadorMarketCap.format(marketCap);
		return  marketCapFormatado;
		
		
	}

	public void setMarketCap(BigDecimal bigDecimal) {
		this.marketCap = bigDecimal;
	}

	public String getPrecoUsd() {
	 DecimalFormat formatadorPreco = new DecimalFormat("$#,##0.000000000");
	   String precoFormatado = formatadorPreco.format(precoUsd);
		return precoFormatado;
	}

	public void setPrecoUsd(BigDecimal bigDecimal) {
		this.precoUsd = bigDecimal;
	}



	


}
