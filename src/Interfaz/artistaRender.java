package Interfaz;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import pieza.Pieza;

class artistaRender extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Pieza) {
            value = ((Pieza) value).getAutor().getNombre();
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}
