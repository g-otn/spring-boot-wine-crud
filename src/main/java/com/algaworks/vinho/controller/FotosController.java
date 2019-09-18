package com.algaworks.vinho.controller;

import com.algaworks.vinho.dto.Foto;
import com.algaworks.vinho.service.CadastroVinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

    @Autowired
    private CadastroVinhoService cadastroVinhoService;

    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public Foto upload(@PathVariable Long codigo, @RequestParam("files[]") MultipartFile[] files) {

        String url = cadastroVinhoService.salvarFoto(codigo, files[0]);

        return new Foto(url);
    }
}
