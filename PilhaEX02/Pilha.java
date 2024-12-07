public class Pilha {
    String[] pilha;
    int tamanhoInicial;
    int topo;

    public Pilha(int t) {
        this.tamanhoInicial = t;
        this.pilha = new String[this.tamanhoInicial];
        this.topo = -1;
    }

    public void push(String cara) throws Exception {
        if (taCheio())
            throw new Exception("Lista Cheia.");
        pilha[++topo] = cara;
    }

    public String pop() throws Exception {
        if (taVazio())
            throw new Exception("Lista Vazia.");
        return pilha[topo--];
    }

    public String top() throws Exception {
        if (taVazio())
            throw new Exception("Lista Vazia.");
        return pilha[topo];
    }

    public boolean taCheio() {
        return topo == tamanhoInicial - 1;
    }

    public boolean taVazio() {
        return topo == -1;
    }

    public int pegarTamanho() {
        return topo + 1;
    }

    public void print() {
        for (int i = 0; i < pegarTamanho(); i++) {
            System.out.print(pilha[i]);
        }
    }
}
