public class orden {
    private int cantidad;
    private boolean combo;
    private int[] orden;
    private pizza pizza;

    public orden(int cantidad, boolean combo, int[] orden, pizza pizza) {
        this.cantidad = cantidad;
        this.combo = combo;
        this.orden = orden;
        this.pizza = pizza;
    }

    public orden(pizza pizza, int cantidad) {
        this(cantidad, false, new int[0], pizza);
    }

    public orden() {
        this.orden = new int[0];
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isCombo() {
        return combo;
    }

    public int[] getOrden() {
        return orden;
    }

    public pizza getPizza() {
        return pizza;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCombo(boolean combo) {
        this.combo = combo;
    }

    public void setOrden(int[] orden) {
        this.orden = orden;
    }

    public void setPizza(pizza pizza) {
        this.pizza = pizza;
    }
}
