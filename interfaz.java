public class interfaz {

    public void hacerPizza(pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("Falta la pizza.");
        }

        if (pizza.getTamano() == null
                || pizza.getIngredientes() == null
                || pizza.getTipoMasa() == null) {
            throw new IllegalArgumentException(
                "La pizza debe tener tamaño, ingrediente y tipo de masa."
            );
        }

        System.out.println("Preparando pizza de tamaño: " + pizza.getTamano());
        System.out.println("Preparando masa: " + pizza.getTipoMasa());
        System.out.println("Agregando ingrediente: " + pizza.getIngredientes());
        System.out.println("Horneando la pizza...");
        System.out.println("Pizza lista.");
    }

    public void entregarOrden(orden orden) {
        validarOrden(orden);

        System.out.println("Entregando orden de "
                + orden.getCantidad() + " pizza(s).");

        if (orden.isCombo()) {
            System.out.println("La orden incluye combo.");
        }

        System.out.println("Orden entregada.");
    }

    public void prepararOrden(orden orden) {
        validarOrden(orden);

        System.out.println("Iniciando preparación de la orden.");

        for (int i = 0; i < orden.getCantidad(); i++) {
            System.out.println("\nPizza " + (i + 1)
                    + " de " + orden.getCantidad());

            hacerPizza(orden.getPizza());
        }

        if (orden.isCombo()) {
            System.out.println("Preparando complementos del combo...");
        }

        entregarOrden(orden);
    }

    private void validarOrden(orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException("Falta la orden.");
        }

        if (orden.getCantidad() <= 0) {
            throw new IllegalArgumentException(
                "La cantidad de pizzas debe ser mayor que cero."
            );
        }

        if (orden.getPizza() == null) {
            throw new IllegalArgumentException(
                "La orden debe incluir una pizza."
            );
        }
    }
    public void tomarOrden(cocina cocina, orden nuevaOrden) {
    validarOrden(nuevaOrden);

    if (cocina.agregarOrden(nuevaOrden)) {
        System.out.println(
            "Orden aceptada. Órdenes registradas: "
            + cocina.getCantidadOrdenes() + "/5"
        );
    } else {
        System.out.println(
            "No se puede tomar la orden: la cocina ya tiene 5 órdenes."
        );
    }
}

public void prepararTodasLasOrdenes(cocina cocina) {
    if (cocina.getCantidadOrdenes() == 0) {
        System.out.println("No hay órdenes para preparar.");
        return;
    }

    for (int i = 0; i < cocina.getCantidadOrdenes(); i++) {
        System.out.println("\n--- Orden " + (i + 1) + " ---");
        prepararOrden(cocina.getOrden(i));
    }
}
}