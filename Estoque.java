public interface Estoque {
    void mostrarProdutos();
    Produto procurarProduto(int ID) throws ProdutoInexistente;
    void pegarProdutoDe(ProdutoFonte outro, Produto produto, Integer qtd) throws QuantidadeInsuficiente, QuantidadeInvalida;
}
