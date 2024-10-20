import java.util.Scanner;

public class Ex05 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.print("Informe um número positivo: ");
    int n1 = scan.nextInt();
    System.out.print("Informe outro número positivo: ");
    int n2 = scan.nextInt();
    if (n1 > 0 && n2 > 0) {
      System.out.printf("O máximo divisor comum entre %d e %d é igual à: %d", n1, n2, maxDivComum(n1, n2));
    } else {
      System.out.println("Uma ou mais entradas inválidas.");
    }
    scan.close();
  }

  public static int maxDivComum(int n1, int n2) {
    if (n1 >= n2 && n1 % n2 == 0) {
      return n2;
    } else if (n1 < n2) {
      return maxDivComum(n2, n1);
    } else {
      return maxDivComum(n2, n1 % n2);
    }
  }
}
