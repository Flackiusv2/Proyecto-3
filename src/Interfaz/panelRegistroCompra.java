package Interfaz;
import javax.swing.*;

import logica.Compra;
import logica.Galeria;
import pieza.Pieza;
import usuario.Comprador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class panelRegistroCompra extends JPanel {
	
	private Galeria laGaleria;
	Comprador myself;
	List<Pieza> piezasDisponibles; 
	
	private JList<Pieza> listaPiezas;
    private JButton botonCompra;
    private int dinero;
    private JLabel label;
    private JButton back;
    
    public panelRegistroCompra(Galeria galeria, Comprador yo, ventanaPrincipal ventana) {
    	setLayout(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();


        
        this.laGaleria = galeria;
        this.myself = yo;
    	this.piezasDisponibles = laGaleria.getInventario().getPiezasDisponibleVenta();
    	
    	
    	dinero = myself.getDinero();
    	
    	label = new JLabel("Dinero disponible: " + dinero);
    	gbc.gridx = 0;
    	gbc.gridy = 0;
    	gbc.weightx = 1.0;
    	gbc.weighty = 0.0;
    	gbc.fill = GridBagConstraints.HORIZONTAL;
    	add(label, gbc);
    	
    	listaPiezas = new JList<>(new DefaultListModel<>());
    	listaPiezas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	listaPiezas.setCellRenderer(new piezaRender());
    	for (Pieza pieza : piezasDisponibles) {
    	    ((DefaultListModel<Pieza>) listaPiezas.getModel()).addElement(pieza);
    	}
        JScrollPane scrollPane = new JScrollPane(listaPiezas);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        // Crear el botón de compra
        botonCompra = new JButton("Comprar");
        botonCompra.setPreferredSize(new Dimension(100, 50)); 
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.weightx = 1.0;
	    gbc.weighty = 0.0;
	    gbc.fill = GridBagConstraints.NONE;
	    add(botonCompra, gbc);
        botonCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pieza piezaSeleccionada = listaPiezas.getSelectedValue();
                if (piezaSeleccionada != null) {
                	String nombre = piezaSeleccionada.getTitulo();
                	Compra nuevaCompra = myself.realizarCompraFija(piezaSeleccionada); 
            	    if (nuevaCompra == null){
            	        JOptionPane.showMessageDialog(null, "Compra no exitosa, probablemente no tengas suficiente dinero!");
            	    }else {
            	    
            	    laGaleria.agregarCompra(nuevaCompra,  myself);
            	    laGaleria.getInventario().realizarCompra(piezaSeleccionada);
            	    JOptionPane.showMessageDialog(null, "Compra existosa!");
            	    actualizarDinero(); 
            	    ((DefaultListModel<Pieza>) listaPiezas.getModel()).removeElement(piezaSeleccionada);
                    
            	    }
                }
            }
        });
        
        back = new JButton("Atras");
        back.setPreferredSize(new Dimension(100, 50));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        add(back, gbc);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.volverMenuComprador("compra");
			}
		});

	}

	public void actualizarGaleria() {
		((DefaultListModel<Pieza>) listaPiezas.getModel()).clear();
		for (Pieza pieza : piezasDisponibles) {
			((DefaultListModel<Pieza>) listaPiezas.getModel()).addElement(pieza);
		}
        
    }
    
    public void actualizarDinero() {
        dinero = myself.getDinero();
        label.setText("Dinero disponible: " + dinero);
    }
   
    
}

