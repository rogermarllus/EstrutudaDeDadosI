import java.util.Scanner;

public class Ex01Fibo {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int n = scan.nextInt();
        
        long[] fiboSeq = fibo(n);
        System.out.printf("Os primeiros %d números da sequência de Fibonacci são: ", n);
        for (long num : fiboSeq) {
            System.out.print(num + " ");
        }
        
        scan.close();
    }

    public static long[] fibo(int n) {
        long[] fiboSeq = new long[n];
        
        if (n >= 1) fiboSeq[0] = 0;
        if (n >= 2) fiboSeq[1] = 1;

        for (int i = 2; i < n; i++) {
            fiboSeq[i] = fiboSeq[i - 1] + fiboSeq[i - 2];
        }
        
        return fiboSeq;
    }
}
