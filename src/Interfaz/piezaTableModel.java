package Interfaz;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import pieza.Pieza;

public class piezaTableModel extends AbstractTableModel {
    private List<Pieza> piezas;
    private final String[] columnNames = {"Titulo", "Autor", "Año de Creación", "Lugar de Creación", "Precio Fijo", "Tipo de Pieza"};

    public piezaTableModel(List<Pieza> piezas) {
        this.piezas = piezas;
    }

    @Override
    public int getRowCount() {
        return piezas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pieza pieza = piezas.get(rowIndex);
        switch (columnIndex) {
            case 0: return pieza.getTitulo();
            case 1: return pieza.getAutor() != null ? pieza.getAutor().getNombre() : "Desconocido";
            case 2: return pieza.getAnioCreacion();
            case 3: return pieza.getLugarCreacion();
            case 4: return pieza.getPrecioFijo();
            case 5: return pieza.getTipoPieza();
            default: return null;
        }
    }
}
