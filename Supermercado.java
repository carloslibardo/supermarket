import java.util.Map;

public class Supermercado {
	Estoque estoque;

	Supermercado(Estoque estoque) {
		this.estoque = estoque;
	}


	void mostrarPrompt() {
		System.out.print("> ");
	}

	void receberCliente(Cliente cliente) {
		System.out.println("Comandos disponíveis: 'lista', 'carrinho', 'detalhes' e 'comprar'");
		System.out.println("Digite um dos comandos acima!");
		System.out.println("Para realizar a compra, deve-se digitar o comando 'comprar {ID DO PRODUTO} {QUANTIDADE DO PRODUTO}'");
		System.out.println("Para saber detalhes do produto, deve-se digitar o comando 'detalhes {ID DO PRODUTO}'");
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
						this.estoque.mostrarDetalhes(produto);
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

	public static void main(String[] args){
		Supermercado mercado = new Supermercado(Estoque.defaultEstoque());
		Cliente cliente = new Cliente();
		mercado.receberCliente(cliente);
	}
}
