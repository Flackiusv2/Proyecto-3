
package Interfaz;

import javax.swing.*;
import java.awt.*;

public class panelPiezasInfo extends JPanel {
    private JPanel tableContainer; // Contenedor para la tabla

    public panelPiezasInfo() {
        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 220));
        // Configurar el borde del panel
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10), // Borde interior (margen)
            BorderFactory.createLineBorder(Color.black) // Borde exterior
        ));

        // Crear el label inicial y añadirlo al panel

		JLabel labelInicial = new JLabel("<html><font size='6'>" + "Piezas disponibles en la galería:" + "</font></html>");
        add(labelInicial, BorderLayout.NORTH);

        // Crear el contenedor para la tabla y añadirlo al panel
        tableContainer = new JPanel(new BorderLayout());
        tableContainer.setBackground(new Color(245, 245, 220));
        add(tableContainer, BorderLayout.CENTER);
    }

    public JPanel getTableContainer() {
        return tableContainer;
    }
}

