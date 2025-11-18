package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;

import java.math.BigDecimal;

public class Produto {
    private String codigo;
    private String nome;
    private BigDecimal precoUnitario;

    public Produto(String codigo, String nome, BigDecimal precoUnitario) {

       if (precoUnitario == null) {
           throw new NullPointerException("Preço não pode ser nulo!");
       }
       if (precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
           throw new IllegalArgumentException("Preço deve ser maior que zero");
       }

        this.codigo = codigo;
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return codigo != null && codigo.equals(produto.codigo);
    }

    @Override
    public int hashCode() {
        return (codigo == null) ? 0 : codigo.hashCode();
    }
}
