package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionar(Produto produto, int quantidade) throws QuantidadeInvalidaException {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("Deve ser maior que zero.");
        }
        if (produto == null) {
            throw new IllegalArgumentException("Não pode ser nulo.");
        }

        for (ItemCarrinho item : itens) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }

        ItemCarrinho novoItem = new ItemCarrinho(produto, quantidade);
        itens.add(novoItem);
    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;

        for (ItemCarrinho item : itens) {
            subtotal = subtotal.add(item.getValorTotal());
        }

        return subtotal;
    }

    public int getTotalItens() {
        int totalUnidades = 0;

        for (ItemCarrinho item : itens) {
            totalUnidades += item.getQuantidade();
        }

        return totalUnidades;
    }

    public BigDecimal getTotalCom(PoliticaDesconto politica) {
        if (politica == null) {
            throw new IllegalArgumentException("Não pode ser nula.");
        }

        BigDecimal subtotal = getSubtotal();
        return politica.aplicarDesconto(subtotal);
    }
}}