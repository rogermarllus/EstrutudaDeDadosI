import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int entradas = teclado.nextInt();
        teclado.nextLine();
        int[] respostas = new int[entradas];
        for (int i = 0; i < entradas; i++) {
            int diamantesFormados = 0;
            String minaStr = teclado.nextLine();
            Pilha diamantes = new Pilha(minaStr.length());
            for (int j = 0; j < minaStr.length(); j++) {
                if ("<".equals(String.valueOf(minaStr.charAt(j)))) {
                    diamantes.push(String.valueOf(minaStr.charAt(j)));
                } if (">".equals(String.valueOf(minaStr.charAt(j))) && !(diamantes.taVazio())) {
                    diamantes.pop();
                    diamantesFormados++;
                }
            }
            respostas[i] = diamantesFormados;
        }
        for (int i = 0; i < respostas.length; i++) {
            System.out.println(respostas[i]);
        }
        teclado.close();
    }
}
