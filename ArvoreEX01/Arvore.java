public class Arvore {
  Aluno raiz = null;

  public void inserir(Aluno root, Aluno aluno) {
    if (root != null) {
      if (aluno.matricula < root.matricula) {
        if (root.esquerda != null) {
          inserir(root.esquerda, aluno);
        } else {
          root.esquerda = aluno;
        }
      } else {
        if (root.direita != null) {
          inserir(root.direita, aluno);
        } else {
          root.direita = aluno;
        }
      }
    } else {
      raiz = aluno;
    }
  }

  public Aluno excluir(int matricula) throws Exception {
    return excluir(raiz, matricula);
  }

  public Aluno excluir(Aluno root, int matricula) throws Exception {
    boolean ajuste = false;
    if (root == null) {
      throw new Exception("Aluno não encontrado");
    }
    if (this.raiz == null) {
      throw new Exception("Árvore vazia");
    } else {
      if (matricula < root.matricula) {
        root.esquerda = excluir(root.esquerda, matricula);
      } else if (root.matricula < matricula) {
        root.direita = excluir(root.direita, matricula);
      } else {
        if (root.direita != null && root.esquerda != null) {
          root = maximo(root.esquerda);
          root.esquerda = excluiMaximo(root.esquerda);
        } else {
          if (root == raiz) {
            ajuste = true;
          }
          if (root.esquerda != null) {
            root = root.esquerda;
          } else {
            root = root.direita;
          }
          if (ajuste) {
            raiz = root;
          }
        }
      }
      return root;
    }
  }

  public Aluno maximo(Aluno root) throws Exception {
    if (root == null) {
      throw new Exception("Árvore vazia");
    }
    if (root.direita != null) {
      return maximo(root.direita);
    } else {
      return root;
    }
  }

  private Aluno excluiMaximo(Aluno root) throws Exception {
    if (root == null)
      throw new Exception("Raiz nula");
    else if (root.direita != null) {
      root.direita = excluiMaximo(root.direita);
      return root;
    } else {
      return root.esquerda;
    }
  }

  public boolean existeAluno(Aluno root, int matricula) {
    if (root == null) {
      return false;
    }
    if (matricula == root.matricula) {
      return true;
    } else if (matricula < root.matricula) {
      return existeAluno(root.esquerda, matricula);
    } else {
      return existeAluno(root.direita, matricula);
    }
  }

  public void preOrdem(Aluno a) {
    if (a != null) {
      System.out.print(a + "\n");
      preOrdem(a.esquerda);
      preOrdem(a.direita);
    }
  }
}
