import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Arvore arv = new Arvore();
        Scanner scn = new Scanner(System.in);
        int TAM_MAX = Integer.parseInt(scn.nextLine());
        String[] alturas = (scn.nextLine()).split(" ");
        for (int i = 0; i < TAM_MAX; i++) {
            arv.inserir(arv.raiz, Integer.parseInt(alturas[i]));
        }
        scn.close();
        arv.imprimeMenorPorNivel();
    }
}
