import java.util.Random;

public class Carta {
  int valor;
  Carta prox;

  public Carta() {
    Random r = new Random();
    valor = r.nextInt(9) + 1;
    prox = null;
  }
}
