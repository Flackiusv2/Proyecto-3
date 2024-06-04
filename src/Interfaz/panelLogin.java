package Interfaz;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import logica.Galeria;
import usuario.Comprador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class panelLogin extends JPanel {
	
	Map<String,String> MapaUsuarios;
	private Galeria laGaleria;
	private String userType;
	private JButton realizarCompra;
	private JButton atras;
	private JLabel label;
	private JPanel buttonPanel;
	Comprador mySelf;
	JButton historialCompras;
	JButton verHpieza;
	JButton verHartista;
	
	public panelLogin(Galeria galeria) {
		this.laGaleria = galeria;
		if (galeria != null){
		this.MapaUsuarios = laGaleria.getControladorUsuarios().getBaseDeDatos();}
	    // Configurar las propiedades del JPanel
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    setBackground(new Color(245, 245, 220)); // Color beige
	
	    // Crear el label
	    label = new JLabel("<html><font size='6'>" + "Selecciona el tipo de usuario:" + "</font></html>");
	    label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el label
	    add(label);
	    
	    
	    // Crear los botones
	    
	    botonesGod adminBtn = new botonesGod("Admin");
	    botonesGod compradorBtn = new botonesGod("Comprador");
	    botonesGod empleadoBtn = new botonesGod("Empleado");
	    
	    //MENU DE COMPRADOR - botones
	    realizarCompra = new JButton("Realizar compra fija");
	    historialCompras = new JButton("Ver historial de compras");
	    verHpieza = new JButton("Ver historial de una pieza");
		verHartista = new JButton("Ver historia de un artista");
	    atras = new JButton("Salir");
	   
	    // Establecer un tamaño preferido para los botones
	    Dimension buttonSize = new Dimension(150, 130); 
	    adminBtn.setPreferredSize(buttonSize);
	    compradorBtn.setPreferredSize(buttonSize);
	    empleadoBtn.setPreferredSize(buttonSize);
	    
	 
        compradorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardar el tipo de usuario
                userType = "comprador";

                // Limpiar el panel
                removeAll();
                repaint();

                // Crear los nuevos componentes
                panelVerificar(userType);

                // Actualizar el panel
                revalidate();
            }
        });
	    
	    
	    // Crear un panel para los botones
	    buttonPanel = new JPanel();
	    buttonPanel.setPreferredSize(new Dimension(150, 200));
	    buttonPanel.setBackground(new Color(245, 245, 220)); // Color beige
	
	    // Añadir cajas vacías y botones al panel de botones
	    buttonPanel.add(Box.createHorizontalGlue());
	    buttonPanel.add(adminBtn);
	    buttonPanel.add(Box.createRigidArea(new Dimension(30, 0))); // Espacio entre los botones
	    buttonPanel.add(compradorBtn);
	    buttonPanel.add(Box.createRigidArea(new Dimension(30, 0))); // Espacio entre los botones
	    buttonPanel.add(empleadoBtn);
	    buttonPanel.add(Box.createHorizontalGlue());
	
	    // Añadir el panel de botones al panel principal
	    add(Box.createRigidArea(new Dimension(0, 130))); 
	    add(buttonPanel);
	    
	}
	
	
	public void panelVerificar(String tipoUsuario) {
		
		setLayout(new GridBagLayout());
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.anchor = GridBagConstraints.WEST;
	    constraints.insets = new Insets(10, 10, 10, 10);

	    // Crear los nuevos componentes
	    JLabel userLabel = new JLabel("<html><font size='5'>" + "Usuario:" + "</font></html>");
	    JTextField userField = new JTextField(20);
	    userField.setMaximumSize(new Dimension(550, 60));
	    
	    
	    JLabel passwordLabel = new JLabel("<html><font size='5'>" + "Contraseña:" + "</font></html>");
	    JPasswordField passwordField = new JPasswordField(20);
	    passwordField.setMaximumSize(new Dimension(500, 30));
	
	    botonesGod enterBtn = new botonesGod("Entrar a la galeria");
	    enterBtn.setPreferredSize(new Dimension(140, 75));
	    //PARA VERIFICAR EL LOGIN
	    enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String username = userField.getText();
            	String password = new String(passwordField.getPassword());

                String password_verificacion = MapaUsuarios.get(username);
            	
        		if (password.equals(password_verificacion)) { 		
        			mySelf = laGaleria.getControladorUsuarios().getMapaCompradores().get(username);
        			menuComprador();
        			
        		}else {
        			System.out.println("Contraseña incorrecta, intente nuevamente!");
        		}

                
            }
        });
	    
	    
	   
	    // Añadir los nuevos componentes al panel
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    add(userLabel, constraints);

	    constraints.gridx = 1;
	    add(userField, constraints);

	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    add(passwordLabel, constraints);

	    constraints.gridx = 1;
	    add(passwordField, constraints);

	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    constraints.gridwidth = 2;
	    constraints.anchor = GridBagConstraints.SOUTH;
	    add(enterBtn, constraints);
	    
	    constraints.anchor = GridBagConstraints.EAST; // Alinear el componente a la esquina superior derecha

	    add(atras, constraints);
	}
	
	
	public void menuComprador() {
		// Limpiar el panel
	    removeAll();
	    repaint();
	    
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;

		
		add(realizarCompra, gbc);
		add(Box.createRigidArea(new Dimension(0, 50)));
		add(historialCompras, gbc);
		add(Box.createRigidArea(new Dimension(0, 50)));
		add(verHpieza, gbc);
		add(Box.createRigidArea(new Dimension(0, 50)));
		add(verHartista, gbc);
		add(Box.createRigidArea(new Dimension(0, 50)));
		add(atras, gbc);

	    revalidate();
	    repaint();
		
		
	}
	
	public void reset() {
		removeAll();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(label);
		add(Box.createRigidArea(new Dimension(0, 130))); 
		add(buttonPanel);
		add(atras);
		revalidate();
		repaint();
	}
	
	
	public JButton getAtras() {
		return atras;
	}

	public JButton getRealizarCompra() {
		return realizarCompra;
	}
	
	public JButton getHistorialBtn() {
		return historialCompras;
	}

	public Comprador getComprador() {
        return mySelf;
    }
	
	public JButton getVerHpieza() {
		return verHpieza;
	}

	public JButton getVerHartista() {
		return verHartista;
	}
	
}


