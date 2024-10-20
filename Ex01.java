import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Deseja utilizar a função 1) Fatorial ou 2) Fibonacci? ");
        int escolha = scan.nextInt();
        if (escolha == 1) {
            System.out.print("Informe um número: ");
            int n = scan.nextInt();
            System.out.printf("O Fatorial de %d é igual a %d", n, fat(n));
        } else if (escolha == 2) {
            System.out.print("Informe um número: ");
            int n = scan.nextInt();
            System.out.printf("O Fibonacci de %d é igual a %d", n, fibo(n));
        } else {
            System.out.println("Entrada inválida.");
        }
        scan.close();
    }

    public static long fat(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Informe um número positivo.");
        }
        long fat = 1;
        for (long i = 1; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }

    public static long fibo(long n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            long f1 = 0;
            long f2 = 1;

            for (long i = 2; i <= n; i++) {
                long fibo = f1 + f2;
                f1 = f2;
                f2 = fibo;
            }
            return f2;
        }
    }
}
