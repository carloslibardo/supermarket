import java.util.HashMap;
import java.util.Map;

public class Carrinho extends RepositorioProduto {
    public Carrinho() {
        super(new HashMap<Produto, Integer>());
    }

    public Double totalDaCompra() {
        Double precoTotal = 0.0;
        for (Map.Entry<Produto, Integer> entry : this.produtos.entrySet()) {
            Produto produto = entry.getKey();
            Integer qtd = entry.getValue();
            precoTotal += qtd * produto.preco;
        }
        return precoTotal;
    }

    @Override
    public void mostrarProdutos() {
        super.mostrarProdutos();
        System.out.println("Preço total da compra é de R$" + this.totalDaCompra());
    }
}