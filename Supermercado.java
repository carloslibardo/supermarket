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
		System.out
				.print("Comandos disponíveis: 'lista', 'carrinho', 'detalhes' e 'comprar' \nDigite um dos comandos acima!\n");
		System.out
				.print("Para realizar a compra, deve-se digitar o comando 'comprar {ID DO PRODUTO} {QUANTIDADE DO PRODUTO}'\n");
		System.out.print("Para saber detalhes do produto, deve-se digitar o comando 'detalhes {ID DO PRODUTO}'\n");
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split("\\s");
			String comando = tokens[0];
			System.out.println("Comando: " + comando);
			switch (comando) {
			case "lista":
				mercado.estoque.mostrarProdutos();
				break;
			case "carrinho":
				carrinho.mostrarProdutos();
				break;
			case "detalhes": {
				if (tokens.length < 2) {
					System.out.println("Formato inválido: o formato de detalhes deve ser 'detalhes {ID DO PRODUTO}'");
					break;
				}
				int id = Integer.parseInt(tokens[1]);
				Produto produto = mercado.estoque.procurarProduto(id);
				mercado.estoque.mostrarDetalhes(produto);
				break;
			}
			case "comprar":
				if (tokens.length < 3) {
					System.out.println("Formato inválido: o formato de comprar deve ser 'comprar {ID DO PRODUTO} {QUANTIDADE DO PRODUTO}'");
					break;
				}
				int id = Integer.parseInt(tokens[1]);
				int qtd = Integer.parseInt(tokens[2]);
				Produto produto = mercado.estoque.procurarProduto(id);
				carrinho.pegarProdutoDe(mercado.estoque, produto, qtd);
				// this.estoque;
			default:
				System.out.println("Comando inexistente, tente novamente");
			}
			

		}
		sc.close(); // Encerra o programa
	}
}
