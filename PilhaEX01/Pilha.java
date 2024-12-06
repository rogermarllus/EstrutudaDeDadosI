public class Pilha {
  int[] pilha;
  int tamanho;
  int topo;

  public Pilha(int t) {
    this.tamanho = t;
    this.pilha = new int[this.tamanho];
    this.topo = -1;
  }

  public void push(int vagao) throws Exception {
    if (taCheio())
      throw new Exception("Lista Cheia.");
    pilha[++topo] = vagao;
  }

  public int pop() throws Exception {
    if (taVazio())
      throw new Exception("Lista Vazia.");
    return pilha[topo--];
  }

  public int top() throws Exception {
    if (taVazio())
      throw new Exception("Lista Vazia.");
    return pilha[topo];
  }

  public boolean taCheio() {
    return topo == tamanho - 1;
  }

  public boolean taVazio() {
    return topo == -1;
  }

  public int pegarTamanho() {
    return topo + 1;
  }

  public void print() {
    for (int i = 0; i < pegarTamanho() - 1; i++) {
      System.out.print(pilha[i] + ", ");
    }
  }
}
