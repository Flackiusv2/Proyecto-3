package Interfaz;
import javax.swing.*;

import logica.Galeria;
import pieza.Pieza;

import java.util.ArrayList;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ventanaPrincipal extends JFrame {
    private JButton cargarGaleriaBtn;
    private JButton guardarGaleriaBtn;
    private JButton loginBtn;
    private JPanel galeriaPanel;

    
    private Galeria laGaleria;

    public ventanaPrincipal() {
    	
        // Configuración de la ventana
        setTitle("Galería");
        setSize(800, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        
        
        //BANER DE LA VENTANA PRINCIPAL
        banner miBanner = new banner("IMG/BANNER.png");
        add(miBanner, BorderLayout.NORTH);
        
        //PANEL DE BOTONES - CARGAR- GUARDAR - LOGIN   
        panelBotonesDerecha panelBotones = new panelBotonesDerecha();
        add(panelBotones, BorderLayout.EAST);
        
        //PANEL DE PIEZAS
        galeriaPanel = new panelPiezasInfo();
        add(galeriaPanel, BorderLayout.CENTER);

        
        File archivo = new File( "./datos/sustentacion" );
        File archivoEmpleados = new File( "./datos/sustentacionempleados" );
        try
        {
            Galeria GaleriaSinEmpleados = Galeria.cargarEstado( archivo );
            laGaleria = Galeria.cargarEmpleados(archivoEmpleados, GaleriaSinEmpleados);
        }
        catch( NumberFormatException e1 )
        {
            System.out.println( "Hubo un error leyendo el archivo: hay números con un formato incorrecto" );
            System.out.println( e1.getMessage( ) );
            e1.printStackTrace( );
        }
        catch( FileNotFoundException e1 )
        {
            System.out.println( "No se encontró el archivo indicado" );
            System.out.println( e1.getMessage( ) );
            e1.printStackTrace( );
        }
        catch( IOException e1 )
        {
            System.out.println( "No se pudo leer el archivo indicado" );
            System.out.println( e1.getMessage( ) );
            e1.printStackTrace( );
        }
        //METODO PARA HACER QUE CARGUEN LAS PIEZAS, Y SE MUESTREN EN EL PANEL DE PIEZAS
        botonesGod cargarGaleriaBtn = panelBotones.getCargarGaleriaBtn();
        cargarGaleriaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton loginBtn = panelBotones.getLoginBtn();
                JButton guardarGaleriaBtn = panelBotones.getGuardarGaleriaBtn();
                
                // Eliminar el botón de cargar
                panelBotones.removeEspacios();
                panelBotones.remove(cargarGaleriaBtn);
                
                
                // Agregar el boton de iniciar sesión 
                panelBotones.agregarLogin();
                


                // Actualizar panelBotones para mostrar los nuevos botones
                panelBotones.revalidate();
                panelBotones.repaint();
               
                
                actualizarGaleria();
            }
        });
        
       
	     // Crear un nuevo panel
         JPanel loginPanel = new panelLogin( laGaleria );
	    
	     botonesGod loginBtn = panelBotones.getLoginBtn();
	     loginBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             // Eliminar el panel de información de piezas
	             remove(galeriaPanel);
	             remove(panelBotones);
	
	             // Añadir el nuevo panel
	             add(loginPanel, BorderLayout.CENTER);
	
	             // Actualizar la ventana para mostrar los cambios
	             revalidate();
	             repaint();
	         }
	     });

	  // Crear un botón de "Atrás"
	     JButton backBtn = new JButton("Atrás");

	     // Añadir un ActionListener al botón
	     backBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             // Eliminar el panel actual
	             remove(loginPanel);

	             // Añadir el panel anterior
	             add(galeriaPanel, BorderLayout.CENTER);
	             add(panelBotones, BorderLayout.EAST);

	             // Actualizar la ventana para mostrar los cambios
	             revalidate();
	             repaint();
	         }
	     });

	     // Añadir el botón de "Atrás" al panel de inicio de sesión
	     loginPanel.add(backBtn);
       
    }
    



	public void actualizarGaleria() {
	    // Borrar todos los componentes existentes en tableContainer
	    ((panelPiezasInfo) galeriaPanel).getTableContainer().removeAll();
	
	    // Obtener las piezas disponibles para la venta
	    List<Pieza> piezasDisponibles = laGaleria.getInventario().getPiezasDisponibleVenta();
	
	    // Crear un modelo de tabla con las piezas disponibles
	    piezaTableModel tableModel = new piezaTableModel(piezasDisponibles);
	
	    // Crear una JTable con el modelo de tabla y añadirla a tableContainer
	    JTable table = new JTable(tableModel);
	    ((panelPiezasInfo) galeriaPanel).getTableContainer().add(new JScrollPane(table), BorderLayout.CENTER);
	
	    // Actualizar tableContainer para mostrar los nuevos componentes
	    ((panelPiezasInfo) galeriaPanel).getTableContainer().revalidate();
	    ((panelPiezasInfo) galeriaPanel).getTableContainer().repaint();
	}



	public static void main(String[] args) {
		
		ventanaPrincipal ventana = new ventanaPrincipal();
		ventana.setVisible(true);
	}
    
    
}



