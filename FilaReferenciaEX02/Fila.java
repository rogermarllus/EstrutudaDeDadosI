public class Fila {
    Aeronave topo = null;
    Aeronave cauda = null;
    int tamanho = 0;

    public void enfileirar(String id) {
        Aeronave novo = new Aeronave(null, id);
        if (tamanho == 0) {
            topo = novo;
            cauda = novo;
        } else {
            cauda.setProximo(novo);
            cauda = novo;
        }
        tamanho++;
    }

    public Aeronave desenfileirar() throws Exception {
        if (tamanho == 0)
            throw new Exception("Fila vazia");
        Aeronave retorno = topo;
        topo = topo.getProximo();
        tamanho--;
        return retorno;
    }
}
