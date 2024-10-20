import java.util.Scanner;

public class Ex04 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.print("Informe um número: ");
    int n1 = scan.nextInt();
    System.out.print("Informe outro número: ");
    int n2 = scan.nextInt();
    System.out.printf("%d*%d é igual à: %d", n1, n2, mul(n1, n2));
    scan.close();
  }

  public static int mul(int n1, int n2) {
    if (n2 == 0) {
      return 0;
    }
    if (n2 < 0) {
      return -mul(n1, -n2);
    }
    return n1 + mul(n1, n2 - 1);
  }
}
