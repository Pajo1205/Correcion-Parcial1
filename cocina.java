public class cocina {
    private orden[] ordenes;
    private int cantidadOrdenes;

    public cocina() {
        this.ordenes = new orden[5];
        this.cantidadOrdenes = 0;
    }

    public boolean agregarOrden(orden nuevaOrden) {
        if (nuevaOrden == null) {
            return false;
        }

        if (cantidadOrdenes >= ordenes.length) {
            return false;
        }

        ordenes[cantidadOrdenes] = nuevaOrden;
        cantidadOrdenes++;

        return true;
    }

    public int getCantidadOrdenes() {
        return cantidadOrdenes;
    }

    public orden getOrden(int posicion) {
        if (posicion < 0 || posicion >= cantidadOrdenes) {
            throw new IllegalArgumentException(
                "La posición de la orden no es válida."
            );
        }

        return ordenes[posicion];
    }
}
