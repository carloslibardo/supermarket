public interface Estoque extends ProdutoFonte {
    void mostrarProdutos();
    void mostrarDetalhes(Produto produto) throws ProdutoInexistente;
    Produto procurarProduto(int ID) throws ProdutoInexistente;
    void pegarProdutoDe(ProdutoFonte outro, Produto produto, Integer qtd) throws QuantidadeInsuficiente, QuantidadeInvalida;
    void removerProduto(Produto produto, Integer num) throws QuantidadeInvalida, QuantidadeInsuficiente;
}
