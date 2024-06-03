
package Interfaz;

import javax.swing.*;
import java.awt.*;

public class banner extends JPanel {
    private Image imagen;

    public banner(String rutaImagen) {
        // Cargar la imagen
        ImageIcon icono = new ImageIcon(rutaImagen);
        imagen = icono.getImage();

        // Configurar las dimensiones del panel
        Dimension dimension = new Dimension(240, 190);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setSize(dimension);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la imagen en el panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
