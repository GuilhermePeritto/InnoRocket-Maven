package InnoRocket.Relatorio;

import InnoRocket.Model.Foto;
import InnoRocket.Model.Uf;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableFoto extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_URL = 1;
    public static final int INDEX_ESCONDIDO = 2;

    protected String[] nomeColunas;
    protected Vector<Foto> vetorDados;

    public TableFoto(String[] columnNames, Vector<Foto> vetorDados) {
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
        Foto registroFoto = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroFoto.getFotoId();
            case INDEX_URL:
                return registroFoto.getNome();
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