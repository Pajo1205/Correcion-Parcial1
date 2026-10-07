import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPizza ventana = new VentanaPizza();
            ventana.setVisible(true);
        });
    }
}