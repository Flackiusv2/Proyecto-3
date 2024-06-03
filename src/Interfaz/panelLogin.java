package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelLogin extends JPanel {

	private String userType;
	public panelLogin() {
	    // Configurar las propiedades del JPanel
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    setBackground(new Color(245, 245, 220)); // Color beige
	
	    // Crear el label
	    JLabel label = new JLabel("<html><font size='6'>" + "Selecciona el tipo de usuario:" + "</font></html>");
	    label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el label
	    add(label);
	    
	    
	    // Crear los botones
	    botonesGod adminBtn = new botonesGod("Admin");
	    botonesGod compradorBtn = new botonesGod("Comprador");
	    botonesGod empleadoBtn = new botonesGod("Empleado");
	
	    // Establecer un tamaño preferido para los botones
	    Dimension buttonSize = new Dimension(150, 130); // Puedes ajustar estos valores según tus necesidades
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
                panelVerificar();

                // Actualizar el panel
                revalidate();
            }
        });
	    
	    
	    // Crear un panel para los botones
	    JPanel buttonPanel = new JPanel();
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
	
	
	public void panelVerificar() {
		
		JLabel userLabel = new JLabel("Usuario:");
	    JTextField userField = new JTextField(20);
	    userField.setMaximumSize(new Dimension(200, 30));
	    
	    JLabel passwordLabel = new JLabel("Contraseña:");
	    JTextField passwordField = new JTextField(20);
	    

	    botonesGod enterBtn = new botonesGod("Entrar a la galeria");

	    // Añadir los nuevos componentes al panel
	    add(userLabel);
	    add(userField);
	    add(Box.createRigidArea(new Dimension(0, 150))); 
	    add(passwordLabel);
	    add(passwordField);
	    add(Box.createRigidArea(new Dimension(0, 150))); 
	    add(enterBtn);
	}
	
}


