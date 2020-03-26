package io.github.edgarberlinck.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class DadoMercado implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5359381399354954085L;

    public DadoMercado(String preco) {
        this.preco = new BigDecimal(preco.replaceAll(",", "."));
    }

    @Getter @Setter
    private BigDecimal preco;
}