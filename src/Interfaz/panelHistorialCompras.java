package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import logica.Compra;
import usuario.Comprador;

public class panelHistorialCompras extends JPanel {
    private JTextArea textArea;
    private JButton back;
    private JLabel titleLabel;

    public panelHistorialCompras(Comprador comprador, ventanaPrincipal ventana) {
        setLayout(new BorderLayout());

        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Establecer la fuente del título
        add(titleLabel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Establecer la fuente del submenú
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        mostrarHistorialCompras(comprador);

        back = new JButton("Atras");
        JPanel backPanel = new JPanel(); // Crear un panel para el botón de atrás
        backPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Establecer el layout para centrar el botón
        backPanel.add(back);
        add(backPanel, BorderLayout.SOUTH); // Agregar el botón al sur

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.volverMenuComprador("historial");
            }
        });
    }

    private void mostrarHistorialCompras(Comprador comprador) {
        List<Compra> misCompras = comprador.getmisCompras();
        titleLabel.setText("Tienes un total de " + misCompras.size() + " compras, aqui el listado:"); // Establecer el texto del título

        for (Compra miCompra : misCompras) {
            textArea.append("Obra de arte: " + miCompra.getPieza().getTitulo() + ", valor pagado: " + miCompra.getValorPagado() + "\n");
        }
    }
}

