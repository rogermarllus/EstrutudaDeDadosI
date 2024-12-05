public class ListaEnc {
    public No cabeca = new No();
  public No cauda;
  public int tamanho;

  public ListaEnc() {
    this.cabeca = new No();
    this.cauda = cabeca;
    this.tamanho = 0;
  }

  public void add(Cidade c) {
    No elemento = new No(c, null, null);
    if (tamanho == 0) {
      cabeca.prox = elemento;
      elemento.ant = cabeca;
      cauda = elemento;
      tamanho++;
    } else {
      No noAtual = cabeca.prox;
      while (noAtual != null && noAtual.cidade.nota >= c.nota) {
        noAtual = noAtual.prox;
      }
      if (noAtual == null) {
        cauda.prox = elemento;
        elemento.ant = cauda;
        cauda = elemento;
      } else {
        elemento.prox = noAtual;
        elemento.ant = noAtual.ant;
        if (noAtual.ant != null) {
          noAtual.ant.prox = elemento;
        }
        noAtual.ant = elemento;
        if (noAtual == cabeca.prox) {
          cabeca.prox = elemento;
        }
      }
      tamanho++;
    }
  }

  public boolean remove(String nome, String pais) throws Exception {
    if (tamanho == 0) {
        throw new Exception("Lista vazia.");
    }
    No noAtual = cabeca.prox;
    boolean elementoEncontrado = false;
    while (noAtual != null) {
        if (noAtual.cidade.nome.equals(nome) && noAtual.cidade.pais.equals(pais)) {
            elementoEncontrado = true;
            break;
        }
        noAtual = noAtual.prox;
    }
    if (elementoEncontrado) {
        if (noAtual.prox != null) {
            noAtual.prox.ant = noAtual.ant;
            noAtual.ant.prox = noAtual.prox;
        } else {
            cauda = noAtual.ant;
            cauda.prox = null;
        }
        tamanho--;
    }
    return elementoEncontrado;
  }

  public void print() {
    No noAtual = cabeca.prox;
    while (noAtual != null) {
      System.out.println("[Nome: " + noAtual.cidade.nome + ", País: " + noAtual.cidade.pais + ", Atrativos: "
          + noAtual.cidade.atrativos + ", Nota: " + noAtual.cidade.nota + "]");
      noAtual = noAtual.prox;
    }
    System.out.println();
  }
}
