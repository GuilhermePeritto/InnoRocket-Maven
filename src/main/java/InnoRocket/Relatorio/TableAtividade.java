package InnoRocket.Relatorio;

import InnoRocket.Model.Atividade;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableAtividade extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_DESCRICAO = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<Atividade> vetorDados;

    public TableAtividade(String[] columnNames, Vector<Atividade> vetorDados) {
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
        Atividade registroCidade = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_CODIGO:
                return registroCidade.getAtividadeId();
            case INDEX_NOME:
                return registroCidade.getNome();
            case INDEX_DESCRICAO:
                return registroCidade.getDescricao();
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