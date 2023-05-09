// Aluno: Pedro Henrique Zandonai Persch
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        // Apresentação do Jogo
        System.out.println(" _                                    _       _     _ \n" +
                "| |                                  | |     | |   (_)\n" +
                "| |_ __ _ _ __ ___   __ _  __ _  ___ | |_ ___| |__  _ \n" +
                "| __/ _` | '_ ` _ \\ / _` |/ _` |/ _ \\| __/ __| '_ \\| |\n" +
                "| || (_| | | | | | | (_| | (_| | (_) | || (__| | | | |\n" +
                " \\__\\__,_|_| |_| |_|\\__,_|\\__, |\\___/ \\__\\___|_| |_|_|\n" +
                "                           __/ |                      \n" +
                "                          |___/      ");
        System.out.println();

        // Instância o Tamagotchi
        Tamagotchi t = new Tamagotchi(Teclado.leString("Digite o nome do seu novo Tamagotchi: "), 0, 1, false);

        // Cria a iteração para que o programa rode até o Tamagotchi morrer
        while (!t.getMorto()) {
            // Gera um número aleatório
            Random aleatorio = new Random();
            int valorAleatorio = aleatorio.nextInt(6)+1;

            // Atribui o número aleatório a um método de ação do Tamagotchi
            if (valorAleatorio <= 3) {
                t.fome();
            } else if (valorAleatorio <= 5) {
                t.entediado();
            } else{
                t.sono();
            }
        }
    }
}