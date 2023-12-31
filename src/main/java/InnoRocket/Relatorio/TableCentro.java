package InnoRocket.Relatorio;

import InnoRocket.Model.Centro;
import InnoRocket.Model.Cidade;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableCentro extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
//    public static final int INDEX_ID = 0;
    public static final int INDEX_NOME = 0;
    public static final int INDEX_RUA = 1;
    public static final int INDEX_CEP = 2;
    public static final int INDEX_NUMERO = 3;
    public static final int INDEX_BAIRRO = 4;
    public static final int INDEX_COMPLEMENTO = 5;
    public static final int INDEX_CIDADE = 6;
    public static final int INDEX_STATUS = 7;
    public static final int INDEX_REDESSOCIAIS = 8;
    public static final int INDEX_FOTO = 9;
    public static final int INDEX_DATACADASTRO = 10;
    public static final int INDEX_DATACRIACAO = 11;
    public static final int INDEX_ESCONDIDO = 12;

    protected String[] nomeColunas;
    protected Vector<Centro> vetorDados;

    public TableCentro (String[] columnNames, Vector<Centro> vetorDados) {
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
        Centro registroCentro = vetorDados.get(linha);
        switch (coluna) {
//            case INDEX_ID:
//                return registroCentro.getCentroId();
            case INDEX_NOME:
                return registroCentro.getNome();
            case INDEX_RUA:
                return registroCentro.getRua();
            case INDEX_CEP:
                return registroCentro.getCep();
            case INDEX_NUMERO:
                return registroCentro.getNumero();
            case INDEX_BAIRRO:
                return registroCentro.getBairro();
            case INDEX_COMPLEMENTO:
                return registroCentro.getComplemento();
            case INDEX_CIDADE:
                return registroCentro.getCidade().getNome();
            case INDEX_STATUS:
                return registroCentro.getStatus().toString();
            case INDEX_REDESSOCIAIS:
                return registroCentro.getRedesSociais();
            case INDEX_FOTO:
                return registroCentro.getFoto().getNome();
            case INDEX_DATACADASTRO:
                return registroCentro.getDataCadastro().toString();
            case INDEX_DATACRIACAO:
                return registroCentro.getDataCriacao().toString();
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