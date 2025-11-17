package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;
import br.icev.vendas.excecoes.SemEstoqueException;

public class Estoque {
    private int quantidade;
    private String codigo;

    public Estoque() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws QuantidadeInvalidaException {
        if (quantidade < 0) {
            throw new QuantidadeInvalidaException("Quantidade não pode ser negativa!");
        }
        this.quantidade = quantidade;
    }

    public void adicionarEstoque(String codigo, int quantidade) throws QuantidadeInvalidaException {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("Quantidade não pode ser negativa!");
        }
        setCodigo(codigo);
        setQuantidade(quantidade);
    }

    public int getDisponivel(String codigo) {
        if (!this.codigo.equals(codigo)) {
            System.out.println("codigo invalido");
        }
        return this.quantidade;
    }

    public void reservar(String codigo, int quantidade)
            throws SemEstoqueException {
        if (this.quantidade <= quantidade) {
            throw new SemEstoqueException("Sem estoque!");
        }
        this.quantidade = this.quantidade - quantidade;
    }
}
