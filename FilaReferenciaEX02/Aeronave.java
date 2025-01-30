public class Aeronave {
    private Aeronave proximo;
    private String id;

    public Aeronave(Aeronave proximo, String id) {
        this.proximo = proximo;
        this.id = id;
    }

    public Aeronave getProximo() {
        return proximo;
    }

    public void setProximo(Aeronave proximo) {
        this.proximo = proximo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
