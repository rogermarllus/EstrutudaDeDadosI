public class Pilha {
  int tam = 0;
  Celula topo;

  public boolean taVazia() {
    return tam == 0;
  }

  public int tamanho() {
    return tam;
  }

  public void push(Celula cel) {
    if (!taVazia())
      cel.prox = topo;
    topo = cel;
    ++tam;
  }

  public Celula pop() throws Exception {
    if (taVazia())
      throw new Exception("Lista Vazia.");
    Celula c = topo;
    topo = topo.prox;
    --tam;
    return c;
  }
}
