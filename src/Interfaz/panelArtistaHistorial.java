package Interfaz;
import javax.swing.*;

import logica.Galeria;
import pieza.Pieza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class panelArtistaHistorial extends JPanel {
    private JList<Pieza> listaPiezas;
    private JButton back;
    private JLabel titleLabel;
    private Galeria laGaleria;
    
    
    public panelArtistaHistorial(Galeria galeria, ventanaPrincipal ventana) {
    		
    	setLayout(new BorderLayout());
    	this.laGaleria = galeria;
    	
    	titleLabel = new JLabel("¡Doble click para ver las piezas creadas por el artista! \n");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        add(titleLabel, BorderLayout.NORTH);
    	
        listaPiezas = new JList<>(new DefaultListModel<>());
        listaPiezas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPiezas.setCellRenderer(new artistaRender());
        for (Pieza pieza : galeria.getInventario().getPiezasPasadas()) {
            ((DefaultListModel<Pieza>) listaPiezas.getModel()).addElement(pieza);
        }
        JScrollPane scrollPane = new JScrollPane(listaPiezas);
        add(scrollPane, BorderLayout.CENTER);;

        listaPiezas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Pieza piezaSeleccionada = listaPiezas.getSelectedValue();
                    if (piezaSeleccionada != null) {
                        String infoPieza = piezaSeleccionada.getTitulo() + " que fue creada en el " + piezaSeleccionada.getAnioCreacion();
                        if (piezaSeleccionada.isVendida()) {
                            infoPieza += " y fue vendida por " + piezaSeleccionada.getPrecioFijo() + " en el " + piezaSeleccionada.getFechaVenta();
                        }else {
                            infoPieza += " y no ha sido vendida.";
                        }
                        JOptionPane.showMessageDialog(null, infoPieza);
                    }
                }
            }
        });
        
        back = new JButton("Atras");
        JPanel backPanel = new JPanel(); // Crear un panel para el botón de atrás
        backPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Establecer el layout para centrar el botón
        backPanel.add(back);
        add(backPanel, BorderLayout.SOUTH); // Agregar el botón al sur

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.volverMenuComprador("artista");
            }
        });
    }
}

