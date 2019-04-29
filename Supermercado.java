import java.util.Map;
import java.util.Scanner;

public class Supermercado {
	Estoque estoque;
	Supermercado(Estoque estoque) {
		this.estoque = estoque;
	}
	public static void main(String[] args) throws QuantidadeInsuficiente, QuantidadeInvalida, ProdutoInexistente {
		Supermercado mercado = new Supermercado(Estoque.defaultEstoque());
		Carrinho carrinho = new Carrinho();
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um texto:");
		while(sc.hasNext()){
			String[] tokens = sc.nextLine().split("\\s");
			String comando = tokens[0];
			System.out.println("Comando: "+ comando);
			switch (comando) {
			case "lista":
				mercado.estoque.mostrarProdutos();
				break;
			case "carrinho":
				carrinho.mostrarProdutos();
				break;
			case "comprar":
				if (tokens.length < 3) {
					System.out.println("comando de compra inválido");
					return;
				}
				int id = Integer.parseInt(tokens[1]);
				int qtd = Integer.parseInt(tokens[2]);
				Produto produto = mercado.estoque.procurarProduto(id);
				carrinho.pegarProdutoDe(mercado.estoque, produto, qtd);
				// this.estoque;
			}
		  }
		sc.close(); //Encerra o programa
	}
}
