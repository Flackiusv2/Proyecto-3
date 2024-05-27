package probando;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JTextField;
import javax.swing.JButton;

public class test1 extends JFrame{

	public test1 () {
		
		setLayout(new BorderLayout());
		
		JLabel izquierda = new JLabel("Izquierda");
		izquierda.setBackground(Color.cyan);
		izquierda.setOpaque(true);
		JLabel centro  =  new JLabel("Centro");
		centro.setBackground(Color.YELLOW);
		centro.setOpaque(true);
		JTextField arriba =  new JTextField("Arriba");
		JButton abajo =  new JButton("Abajo");
		
		add(izquierda, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		add(arriba, BorderLayout.NORTH);
		add(abajo, BorderLayout.SOUTH);
		
		setTitle("Mi primera chamba");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1080,720);
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new test1();
	}
	
	
	
	
	
}









