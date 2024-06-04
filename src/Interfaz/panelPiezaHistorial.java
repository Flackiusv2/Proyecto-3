package Interfaz;


import javax.swing.*;
import javax.swing.table.TableModel;

import logica.Galeria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import pieza.Pieza;
import usuario.Cliente;

public class panelPiezaHistorial extends JPanel {
    private JTextArea textArea;
    private JButton back; 
    List<Pieza> piezasPasadas; 
    private JLabel titleLabel;
    private Galeria laGaleria;
    private JTable table;


    public panelPiezaHistorial(Galeria galeria, ventanaPrincipal ventana) {
    	
    	setLayout(new BorderLayout());
    	this.laGaleria = galeria;
    	this.piezasPasadas = laGaleria.getInventario().getPiezasPasadas();
        

        titleLabel = new JLabel("¡Doble click para inforamcion adicional de la pieza! \n");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        add(titleLabel, BorderLayout.NORTH);
        
        table = new JTable();
        table.setModel(new piezaTableModel(piezasPasadas));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
   

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int rowIndex = table.rowAtPoint(e.getPoint());
                    Pieza pieza = piezasPasadas.get(rowIndex);
                    StringBuilder historial = new StringBuilder();
                    List<Cliente> dueños = pieza.getDueños();
            	    historial.append(pieza.getTitulo()).append(" tiene un precio de ").append(pieza.getPrecioFijo())
            	             .append(" y fue creada en ").append(pieza.getLugarCreacion()).append(" en el año ").append(pieza.getAnioCreacion()).append(".\n")
            	             .append("La pieza esta bloqueada: ").append(pieza.isBloqueada()).append(".\n");
            	
            	    if (dueños.size() > 0) {
            	        historial.append("Los dueños de la pieza han sido: \n");
            	        for (Cliente cl : dueños) {
            	            historial.append(cl.getLogin()).append("\n");
            	        }
            	    } else {
            	        historial.append("Esta pieza no ha sido vendida aun!\n");
            	    }
            	
            	    if (pieza.isVendida()) {
            	        historial.append("La pieza ha sido vendida por ").append(pieza.getPrecioFijo()).append(" en la fecha ").append(pieza.getFechaVenta()).append(".\n");
            	    }
            	
            	    JOptionPane.showMessageDialog(null, historial.toString());
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
                ventana.volverMenuComprador("pieza");
            }
        });
    }

    

	public void mostrarHistorial() {
	    
}

}

