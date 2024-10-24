import java.util.Scanner;

public class Ex01Fat {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int n = scan.nextInt();
        if (n < 0) {
            System.out.println("Informe um número positivo.");
        } else {
            System.out.printf("O Fatorial de %d é igual a %d", n, fat(n));
        }
        scan.close();
    }

    public static long fat(long n) {
        long fat = 1;
        for (long i = 1; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }
}
