import java.util.Scanner;

public class App {
    static int controle = 0;
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int qtdVagoes = -1;
        while (qtdVagoes != 0) {
            qtdVagoes = teclado.nextInt();
            if (qtdVagoes == 0) {
                break;
            }
            teclado.nextLine();
            String entrada = teclado.nextLine();
            String saida = teclado.nextLine();
            char[] ordemEntrada = new char[qtdVagoes];
            char[] ordemSaida = new char[qtdVagoes];
            for (int i = 0; i < qtdVagoes; i++) {
                ordemEntrada[i] = entrada.charAt(i);
                ordemSaida[i] = saida.charAt(i);
            }
            verifica(ordemEntrada, ordemSaida);
            System.out.println();
            System.out.println();
        }
        teclado.close();
    }

    public static void verifica(char[] ordemEntrada, char[] ordemSaida) {
        try {
            Pilha estacao = new Pilha();
            controle = 0;
            for (int i = 0; i < ordemEntrada.length; i++) {
                estacao.push(new Vagao(ordemEntrada[i]));
                System.out.print("I");
                compara(estacao, ordemSaida);
            }
            while (controle < ordemSaida.length) {
                if (estacao.topo.vagao == ordemSaida[controle]) {        
                    estacao.pop();
                    controle++;
                    System.out.print("R");
                } else {
                    System.out.print(" Impossible");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void compara(Pilha estacao, char[] ordemSaida) throws Exception {
        if (!(estacao.taVazia())) {
            if (estacao.topo.vagao == ordemSaida[controle]) {        
                estacao.pop();
                controle++;
                System.out.print("R");
                compara(estacao, ordemSaida);
            } else {
                return;
            }
        }
    }
}
