public class Main {

    public static void main(String[] args) {
        cocina cocina1 = new cocina();
        interfaz interfaz1 = new interfaz();

        for (int i = 1; i <= 6; i++) {
            pizza pizza1 = new pizza(
                tamano.GRANDE,
                TipoMasa.SIMPLE,
                new Ingredientes[]{
                    Ingredientes.PEPPERONI,
                    Ingredientes.QUESO
                }
            );

            orden nuevaOrden = new orden(pizza1, 2);

            System.out.println("\nIntentando registrar orden " + i);
            interfaz1.tomarOrden(cocina1, nuevaOrden);
        }

        interfaz1.prepararTodasLasOrdenes(cocina1);
    }
}
