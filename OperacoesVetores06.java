import java.util.Random;

public class OperacoesVetores06 {
  public static void main(String[] args) {
    int[] v1 = { 1, 2, 3, 4, 5 };
    int[] v2 = { 6, 7, 8, 9, 10 };
    int[] v3 = preencheVetor(v1, v2);
    for (int i = 0; i < v3.length; i++) {
      System.out.print(v3[i] + " ");
    }
  }

  public static int[] preencheVetor(int[] v1, int[] v2) {
    Random r = new Random();
    int[] v3 = new int[v1.length];
    int indiceV1 = 0;
    int indiceV2 = 0;
    for (int i = 0; i < v3.length; i++) {
      if ((r.nextInt() % 2) == 0) {
        v3[i] = v1[indiceV1];
        indiceV1++;
      } else {
        v3[i] = v2[indiceV2];
        indiceV2++;
      }
    }
    return v3;
  }
}
