public class ExListaListaCandidatos {
    private ExListaCandidato[] lista;
    private int uPosicao;
    private int qtdElementos;
    private int proxInscricao;

    public ExListaListaCandidatos() {
        this.setLista(new ExListaCandidato[5]);
        this.setuPosicao(0);
        this.setQtdElementos(0);
        this.setProxInscricao(1);
    }

    public void inserir(ExListaCandidato c) {
        if (!(taCheio())) {
            c.setInscricao(this.getProxInscricao());
            this.getLista()[this.getuPosicao()] = c;
            this.setuPosicao(this.getuPosicao() + 1);
            this.setQtdElementos(this.getQtdElementos() + 1);
            this.setProxInscricao(this.getProxInscricao() + 1);
        } else {
            this.aumentarTamanho();
            this.inserir(c);
        }
    }

    private void aumentarTamanho() {
        ExListaCandidato[] novaLista = new ExListaCandidato[this.getLista().length + 10];
        for (int i = 0; i < this.getuPosicao(); i++) {
            novaLista[i] = this.getLista()[i];
        }
        this.setLista(novaLista);
    }

    public ExListaCandidato[] consultarNota(String nome) throws Exception {
        if (this.getQtdElementos() > 0) {
            ExListaCandidato[] subLista = new ExListaCandidato[this.getQtdElementos()];
            int indice = 0;
            for (int i = 0; i < this.getuPosicao(); i++) {
                if (this.getLista()[i].getNome().equals(nome)) {
                    subLista[indice] = this.getLista()[i];
                    indice++;
                }
            }
            if (indice == 0) {
                throw new Exception("Não há candidatos com o nome " + nome + " na lista.");
            }
            return subLista;
        } else {
            throw new Exception("Não há candidatos na lista.");
        }
    }

    public void excluir(int inscricao) throws Exception {
        if (qtdElementos > 0) {
            int indice = -1;
            for (int i = 0; i < this.getuPosicao(); i++) {
                if (this.getLista()[i].getInscricao() == inscricao) {
                    indice = i;
                }
            }
            if (indice != -1) {
                if (indice < this.getuPosicao() - 1) {
                    for (int i = indice + 1; i < this.getuPosicao(); i++) {
                        this.getLista()[i-1] = this.getLista()[i];
                    }
                }
                this.setQtdElementos(this.getQtdElementos() - 1);
                this.setuPosicao(this.getuPosicao() - 1);
            } else {
                throw new Exception("Candidato com a inscrição " + inscricao + " não encontrado.");
            }
        } else {
            throw new Exception("Não há candidatos na lista para serem excluídos.");
        }
    }

    public void exibirElementos() {
        for (int i = 0; i < this.getuPosicao(); i++) {
            System.out.println(this.getLista()[i].getInscricao() + " - " + this.getLista()[i].getNome() + " - " + this.getLista()[i].getNota());
        }
    }

    public boolean taCheio() {
        return this.getQtdElementos() == this.getLista().length;
    }

    public ExListaCandidato[] getLista() {
        return lista;
    }

    public void setLista(ExListaCandidato[] lista) {
        this.lista = lista;
    }

    public int getuPosicao() {
        return uPosicao;
    }

    public void setuPosicao(int uPosicao) {
        this.uPosicao = uPosicao;
    }

    public int getQtdElementos() {
        return qtdElementos;
    }

    public void setQtdElementos(int qtdElementos) {
        this.qtdElementos = qtdElementos;
    }

    public int getProxInscricao() {
        return proxInscricao;
    }

    public void setProxInscricao(int proxInscricao) {
        this.proxInscricao = proxInscricao;
    }
}
