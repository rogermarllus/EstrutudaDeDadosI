import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pilha deck1 = new Pilha();
        Pilha deck2 = new Pilha();
        int pontuacao1 = 0;
        int pontuacao2 = 0;

        System.out.println("Jogador 1, suas cartas iniciais são:");
        Carta c = new Carta();
        System.out.print("|" + c.valor + "|");
        pontuacao1 += c.valor;
        deck1.push(c);
        c = new Carta();
        System.out.println("|" + c.valor + "|");
        pontuacao1 += c.valor;
        deck1.push(c);
        pontuacao1 = iniciarRodada(pontuacao1, deck1, s);

        System.out.println("Jogador 2, suas cartas iniciais são:");
        c = new Carta();
        System.out.print("|" + c.valor + "|");
        pontuacao2 += c.valor;
        deck2.push(c);
        c = new Carta();
        System.out.println("|" + c.valor + "|");
        pontuacao2 += c.valor;
        deck2.push(c);
        pontuacao2 = iniciarRodada(pontuacao2, deck2, s);

        verificarGanhador(pontuacao1, pontuacao2, deck1, deck2);
        s.close();
    }

    private static void verificarGanhador(int p1, int p2, Pilha deck1, Pilha deck2) {
        int pontos1 = 21 - p1;
        int pontos2 = 21 - p2;
        if (pontos1 < pontos2) {
            System.out.println("\nJogador 1 venceu!\nPontuação: " + p1);
            System.out.println("Cartas:");
            try {
                while (!deck1.taVazia()) {
                    System.out.print("|" + deck1.pop().valor + "|");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (pontos2 < pontos1) {
            System.out.println("\nJogador 2 venceu!\nPontuação: " + p2);
            System.out.println("Cartas:");
            try {
                while (!deck2.taVazia()) {
                    System.out.print("|" + deck2.pop().valor + "|");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Empate!");
        }
    }

    public static int iniciarRodada(int pontuacao, Pilha deck, Scanner s) {
        int escolha = 1;
        while (escolha == 1) {
            System.out.printf("\nPontuação Atual: %d\nDeseja pegar mais uma carta?\n1) Sim \n2) Não\nR: ", pontuacao);
            escolha = s.nextInt();
            if (escolha == 1) {
                Carta c = new Carta();
                System.out.println("|" + c.valor + "|");
                pontuacao += c.valor;
                deck.push(c);
                if (pontuacao > 21) {
                    System.out.printf("Pontuação Atual: %d\n", pontuacao);
                    try {
                        pontuacao -= deck.pop().valor;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    pontuacao -= 5;
                    System.out.printf("Pontuação Atual: %d\n(Descarte da última carta e penalidade de -5 aplicada).\n",
                            pontuacao);
                    break;
                }
            }
        }
        return pontuacao;
    }
}
