public class Pilha {
    int tam = 0;
    Vagao topo;

    public boolean taVazia() {
        return tam == 0;
    }

    public int getTamanho() {
        return this.tam;
    }

    public void push(Vagao v) {
        if (tam!=0) {
            v.prox = topo;
        }
        topo = v;
        tam++;
    }

    public Vagao pop() throws Exception {
        if (taVazia()) {
            throw new Exception("Lista vazia.");
        }
        Vagao v = topo;
        topo = topo.prox;
        tam--;
        return v;
    }
}
