import java.util.Random;

public class OperacoesVetores02 {

  static int[] v = new int[5];
  static int proximaPosicao = 0;
  static int iteracaoAnt = 0;

  public static void main(String[] args) {
    preencherVetor(v);
    exibirVetor(v);
  }

  public static void exibirVetor(int[] v) {
    for (int i = 0; i < v.length; i++) {
      System.err.print(v[i] + " ");
    }
    System.out.println();
  }

  public static void preencherVetor(int[] v) {
    Random r = new Random();
    while (proximaPosicao < v.length) {
      switch (r.nextInt(3) + 1) {
        case 1:
          alocarInicio(v);
          System.out.println(v[0] + " Inserido no início.");
          break;
        case 2:
          alocarFinal(v);
          System.out.println(v[proximaPosicao - 1] + " Inserido no final.");
          break;
        default:
          if (iteracaoAnt == 0) {
            alocarInicio(v);
            System.out.println(v[iteracaoAnt] + " Inserido antes do início.");
          } else {
            alocarAntesIteracaoAnterior(v);
            System.out.println(v[iteracaoAnt] + " Inserido antes da iteração anterior.");
          }
          break;
      }
    }
  }

  public static void alocarInicio(int[] v) {
    Random r = new Random();
    if (!(proximaPosicao == 0)) {
      for (int i = proximaPosicao; i > 0; i--) {
        v[i] = v[i - 1];
      }
    }
    v[0] = r.nextInt();
    proximaPosicao++;
    iteracaoAnt = 0;
  }

  public static void alocarFinal(int[] v) {
    Random r = new Random();
    v[proximaPosicao] = r.nextInt();
    iteracaoAnt = proximaPosicao;
    proximaPosicao++;
  }

  public static void alocarAntesIteracaoAnterior(int[] v) {
    Random r = new Random();
    for (int i = proximaPosicao; i > iteracaoAnt; i--) {
      v[i] = v[i - 1];
    }
    v[iteracaoAnt] = r.nextInt();
    proximaPosicao++;
  }
}
