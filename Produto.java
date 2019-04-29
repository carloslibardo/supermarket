public class Produto {
    static int count = 0;
    int id;
    String descricao;
    double preco;
    String setor;
    public Produto(String descricao, double preco, String setor) {
        this.id = ++Produto.count;
        this.descricao = descricao;
        this.preco = preco;
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "ID:" + this.id + " | " + this.descricao + " | R$"+ this.preco ;
    }
}