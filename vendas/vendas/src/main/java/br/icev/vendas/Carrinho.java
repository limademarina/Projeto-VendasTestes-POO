package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {

//    private List<ItemCarrinho> intens = new ArrayList<>();

    public void adicionar(Produto produto, int quantidade) throws QuantidadeInvalidaException {
        if (quantidade <= 0)
            throw new UnsupportedOperationException("TODO");//DUVIDA
    }

    public BigDecimal getSubtotal() {
        throw new UnsupportedOperationException("TODO");
    }

    public BigDecimal getTotalCom(PoliticaDesconto politica) {
        throw new UnsupportedOperationException("TODO");
    }

    public int getTotalItens() {
        throw new UnsupportedOperationException("TODO");
    }
}
