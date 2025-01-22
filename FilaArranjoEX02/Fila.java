public class Fila {
  static final int TAM_MAX = 100;
  int inicio = 0;
  int fim = 0;
  int tamanho = 0;

  Processo vetor[] = new Processo[TAM_MAX];

  public void enfileirar(Processo s) throws Exception {
    if (isFull())
      throw new Exception("Fila cheia");
    vetor[fim] = s;
    fim++;
    if (fim == TAM_MAX)
      fim = 0;

    tamanho++;
  }

  public Processo desenfileirar() throws Exception {
    if (isEmpty())
      throw new Exception("Fila vazia");
    Processo aux = vetor[inicio];
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
