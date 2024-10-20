import java.util.Scanner;

public class Ex02 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    System.out.print("Deseja elevar 2 à qual potência? ");
    int n = scan.nextInt();
    System.out.printf("2^%d é igual à %d", n, pot(n));
    scan.close();
  }

  public static int pot(int n) {
    if (n == 0) {
      return 1;
    } else {
      return 2 * pot(n - 1);
    }
  }
}
