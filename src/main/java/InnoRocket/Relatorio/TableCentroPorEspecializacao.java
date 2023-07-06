package InnoRocket.Relatorio;
import InnoRocket.Model.CentroPorCidade;
import InnoRocket.Model.CentroPorEspecializacao;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableCentroPorEspecializacao extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_ESPECIALIZACAO = 0;
    public static final int INDEX_QUANTCENTRO = 1;

    public static final int INDEX_ESCONDIDO = 2;

    protected String[] nomeColunas;
    protected Vector<CentroPorEspecializacao> vetorDados;

    public TableCentroPorEspecializacao(String[] columnNames, Vector<CentroPorEspecializacao> vetorDados) {
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
        CentroPorEspecializacao registroCidade = vetorDados.get(linha);
        switch (coluna) {
            case INDEX_ESPECIALIZACAO:
                return registroCidade.getEspecializacao();
            case INDEX_QUANTCENTRO:
                return registroCidade.getQuantidadeCentro();
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