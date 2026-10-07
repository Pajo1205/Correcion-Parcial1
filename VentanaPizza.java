import javax.swing.*;
import java.awt.*;

public class VentanaPizza extends JFrame {

    private cocina cocina1 = new cocina();
    private pizza pizzaActual = new pizza();
    private int cantidadIngredientes = 0;

    private JComboBox<tamano> tamanos =
            new JComboBox<>(tamano.values());

    private JComboBox<TipoMasa> masas =
            new JComboBox<>(TipoMasa.values());

    private JButton pepperoni = new JButton("Pepperoni");
    private JButton jamon = new JButton("Jamón");
    private JButton queso = new JButton("Queso");

    private JLabel contador = new JLabel("Ingredientes: 0/10");
    private JTextArea resultado = new JTextArea(10, 30);

    public VentanaPizza() {
        setTitle("Crear pizza");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        add(new JLabel("Tamaño:"));
        add(tamanos);

        add(new JLabel("Masa:"));
        add(masas);

        add(pepperoni);
        add(jamon);
        add(queso);
        add(contador);

        pepperoni.addActionListener(e ->
                agregarIngrediente(Ingredientes.PEPPERONI)
        );

        jamon.addActionListener(e ->
                agregarIngrediente(Ingredientes.JAMON)
        );

        queso.addActionListener(e ->
                agregarIngrediente(Ingredientes.QUESO)
        );

        JButton registrar = new JButton("Registrar pizza");
        add(registrar);

        registrar.addActionListener(e -> registrarPizza());

        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        add(new JScrollPane(resultado));
    }

    private void agregarIngrediente(Ingredientes ingrediente) {
        Ingredientes[] arreglo = pizzaActual.getIngredientes();

        if (cantidadIngredientes >= arreglo.length) {
            JOptionPane.showMessageDialog(
                    this, "La pizza ya tiene 10 ingredientes."
            );
            return;
        }

        arreglo[cantidadIngredientes] = ingrediente;
        cantidadIngredientes++;

        contador.setText(
                "Ingredientes: " + cantidadIngredientes + "/10"
        );
    }

    private void registrarPizza() {
        if (cantidadIngredientes == 0) {
            JOptionPane.showMessageDialog(
                    this, "Agrega al menos un ingrediente."
            );
            return;
        }

        pizzaActual.setTamano(
                (tamano) tamanos.getSelectedItem()
        );

        pizzaActual.setTipoMasa(
                (TipoMasa) masas.getSelectedItem()
        );

        orden nuevaOrden = new orden(pizzaActual, 1);

        if (cocina1.agregarOrden(nuevaOrden)) {
            resultado.append(
                    "Orden " + cocina1.getCantidadOrdenes()
                    + "\nTamaño: " + pizzaActual.getTamano()
                    + "\nMasa: " + pizzaActual.getTipoMasa()
                    + "\nIngredientes: "
            );

boolean primero = true;

for (Ingredientes ingrediente : Ingredientes.values()) {
    int cantidad = 0;

    for (int i = 0; i < cantidadIngredientes; i++) {
        if (pizzaActual.getIngredientes()[i] == ingrediente) {
            cantidad++;
        }
    }

    if (cantidad > 0) {
        if (!primero) {
            resultado.append(", ");
        }

        resultado.append(ingrediente.name() + " (" + cantidad + ")");
        primero = false;
    }
}

            resultado.append("\n\n");

            // Otra pizza con un nuevo arreglo de 10 espacios.
            pizzaActual = new pizza();
            cantidadIngredientes = 0;
            contador.setText("Ingredientes: 0/10");
        } else {
            JOptionPane.showMessageDialog(
                    this, "La cocina está llena: máximo 5 órdenes."
            );
        }
    }
}