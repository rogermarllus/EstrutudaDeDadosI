public class Node {
  int valor;
  Node esquerda;
  Node direita;

  public Node(int valor) {
    this.valor = valor;
    this.esquerda = null;
    this.direita = null;
  }

  @Override
  public String toString() {
    return String.valueOf(this.valor);
  }
}