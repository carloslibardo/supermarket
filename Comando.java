class ComandoInvalido extends Exception {
    ComandoInvalido(String msg) {
        super(msg);
    }
}

public class Comando {
    String nome;
    int idProduto, qtd;
    Comando(String[] tokens) throws ComandoInvalido {
        this.nome = tokens[0];
        switch(this.nome) {
            case "detalhes":
                if (tokens.length < 2) {
                    throw new ComandoInvalido("Formato inválido: o formato de detalhes deve ser 'detalhes {ID DO PRODUTO}'");
                }
                this.idProduto = Integer.parseInt(tokens[1]);
                break;
            case "comprar":
                if (tokens.length < 3) {
                    throw new ComandoInvalido("Formato inválido: o formato de comprar deve ser 'comprar {ID DO PRODUTO} {QUANTIDADE DO PRODUTO}'");
                }
                this.idProduto = Integer.parseInt(tokens[1]);
                this.qtd = Integer.parseInt(tokens[2]);
                break;
            case "remove":
                if (tokens.length < 3) {
                    throw new ComandoInvalido("Formato inválido: o formato de remover um produto deve ser 'remove {ID DO PRODUTO} {QUANTIDADE DO PRODUTO}'");
                }
                this.idProduto = Integer.parseInt(tokens[1]);
                this.qtd = Integer.parseInt(tokens[2]);
                break;
            case "lista":
            case "carrinho":
            case "finalizar":
                break;
            default:
                throw new ComandoInvalido("Comando inexistente");
        }
    }
}