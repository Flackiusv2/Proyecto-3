package Interfaz;
import java.awt.Component;

import javax.swing.*;

import pieza.Pieza;

public class piezaRender extends JLabel implements ListCellRenderer<Pieza> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Pieza> list, Pieza pieza, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        setText(pieza.getTitulo() + " - " + pieza.getPrecioFijo());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);

        return this;
    }
}

