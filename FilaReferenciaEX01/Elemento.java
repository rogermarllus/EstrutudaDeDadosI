public class Elemento {
  String elemento;
  Elemento prox;

  public Elemento(String e) {
    this.elemento = e;
  }

  public void setProx(Elemento prox) {
    this.prox = prox;
  }

  public Elemento getProx() {
    return prox;
  }
}
