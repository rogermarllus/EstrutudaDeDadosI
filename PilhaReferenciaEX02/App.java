import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();
        System.out.print("Informe o valor de entrada para o Iccanobif: ");
        int entrada = scanner.nextInt();
        fibo(entrada, pilha);
        imprime(pilha);
        scanner.close();
    }

    public static void fibo(int n, Pilha pilha) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n; i++) {
            pilha.push(new Celula(a));
            int temp = a;
            a = b;
            b = temp + b;
        }
    }

    public static void imprime(Pilha pilha) {
        try {
            while (!pilha.taVazia()) {
                System.out.print(pilha.pop().val + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
