public interface EstoqueInt extends ProdutoFonte {
    void mostrarProdutos();
    Produto procurarProduto(int ID) throws ProdutoInexistente;
    void pegarProdutoDe(ProdutoFonte outro, Produto produto, Integer qtd) throws QuantidadeInsuficiente, QuantidadeInvalida;
    void removerProduto(Produto produto, Integer num) throws QuantidadeInvalida, QuantidadeInsuficiente;
}
