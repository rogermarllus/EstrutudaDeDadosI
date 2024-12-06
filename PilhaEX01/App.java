import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        StringBuilder resultado = new StringBuilder();

        while (true) {
            int n = teclado.nextInt();
            if (n == 0)
                break;
            while (true) {
                int[] ordemSaida = new int[n];
                ordemSaida[0] = teclado.nextInt();
                if (ordemSaida[0] == 0)
                    break;
                for (int i = 1; i < n; i++) {
                    ordemSaida[i] = teclado.nextInt();
                }
                if (isPossible(ordemSaida, n)) {
                    resultado.append("Yes\n");
                } else {
                    resultado.append("No\n");
                }
            }
            resultado.append("\n");
        }
        System.out.print(resultado);
        teclado.close();
    }

    private static boolean isPossible(int[] ordemSaida, int n) {
        Pilha estacao = new Pilha(n);
        int atual = 1;
        for (int elementoSaida : ordemSaida) {
            try {
                while (atual <= n && (estacao.taVazio() || estacao.top() != elementoSaida)) {
                    estacao.push(atual);
                    atual++;
                }

                if (estacao.top() == elementoSaida) {
                    estacao.pop();
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
