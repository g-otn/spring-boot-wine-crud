package com.algaworks.vinho.service;

import com.algaworks.vinho.model.Vinho;
import com.algaworks.vinho.repository.Vinhos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroVinhoService {

    @Autowired
    private Vinhos vinhos;

    public void salvar(Vinho vinho) {
        // regras de neg�cio aqui

        this.vinhos.save(vinho);
    }

    public void adicionarFoto(Long codigo, String nome) {
        Optional<Vinho> vinhoOptional = vinhos.findById(codigo);
        Vinho vinho = vinhoOptional.get();
        vinho.setFoto(nome);
        vinhos.save(vinho);
    }

}
