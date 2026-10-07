public class pizza {
    private tamano tamano;
    private Ingredientes[] ingredientes;
    private TipoMasa tipoMasa;

    public pizza(tamano tamano, TipoMasa tipoMasa,
                 Ingredientes[] ingredientes) {
        this.tamano = tamano;
        this.tipoMasa = tipoMasa;
        this.ingredientes = ingredientes;
    }

    public pizza(tamano tamano, Ingredientes[] ingredientes) {
        this(tamano, TipoMasa.SIMPLE, ingredientes);
    }

    public pizza() {
        this.tipoMasa = TipoMasa.SIMPLE;
        this.ingredientes = new Ingredientes[10];
    }

    public tamano getTamano() {
        return tamano;
    }

    public Ingredientes[] getIngredientes() {
        return ingredientes;
    }

    public TipoMasa getTipoMasa() {
        return tipoMasa;
    }

    public void setTamano(tamano tamano) {
        this.tamano = tamano;
    }

    public void setIngredientes(Ingredientes[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setTipoMasa(TipoMasa tipoMasa) {
        this.tipoMasa = tipoMasa;
    }
}
