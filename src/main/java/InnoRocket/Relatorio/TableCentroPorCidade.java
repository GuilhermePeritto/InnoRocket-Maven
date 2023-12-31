package InnoRocket.Relatorio;

import InnoRocket.Model.CentroPorCidade;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableCentroPorCidade extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CIDADE = 0;
    public static final int INDEX_QUANT = 1;
    public static final int INDEX_ESCONDIDO = 2;

    protected String[] nomeColunas;
    protected Vector<CentroPorCidade> vetorDados;

    public TableCentroPorCidade(String[] columnNames, Vector<CentroPorCidade> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return coluna != INDEX_ESCONDIDO;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        CentroPorCidade registroFoto = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CIDADE:
                return registroFoto.getCidade();
            case INDEX_QUANT:
                return registroFoto.getQuantidadeCentro();
            default:
                return new Object();
        }
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