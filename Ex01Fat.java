import java.util.Scanner;

public class Ex01Fat {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int n = scan.nextInt();
        System.out.printf("O Fatorial de %d é igual a %d", n, fat(n));
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
