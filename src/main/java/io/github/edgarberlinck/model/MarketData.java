package io.github.edgarberlinck.model;

import java.io.Serializable;
import java.math.BigDecimal;


public class MarketData implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5359381399354954085L;

    public MarketData(String preco) {
        this.preco = new BigDecimal(preco.replaceAll(",", "."));
    }

    private BigDecimal preco;
    /**
     * @return the preco
     */
    public BigDecimal getPreco() {
      return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(BigDecimal preco) {
      this.preco = preco;
    }
}