package InnoRocket.Relatorio;

import InnoRocket.Model.Cidade;
import InnoRocket.Model.Contato;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableCidade extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_UF = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<Cidade> vetorDados;

    public TableCidade(String[] columnNames, Vector<Cidade> vetorDados) {
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
        Cidade registroCidade = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroCidade.getCidadeId();
            case INDEX_NOME:
                return registroCidade.getNome();
            case INDEX_UF:
                return registroCidade.getUf().getNome();
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