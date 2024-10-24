import java.util.Scanner;

public class Ex03 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.print("Informe um número: ");
    int n = scan.nextInt();
    if (isPrimo(n)) {
      System.out.printf("%d é primo.", n);
    } else {
      System.out.printf("%d não é primo.", n);
    }
    scan.close();
  }

  public static boolean isPrimo(int n) {
    return isPrimo(n, 3);
  }

  public static boolean isPrimo(int n, int d) {
    if (n == 2) {
      return true;
    }
    if (n < 2 || n % 2 == 0) {
      return false;
    }
    if (d * d > n) {
      return true;
    }
    if (n % d == 0) {
      return false;
    }
    return isPrimo(n, d + 2);
  }
}
