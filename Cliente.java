import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private Scanner sc;
    Carrinho carrinho;
    Cliente() {
        this.sc = new Scanner(System.in);
        this.carrinho = new Carrinho();
    }

    public boolean estaComprando() {
        return this.sc.hasNext();
    }

    public Comando receberComando() throws ComandoInvalido {
        String[] tokens = this.sc.nextLine().split("\\s");
        return new Comando(tokens);
    }
}