public class Deque<T> {
    private int tam;
    No<T> cabeca = new No<>();

    public void addInicio(T element) {
        No<T> no = new No<>();
        no.setInfo(element);
        if (taVazio()) {
            cabeca.setProx(no);
            cabeca.setAnt(no);
            no.setProx(cabeca);
            no.setAnt(cabeca);
        } else {
            no.setProx(cabeca.getProx());
            cabeca.getProx().setAnt(no);
            no.setAnt(cabeca);
            cabeca.setProx(no);
        }
        tam++;
    }

    public void addFinal(T element) {
        if (taVazio()) {
            addInicio(element);
        } else {
            No<T> no = new No<>();
            no.setInfo(element);
            no.setProx(cabeca);
            no.setAnt(cabeca.getAnt());
            cabeca.getAnt().setProx(no);
            cabeca.setAnt(no);
        }
        tam++;
    }

    public T removeInicio() throws Exception {
        if (taVazio()) {
            throw new Exception("Deque vazio.");
        }
        T no = cabeca.getProx().getInfo();
        cabeca.setProx(cabeca.getProx().getProx());
        cabeca.getProx().setAnt(cabeca);
        tam--;
        return no;
    }

    public T removeFinal() throws Exception {
        if (taVazio()) {
            throw new Exception("Deque vazio.");
        }
        T no = cabeca.getAnt().getInfo();
        cabeca.setAnt(cabeca.getAnt().getAnt());
        cabeca.getAnt().setProx(cabeca);
        tam--;
        return no;
    }

    public void print() throws Exception {
        if (taVazio()) {
            throw new Exception("Deque vazio.");
        }
        No<T> no = new No<>();
        no = cabeca.getProx();
        while (no != cabeca) {
            System.out.println(no.getInfo());
            no = no.getProx();
        }
    }

    public boolean taVazio() {
        return this.tamanho() == 0;
    }

    public int tamanho() {
        return tam;
    }

    public class No<T> {
        private No<T> prox;
        private No<T> ant;
        private T info;

        public No(T info) {
            this.info = info;
            prox = null;
            ant = null;
        }

        public No() {
            this(null);
        }

        public No<T> getAnt() {
            return ant;
        }

        public void setAnt(No<T> ant) {
            this.ant = ant;
        }

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public No<T> getProx() {
            return prox;
        }

        public void setProx(No<T> prox) {
            this.prox = prox;
        }
    }
}
