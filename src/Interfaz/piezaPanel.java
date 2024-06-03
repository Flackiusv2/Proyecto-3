
package Interfaz;

import pieza.Pieza;
import javax.swing.*;
import java.awt.*;

public class piezaPanel extends JPanel {
    private JLabel tituloLabel;
    private JLabel autorLabel;
    private JLabel anioCreacionLabel;
    private JLabel lugarCreacionLabel;
    private JLabel precioFijoLabel;
    private JLabel tipoPiezaLabel;

    public piezaPanel() {
        setLayout(new GridLayout(1, 6));
        tituloLabel = new JLabel();
        autorLabel = new JLabel();
        anioCreacionLabel = new JLabel();
        lugarCreacionLabel = new JLabel();
        precioFijoLabel = new JLabel();
        tipoPiezaLabel = new JLabel();
        add(tituloLabel);
        add(autorLabel);
        add(anioCreacionLabel);
        add(lugarCreacionLabel);
        add(precioFijoLabel);
        add(tipoPiezaLabel);
    }

    public void setPieza(Pieza pieza) {
        tituloLabel.setText("Titulo: " + pieza.getTitulo());
        autorLabel.setText("Autor: " + (pieza.getAutor() != null ? pieza.getAutor().getNombre() : "Desconocido"));
        anioCreacionLabel.setText("Año de Creación: " + pieza.getAnioCreacion());
        lugarCreacionLabel.setText("Lugar de Creación: " + pieza.getLugarCreacion());
        precioFijoLabel.setText("Precio Fijo: " + pieza.getPrecioFijo());
        tipoPiezaLabel.setText("Tipo de Pieza: " + pieza.getTipoPieza());
    }
}
