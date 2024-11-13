import java.util.Random;

public class OperacoesVetores01 {
  static int[] v = new int[10];
  static int size = 10;

  public static void main(String[] args) {
    preencherVetor(v);
    exibirVetor(v);
    removerPares(v);
    exibirVetor(v);
  }

  public static void preencherVetor(int[] v) {
    Random r = new Random();
    for (int i = 0; i < v.length; i++) {
      v[i] = r.nextInt(10) + 1;
    }
  }

  public static void exibirVetor(int[] v) {
    for (int i = 0; i < size; i++) {
      System.out.print(v[i] + " ");
    }
    System.out.println();
  }

  public static void removerPares(int[] v) {
    int n = 0;
    for (int i = 0; i < v.length; i++) {
      if (v[i] % 2 == 1) {
        v[n] = v[i];
        n++;
      }
    }
    size = n;
  }
}
