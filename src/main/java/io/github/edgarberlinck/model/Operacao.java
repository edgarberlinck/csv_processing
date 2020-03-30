package io.github.edgarberlinck.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

// @TODO Should be in english
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

  private String codigoOperacao;
  private String nomeSubproduto;
  private Integer quantidade;

  /**
   * @return the codigoOperacao
   */
  public String getCodigoOperacao() {
    return codigoOperacao;
  }

  /**
   * @return the nomeSubproduto
   */
  public String getNomeSubproduto() {
    return nomeSubproduto;
  }

  /**
   * @return the quantidade
   */
  public Integer getQuantidade() {
    return quantidade;
  }

  /**
   * @param codigoOperacao the codigoOperacao to set
   */
  public void setCodigoOperacao(String codigoOperacao) {
    this.codigoOperacao = codigoOperacao;
  }

  /**
   * @param nomeSubproduto the nomeSubproduto to set
   */
  public void setNomeSubproduto(String nomeSubproduto) {
    this.nomeSubproduto = nomeSubproduto;
  }
  
  /**
   * @param quantidade the quantidade to set
   */
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  @Override
    public boolean equals(Object obj) {
      if (obj instanceof Operacao) {
        Operacao given = (Operacao) obj;
        return (given.codigoOperacao.equals(this.codigoOperacao))
                && (given.nomeSubproduto.equals(this.nomeSubproduto)) && (given.quantidade.equals(this.quantidade));
      }
      return false;
    }
}