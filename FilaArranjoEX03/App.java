import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> entradas = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int entrada = 1;
        while (entrada > 0) {
            entrada = s.nextInt();
            if (entrada == 0)
                break;
            entradas.add(entrada);
        }
        imprimeSaida(entradas);
        s.close();
    }

    public static void imprimeSaida(ArrayList<Integer> ent) {
        try {
            for (int i = 0; i < ent.size(); i++) {
                Fila baralho = new Fila();
                for (int j = 0; j < ent.get(i); j++) {
                    baralho.enfileirar(j + 1);
                }
                StringBuilder descarte = new StringBuilder();
                descarte.append("Discarded cards: ");
                boolean houveDescarte = false;
                if (baralho.tamanho > 1) {
                    houveDescarte = true;
                }
                while (baralho.tamanho > 1) {
                    descarte.append(baralho.desenfileirar() + ", ");
                    baralho.enfileirar(baralho.desenfileirar());
                }
                if (houveDescarte) {
                    descarte.deleteCharAt(descarte.length() - 1);
                    descarte.deleteCharAt(descarte.length() - 1);
                }
                String restante = "Remaining card: " + baralho.desenfileirar();
                System.out.println(descarte + "\n" + restante);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
