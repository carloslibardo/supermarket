import java.util.Map;
import java.lang.Exception;

class QuantidadeInvalida extends Exception {
    public QuantidadeInvalida(String message) {
        super(message);
    }
}

class QuantidadeInsuficiente extends Exception {
    public QuantidadeInsuficiente(String message) {
        super(message);
    }
}

class ProdutoInexistente extends Exception {
    public ProdutoInexistente() {
        super("esse produto não existe");
    }
}

public abstract class RepositorioProduto {
    Map<Produto, Integer> produtos;

    public RepositorioProduto(Map<Produto, Integer> produtos) {
        this.produtos = produtos;
    }

    private void setQuantidadeProduto(Produto produto, Integer num) {
        Integer qtd = this.produtos.get(produto).intValue();
        this.produtos.put(produto, qtd + num);
    }

    public Produto procurarProduto(int id) throws ProdutoInexistente {
        for (Produto produto : this.produtos.keySet()) {
            if (produto.id == id) {
                return produto;
            }
        }
        throw new ProdutoInexistente();
    }

    public int qtdProduto(Produto produto) {
        return this.produtos.get(produto).intValue();
    }

    public void adicionarProduto(Produto produto, Integer num) throws QuantidadeInvalida {
        if (num < 0) {
            throw new QuantidadeInvalida("o número de produtos à adicionar não pode ser menor que zero");
        }
        Integer qtdInt = this.produtos.get(produto);
        int qtd = qtdInt != null ? qtdInt.intValue() : 0;
        this.produtos.put(produto, qtd + num);
    }

    public void removerProduto(Produto produto, Integer num) throws QuantidadeInvalida, QuantidadeInsuficiente {
        if (num < 0) {
            throw new QuantidadeInvalida("o número de produtos à remover não pode ser menor que zero");
        }
        Integer qtdInt = this.produtos.get(produto);
        int qtd = qtdInt != null ? qtdInt.intValue() : 0;
        if (qtd < num) {
            throw new QuantidadeInsuficiente(
                    "ocorreu uma tentativa de remoção de mais produtos do que há no repositório");
        }
        if (qtd - num == 0){
            this.produtos.remove(produto);
        } else {
            this.produtos.put(produto, qtd - num);
        }
    }

    public void pegarProdutoDe(RepositorioProduto outro, Produto produto, Integer qtd)
            throws QuantidadeInsuficiente, QuantidadeInvalida {
        try {
            outro.removerProduto(produto, qtd);
        } catch (QuantidadeInsuficiente e) {
            throw e;
        }
        this.adicionarProduto(produto, qtd);
    }

    public void mostrarProdutos(Boolean mostrarTotal) {
        Double precoTotal = 0.0;
        for (Map.Entry<Produto, Integer> entry : this.produtos.entrySet()) {
            Produto produto = entry.getKey();
            Integer qtd = entry.getValue();
            precoTotal += qtd * produto.preco;
            System.out.println(qtd.toString() + "x " + produto.toString());
        }
        if (mostrarTotal) {
            System.out.println("Preço total da compra é de R$:" + precoTotal);
        }
    }

    public void mostrarDetalhes(Produto produto) {
        System.out.println(produto.toString() + " | Setor: " + produto.setor);
    }
}