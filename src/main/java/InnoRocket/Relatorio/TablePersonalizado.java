package InnoRocket.Relatorio;

import InnoRocket.Model.Cidade;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class TablePersonalizado extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CIDADE = 0;
    public static final int INDEX_QUANTIDADE = 1;

    protected String[] nomeColunas;
    protected Vector<String[]> vetorDados;

    public TablePersonalizado(String[] columnNames, Vector<String[]> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        String[] registro = vetorDados.get(linha);
        return registro[coluna];
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}
