package br.icev.vendas;

import br.icev.vendas.excecoes.QuantidadeInvalidaException;
import br.icev.vendas.excecoes.SemEstoqueException;

    public class Estoque {
        private int quantidade;
        private String produto;
        private int codigo;

        // Construtor
        public Estoque(int quantidade, String produto, int codigo) {
            if (quantidade <= 0) {
                throw new IllegalArgumentException("Erro: quantidade deve ser maior que zero!");
            }
            this.quantidade = quantidade;
            this.produto = produto;
            this.codigo = codigo;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            if (quantidade < 0) {
                throw new IllegalArgumentException("Quantidade não pode ser negativa!");
            }
            this.quantidade = quantidade;
        }

        public String getProduto() {
            return produto;
        }

        public void setProduto(String produto) {
            this.produto = produto;
        }

        public void adicionarEstoque(int quantidade) throws QuantidadeInvalidaException {
            if (quantidade <= 0) {
                throw new QuantidadeInvalidaException("Quantidade para adicionar deve ser maior que zero!");
            }
            this.quantidade += quantidade;
        }

        public int getDisponivel() {
            return this.quantidade;
        }

        public void reservar(int quantidade)
                throws SemEstoqueException, QuantidadeInvalidaException {

            if (quantidade <= 0) {
                throw new QuantidadeInvalidaException("Quantidade inválida: " + quantidade);
            }

            if (quantidade > this.quantidade) {
                throw new SemEstoqueException("Estoque insuficiente: " + produto);
            }

            this.quantidade -= quantidade;
        }
    }

}
