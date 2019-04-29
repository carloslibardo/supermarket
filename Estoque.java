import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Estoque extends RepositorioProduto {
    public Estoque(Map<Produto, Integer> produtos) {
        super(produtos);
    }
    public static Estoque defaultEstoque() {
        Map<Produto, Integer> produtos = new HashMap<Produto, Integer>();
        produtos.put(new Produto("Banana", 2.25, "Frutas"), new Integer(10));
        produtos.put(new Produto("Morango", 8.75, "Frutas"), new Integer(5));
        return new Estoque(produtos);
    }
}