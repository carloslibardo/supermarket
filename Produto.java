public class Produto implements ProdutoInt {
    static int count = 0;
    int id;
    String descricao;
    double preco;
    String setor;
    public Produto(String descricao, double preco, String setor)  {
        this.id = ++Produto.count;
        this.descricao = descricao;
        this.preco = preco;
        this.setor = setor;
    }

    public String mostrarInfos() {
        return "ID:" + this.id + " | " + this.descricao + " | R$"+ this.preco;
    }

    public void mostrarDetalhes(Produto produto) {
        System.out.println(produto.mostrarInfos() + " | Setor: " + produto.setor);
    }
}