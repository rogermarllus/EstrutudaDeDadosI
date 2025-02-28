import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
  Node raiz = null;

  public void inserir(Node no, int valor) {
    if (no != null) {
      if (valor < no.valor) {
        if (no.esquerda != null)
          inserir(no.esquerda, valor);
        else
          no.esquerda = new Node(valor);
      } else {
        if (no.direita != null)
          inserir(no.direita, valor);
        else
          no.direita = new Node(valor);
      }
    } else {
      raiz = new Node(valor);
    }
  }

  public Node remover(int valor) throws Exception {
    return remover(this.raiz, valor);
  }

  public Node remover(Node no, int valor) throws Exception {
    boolean ajuste = false;
    if (no == null)
      throw new Exception("Valor não encontrado");
    if (this.raiz == null)
      throw new Exception("Árvore vazia");
    else {
      if (valor < no.valor) {
        no.esquerda = remover(no.esquerda, valor);
      } else if (valor > no.valor) {
        no.direita = remover(no.direita, valor);
      } else {
        if (no.direita != null && no.esquerda != null) {
          no.valor = minimo(no.direita).valor;
          no.direita = removeMinimo(no.direita);
        } else {
          if (no == raiz) {
            ajuste = true;
          }
          no = (no.esquerda != null) ? no.esquerda : no.direita;
          if (ajuste)
            raiz = no;
        }
      }
      return no;
    }
  }

  public Node minimo(Node no) throws Exception {
    if (no == null)
      throw new Exception("Raiz nula");
    if (no.esquerda != null)
      return minimo(no.esquerda);
    else
      return no;
  }

  public Node removeMinimo(Node no) throws Exception {
    if (no == null)
      throw new Exception("Raiz nula");
    else if (no.esquerda != null) {
      no.esquerda = (removeMinimo(no.esquerda));
      return no;
    } else {
      return no.direita;
    }
  }

  public void imprimeMenorPorNivel() {
    if (raiz == null) {
      return;
    }
    Queue<Node> fila = new LinkedList<>();
    fila.add(raiz);
    int nivel = 0;
    while (!fila.isEmpty()) {
      int size = fila.size();
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < size; i++) {
        Node atual = fila.poll();
        min = Math.min(min, atual.valor);
        if (atual.esquerda != null) {
          fila.add(atual.esquerda);
        }
        if (atual.direita != null) {
          fila.add(atual.direita);
        }
      }
      System.out.println(nivel + " " + min + " ");
      nivel++;
    }
  }

  public void preOrdem(Node no) {
    if (no != null) {
      System.out.print(no + " ");
      preOrdem(no.esquerda);
      preOrdem(no.direita);
    }
  }

  public void inOrdem(Node no) {
    if (no != null) {
      inOrdem(no.esquerda);
      System.out.print(no + " ");
      inOrdem(no.direita);
    }
  }

  public void posOrdem(Node no) {
    if (no != null) {
      posOrdem(no.esquerda);
      posOrdem(no.direita);
      System.out.print(no + " ");
    }
  }
}
