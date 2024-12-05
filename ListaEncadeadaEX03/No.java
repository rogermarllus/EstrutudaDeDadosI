public class No {
    public Cidade cidade;
    public No prox;
    public No ant;
  
    public No() {
      this.cidade = null;
      this.prox = null;
      this.ant = null;
    }
  
    public No(Cidade c, No prox, No ant) {
      this.cidade = c;
      this.prox = prox;
      this.ant = ant;
    }
  }
  