package com.algaworks.vinho.controller;

import com.algaworks.vinho.model.TipoVinho;
import com.algaworks.vinho.model.Vinho;
import com.algaworks.vinho.repository.Vinhos;
import com.algaworks.vinho.service.CadastroVinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;

	@Autowired
	private CadastroVinhoService cadastroVinhoService;

	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/vinho/ListagemVinhos");
		mv.addObject("vinhos", vinhos.findAll());
		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("/vinho/CadastroVinho.html");
		mv.addObject("tipos", TipoVinho.values());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result) {
		if (result.hasErrors()) {
			return novo(vinho);
		}
		cadastroVinhoService.salvar(vinho);
		return new ModelAndView("redirect:/vinhos/novo");
	}
	
}