  package comcripto.cripto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comcripto.cripto.Model.Cripto;
import comcripto.cripto.Service.Servicecripto;

@Controller

public class CriptoControllere {
	
	@Autowired
	Servicecripto serviceCripto;
	
	@GetMapping("/cripto")
	public String Clima(@RequestParam("nome")String nome,Model model) {
		
		Cripto cripto =  serviceCripto.buscarCripto(nome);
		
		if(cripto != null) {
			
			
			
			
			model.addAttribute("cripto",cripto);
			
		}else { model.addAttribute("erro", "moeda não encontrada ou erro ao buscar dados.");}
		return "cripto";
	}

}
