package com.algaworks.vinho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@RequestMapping("/novo")
	public String novo() {
		return "/vinho/CadastroProduto";
	}
	
	@RequestMapping
	public String pesquisa() {
		return "/vinho/ListagemVinhos";
	}
	
}
