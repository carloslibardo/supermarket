public class Produto {
    static int count = 0;
    int id;
    String descricao;
    double preco;
    public Produto(String descricao, double preco) {
        this.id = ++Produto.count;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ID:" + this.id + " | " + this.descricao + " | R$"+ this.preco ;
    }
}