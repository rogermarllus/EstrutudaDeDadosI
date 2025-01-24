public class Fila {
  private Elemento cabeca;
  private Elemento cauda;
  private int tam = 0;

  public void enfileirar(Elemento e) {
    if (tam != 0) {
      cauda.setProx(e);
    } else {
      cabeca = e;
    }
    cauda = e;
    tam++;
  }

  public Elemento desenfileirar() throws Exception {
    if (isVazia())
      throw new Exception("Fila vazia");
    Elemento el = cabeca;
    cabeca = cabeca.getProx();
    tam--;
    return el;
  }

  public boolean isVazia() {
    return tam == 0;
  }

  public int getTamanho() {
    return tam;
  }

  public String mostrarFila() throws Exception {
    StringBuilder f = new StringBuilder("[");
    for (int i = 0; i < tam; i++) {
      Elemento aux = this.desenfileirar();
      f.append(aux.elemento);
      this.enfileirar(aux);
      if (i < tam - 1) {
        f.append(", ");
      }
    }
    f.append("]");
    return f.toString();
  }
}