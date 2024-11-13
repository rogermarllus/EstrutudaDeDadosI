public class OperacoesVetores05 {
  public static void main(String[] args) {
    int[] v = { 4, 7, 2, 3, 9, 10, 1, 5, 8, 6 };
    exibirVetorCrescente(v);
  }

  private static void exibirVetorCrescente(int[] v) {
    int menorValor = Integer.MIN_VALUE;
    for (int i = 0; i < v.length; i++) {
      int proximoMenor = Integer.MAX_VALUE;
      for (int j = 0; j < v.length; j++) {
        if (v[j] > menorValor && v[j] < proximoMenor) {
          proximoMenor = v[j];
        }
      }
      System.out.print(proximoMenor + " ");
      menorValor = proximoMenor;
    }
  }
}
