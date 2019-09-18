package com.algaworks.vinho.service;

import com.algaworks.vinho.model.Vinho;
import com.algaworks.vinho.repository.Vinhos;
import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class CadastroVinhoService {

    @Autowired
    private Vinhos vinhos;

    @Autowired
    private AmazonS3 s3Client;

    public void salvar(Vinho vinho) {
        // regras de neg�cio aqui

        this.vinhos.save(vinho);
    }

    public String salvarFoto(Long codigo, MultipartFile foto) {
        Optional<Vinho> vinhoOptional = vinhos.findById(codigo);
        Vinho vinho = vinhoOptional.get();

        // Salva o nome da foto no banco de dados
        String nomeFoto = foto.getOriginalFilename();
        vinho.setFoto(nomeFoto);
        vinhos.save(vinho);

        // Salva a foto no S3
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(foto.getContentType());
            metadata.setContentLength(foto.getSize());
            s3Client.putObject("vinho", nomeFoto, foto.getInputStream(), metadata);
        } catch (AmazonClientException | IOException e) {
            throw new RuntimeException("Erro salvando arquivo no S3", e);
        }

        return "http://localhost:9444/s3/vinho/" + nomeFoto + "?noAuth=true";
    }

}
