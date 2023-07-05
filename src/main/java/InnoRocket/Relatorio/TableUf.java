package InnoRocket.Relatorio;

import InnoRocket.Model.Uf;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableUf extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_SIGLA = 1;
    public static final int INDEX_NOME = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<Uf> vetorDados;

    public TableUf(String[] columnNames, Vector<Uf> vetorDados) {
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
        Uf registroUf = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroUf.getUfId();
            case INDEX_SIGLA:
                return registroUf.getSigla();
            case INDEX_NOME:
                return registroUf.getNome();
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