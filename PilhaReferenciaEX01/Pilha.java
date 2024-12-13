public class Pilha {
  int tam = 0;
  Carta topo;

  public boolean taVazia() {
    return tam == 0;
  }

  public int tamanho() {
    return tam;
  }

  public void push(Carta carta) {
    if (!taVazia())
      carta.prox = topo;
    topo = carta;
    ++tam;
  }

  public Carta pop() throws Exception {
    if (taVazia())
      throw new Exception("Lista Vazia.");
    Carta c = topo;
    topo = topo.prox;
    --tam;
    return c;
  }
}
