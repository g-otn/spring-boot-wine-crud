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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result, RedirectAttributes	attributes) {
		if (result.hasErrors()) {
			return novo(vinho);
		}

		cadastroVinhoService.salvar(vinho);
		attributes.addFlashAttribute("mensagem", "Vinho salvo com sucesso!");
		return new ModelAndView("redirect:/vinhos/novo");
	}

	@RequestMapping("/{codigo}")
	public ModelAndView visualizar(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("/vinho/VisualizacaoVinho.html");

		Optional<Vinho> vinhoOptional = vinhos.findById(codigo);
		Vinho vinho = vinhoOptional.get();

		if (vinho.temFoto()) {
			vinho.setUrl("http://localhost:9444/s3/vinho/" + vinho.getFoto() + "?noAuth=true");
		}

		mv.addObject("vinho", vinho);
		return mv;
	}
	
}
