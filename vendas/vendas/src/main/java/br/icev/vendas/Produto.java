package br.icev.vendas;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {

    private String codigo;
    private String nome;
    private BigDecimal precoUnitario;

    public Produto(String codigo, String nome, BigDecimal precoUnitario) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Não pode ser vazio.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Não pode ser vazio.");
        }
        if (precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
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
