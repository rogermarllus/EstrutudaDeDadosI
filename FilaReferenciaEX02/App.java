import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Fila fNorte = new Fila();
        Fila fSul = new Fila();
        Fila fLeste = new Fila();
        Fila fOeste = new Fila();
        Fila fPouso = new Fila();

        String entrada = teclado.nextLine();
        while (!entrada.equals("0")) {
            String aero = teclado.nextLine();
            if (aero.charAt(0) == '-') {
                entrada = aero;
            } else if (aero.equals("0")) {
                break;
            } else {
                switch (entrada) {
                    case "-4":
                        fLeste.enfileirar(aero);
                        break;
                    case "-3":
                        fNorte.enfileirar(aero);
                        break;
                    case "-2":
                        fSul.enfileirar(aero);
                        break;
                    case "-1":
                        fOeste.enfileirar(aero);
                        break;
                    default:
                        System.out.println("Erro.");
                        break;
                }
            }
        }
        while ((fOeste.tamanho + fNorte.tamanho + fSul.tamanho + fLeste.tamanho) > 0) {
            try {
                if (fOeste.tamanho != 0) {
                    fPouso.enfileirar(fOeste.desenfileirar().getId());
                }
                if (fNorte.tamanho != 0) {
                    fPouso.enfileirar(fNorte.desenfileirar().getId());
                }
                if (fSul.tamanho != 0) {
                    fPouso.enfileirar(fSul.desenfileirar().getId());
                }
                if (fLeste.tamanho != 0) {
                    fPouso.enfileirar(fLeste.desenfileirar().getId());
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        try {
            while (fPouso.tamanho > 0) {
                System.out.print(fPouso.desenfileirar().getId() + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        teclado.close();
    }
}
