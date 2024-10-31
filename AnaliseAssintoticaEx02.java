public class AnaliseAssintoticaEx02 {
  public static void main(String[] args) {
    int[] vetor = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    for (int num : vetor) {
      System.out.print(num + " ");
    }

    try {
      System.out.println("\n1º Maior: " + tresMaiores(vetor)[0]);
      System.out.println("2º Maior: " + tresMaiores(vetor)[1]);
      System.out.println("3º Maior: " + tresMaiores(vetor)[2]);
    } catch (Exception e) {
      System.out.println("Erro.");
    }
  }

  public static int[] tresMaiores(int[] v) throws Exception { // O(n) -> Linear
    if (v.length >= 3) {
      int[] r = new int[3];
      r[0] = v[0];
      r[1] = v[0];
      r[2] = v[0];
      for (int i = 0; i < v.length; i++) {
        if (v[i] > r[0]) {
          r[2] = r[1];
          r[1] = r[0];
          r[0] = v[i];
        } else if (v[i] > r[1] || v[i] == r[0]) {
          r[2] = r[1];
          r[1] = v[i];
        } else if (v[i] > r[2] || v[i] == r[1] || v[i] == r[0]) {
          r[2] = v[i];
        }
      }
      return r;
    } else {
      throw new Exception("O vetor deve ter pelo menos três elementos.");
    }
  }
}
