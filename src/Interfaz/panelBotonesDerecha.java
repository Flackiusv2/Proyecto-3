
package Interfaz;

import javax.swing.*;
import java.awt.*;


public class panelBotonesDerecha extends JPanel {
    private botonesGod cargarGaleriaBtn;
    private botonesGod guardarGaleriaBtn;
    private botonesGod loginBtn;
    private Component espacioArriba;
    private Component espacioMedio;
    private Component espacioAbajo;
    
    public panelBotonesDerecha() {
        // Configurar el layout del panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(245, 245, 220));
        // Crear los botones
        cargarGaleriaBtn = new botonesGod("Cargar Galería");
        guardarGaleriaBtn = new botonesGod("Guardar Galería");
        loginBtn = new botonesGod("Iniciar Sesión");
        Dimension botonDimension = new Dimension(200, 200); 
        cargarGaleriaBtn.setPreferredSize(botonDimension);
        guardarGaleriaBtn.setPreferredSize(botonDimension);
        loginBtn.setPreferredSize(botonDimension);
        
        // Añadir los botones al panel
        espacioArriba = Box.createRigidArea(new Dimension(0, 180));
        espacioAbajo = Box.createRigidArea(new Dimension(0, 200));
        
        add(espacioArriba); // Añade espacio entre los botones
        add(cargarGaleriaBtn);
        add(espacioAbajo); // Añade espacio entre los botones
        
        setPreferredSize(new Dimension(150, 500));
    }

    // Métodos para obtener los botones
    public botonesGod getCargarGaleriaBtn() {
        return cargarGaleriaBtn;
    }

    public botonesGod getGuardarGaleriaBtn() {
        return guardarGaleriaBtn;
    }
    
	public botonesGod getLoginBtn() {
		return loginBtn;
	}
	
	
	public void removeEspacios() {
		remove(espacioArriba);
		remove(espacioAbajo);
	}

	public void agregarLogin() {
	
        add(espacioArriba); 
		add(loginBtn);
		add(espacioAbajo);
	}
}


