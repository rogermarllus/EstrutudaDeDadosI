public class Fila {
  static final int TAM_MAX = 50;
  int inicio = 0;
  int fim = 0;
  int tamanho = 0;

  String vetor[] = new String[TAM_MAX];

  public void enfileirar(String s) throws Exception {
    if (isFull())
      throw new Exception("Fila cheia");
    vetor[fim] = s;
    fim++;
    if (fim == TAM_MAX)
      fim = 0;

    tamanho++;
  }

  public String desenfileirar() throws Exception {
    if (isEmpty())
      throw new Exception("Fila vazia");
    String aux = vetor[inicio];
    inicio++;
    if (inicio == TAM_MAX)
      inicio = 0;
    tamanho--;
    return aux;
  }

  public boolean isFull() {
    return tamanho == TAM_MAX;
  }

  public boolean isEmpty() {
    return tamanho == 0;
  }

}
