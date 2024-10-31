public class AnaliseAssintoticaEx03 {
  public static void main(String[] args) {
    int[] vetor = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

    for (int num : vetor) {
      System.out.print(num + " ");
    }

    if (contem(vetor, 5)) {
      System.out.println("\nO vetor contém o elemento: 5");
    } else {
      System.out.println("\nO vetor não contém o elemento: 5");
    }
  }

  public static boolean contem(int[] v, int x) { // O(logn) -> Logaritmo
    int inicio = 0;
    int fim = v.length - 1;
    while (inicio <= fim) {
      int meio = inicio + (fim - inicio) / 2;
      if (v[meio] == x) {
        return true;
      } else if (v[meio] < x) {
        inicio = meio + 1;
      } else {
        fim = meio - 1;
      }
    }
    return false;
  }
}
