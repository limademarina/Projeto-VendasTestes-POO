package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static class ItemCarrinho {
        Produto produto;
        int quantidade;

        ItemCarrinho(Produto p, int q) {
            produto = p;
            quantidade = q;
        }
    }

    private List<ItemCarrinho> itens = new ArrayList<>();

    public Carrinho() {}

    public void adicionar(Produto p, int quantidade) throws QuantidadeInvalidaException {
        if (quantidade <= 0) {
            throw new QuantidadeInvalidaException("Quantidade inválida!");
        }

        // se já existe item com mesmo código → acumular
        for (ItemCarrinho item : itens) {
            if (item.produto.getCodigo().equals(p.getCodigo())) {
                item.quantidade += quantidade;
                return;
            }
        }

        // senão, adicionar novo
        itens.add(new ItemCarrinho(p, quantidade));
    }

    public int getTotalItens() {
        int soma = 0;
        for (ItemCarrinho item : itens) {
            soma += item.quantidade;
        }
        return soma;
    }

    public BigDecimal getSubtotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (ItemCarrinho item : itens) {
            BigDecimal parcial = item.produto.getPrecoUnitario()
                    .multiply(BigDecimal.valueOf(item.quantidade));
            total = total.add(parcial);
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalCom(PoliticaDesconto politica) {
        BigDecimal subtotal = getSubtotal();
        BigDecimal total = politica.aplicar(subtotal);

        if (total.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }

        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
