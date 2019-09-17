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
        String nomeArquivoFoto = files[0].getOriginalFilename();

        System.out.println("-----> " + nomeArquivoFoto);
        cadastroVinhoService.adicionarFoto(codigo, nomeArquivoFoto);

        return new Foto(nomeArquivoFoto);
    }
}
