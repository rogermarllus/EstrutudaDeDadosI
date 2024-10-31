import java.util.Random;

public class AnaliseAssintoticaEx01 {
  public static void main(String[] args) {
    int[] vetor = new int[10];
    Random random = new Random();

    for (int i = 0; i < vetor.length; i++) {
      vetor[i] = random.nextInt(100) + 1;
    }

    for (int num : vetor) {
      System.out.print(num + " ");
    }

    System.out.println("\nMaior: " + maiorMenor(vetor)[0]);
    System.out.println("Menor: " + maiorMenor(vetor)[1]);
  }

  public static int[] maiorMenor(int[] v) { // O(n) -> Linear
    int[] r = new int[2];
    r[0] = v[0];
    r[1] = v[0];
    for (int i = 0; i < v.length; i++) {
      if (v[i] > r[0]) {
        r[0] = v[i];
      }
      if (v[i] < r[1]) {
        r[1] = v[i];
      }
    }
    return r;
  }
}
