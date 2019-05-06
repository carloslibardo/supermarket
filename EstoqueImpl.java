import java.util.HashMap;
import java.util.Map;

public class EstoqueImpl extends RepositorioProduto implements Estoque, ProdutoFonte  {
    public EstoqueImpl(Map<Produto, Integer> produtos) {
        super(produtos);
    }
    public static Estoque estoquePadrao() {
        Map<Produto, Integer> produtos = new HashMap<Produto, Integer>();
        produtos.put(new Produto("Banana", 2.25, "Frutas"), new Integer(10));
        produtos.put(new Produto("Morango", 8.75, "Frutas"), new Integer(5));
        produtos.put(new Produto("Detergente", 1.95, "Limpeza"), new Integer(5));
        produtos.put(new Produto("Amaciente 1L", 9.29, "Limpeza"), new Integer(5));
        return new EstoqueImpl(produtos);
    }
}