public class Supermercado {
	Estoque estoque;

	Supermercado(Estoque estoque) {
		this.estoque = estoque;
	}


	void mostrarPrompt() {
		System.out.print("> ");
	}

	void mostrarBoasVindas() {
		System.out.println("╔═════════════════════╦══════════════════════════════════════╦═════════════════════╗");
		System.out.println("║                     ║ Seja bem-vindo ao Supermercado 2000! ║                     ║");
		System.out.println("║                     ╚══════════════════════════════════════╝                     ║");
		System.out.println("║ lista                - lista os items no estoque do supermercado                 ║");
		System.out.println("║ detalhes [ID]        - mostra os detalhes do produto com ID=[ID]                 ║");
		System.out.println("║ comprar  [ID] [QTD]  - adiciona [QTD] produtos com ID=[ID] ao carrinho           ║");
		System.out.println("║ remove   [ID] [QTD]  - remove [QTD] produtos com ID=[ID] do carrinho             ║");
		System.out.println("║ carrinho             - mostra os items no carrinho                               ║");
		System.out.println("║ finalizar            - mostra o valor total dos produtos adicionados ao carrinho ║");
		System.out.println("╚══════════════════════════════════════════════════════════════════════════════════╝");
	}

	void receberCliente(Cliente cliente) {
		this.mostrarBoasVindas();
		this.mostrarPrompt();
		while (cliente.estaComprando()) {
			Comando comando;
			try {
				comando = cliente.receberComando();
			} catch (ComandoInvalido e) {
				System.out.println(e);
				this.mostrarPrompt();
				continue;
			}

			try {
				switch (comando.nome) {
					case "lista":
						this.estoque.mostrarProdutos();
						break;
					case "carrinho":
						cliente.carrinho.mostrarProdutos();
						break;
					case "detalhes": {
						Produto produto = this.estoque.procurarProduto(comando.idProduto);
						produto.mostrarDetalhes();
						break;
					}
					case "comprar": {
						Produto produto = this.estoque.procurarProduto(comando.idProduto);
						cliente.carrinho.pegarProdutoDe(this.estoque, produto, comando.qtd);
						System.out.println("Foi adicionado " + comando.qtd + " " + produto.descricao + " no seu carrinho!");
						break;
					}
					case "remove": {
						Produto produto = this.estoque.procurarProduto(comando.idProduto);
						this.estoque.pegarProdutoDe(cliente.carrinho, produto, comando.qtd);
						System.out.println("Foi removido " + comando.qtd + " " + produto.descricao + " do seu carrinho!");
						break;
					}
					case "finalizar": {
						System.out.println("O total da compra é R$" + cliente.carrinho.totalDaCompra());
						cliente.carrinho.esvaziar();
						break;
					}
				}
				this.mostrarPrompt();
			} catch (Exception e) {
				System.out.println(e);
				this.mostrarPrompt();
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Estoque estoque = EstoqueImpl.estoquePadrao();
		Supermercado mercado = new Supermercado(estoque);
		Cliente cliente = new Cliente();
		mercado.receberCliente(cliente);
	}
}
