package io.github.edgarberlinck.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Operacao implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5359381399354954085L;

    public Operacao(String codigoOperacao, String nomeSubproduto, String quantidade) {
        this.codigoOperacao = codigoOperacao;
        this.nomeSubproduto = nomeSubproduto;
        this.quantidade = Integer.parseInt(quantidade);
    }

    @Getter @Setter
    private String codigoOperacao;
    @Getter @Setter
    private String nomeSubproduto;
    @Getter @Setter
    private Integer quantidade;
}