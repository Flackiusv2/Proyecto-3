
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class botonesGod extends JButton {
    public botonesGod(String label) {
        super(label);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(118, 185, 0)); // Color verde cuando el botón está presionado
        } else {
            g.setColor(new Color(118, 185, 0)); // Color verde cuando el botón no está presionado
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.gray);
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    private Shape shape;
}

