package com.algaworks.vinho.model;

public enum TipoVinho {

    TINTO("Tinto"),
    BRANCO("Branco"),
    ROSE("Rosé");

    private String descricao;

    TipoVinho(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
