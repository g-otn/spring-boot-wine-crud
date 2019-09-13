package com.algaworks.vinho.service;

import com.algaworks.vinho.model.Vinho;
import com.algaworks.vinho.repository.Vinhos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroVinhoService {

    @Autowired
    private Vinhos vinhos;

    public void salvar(Vinho vinho) {
        // regras de neg�cio aqui

        this.vinhos.save(vinho);
    }

}
