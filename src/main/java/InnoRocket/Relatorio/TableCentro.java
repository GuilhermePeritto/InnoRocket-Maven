package InnoRocket.Relatorio;

import InnoRocket.Model.Centro;
import InnoRocket.Model.Cidade;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableCentro extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    public static final int INDEX_CODIGO = 0;
    public static final int INDEX_NOME = 1;
    public static final int INDEX_RUA = 2;
    public static final int INDEX_CEP = 3;
    public static final int INDEX_NUMERO = 4;
    public static final int INDEX_BAIRRO = 5;
    public static final int INDEX_COMPLEMENTO = 6;
    public static final int INDEX_CIDADE = 7;
    public static final int INDEX_STATUS = 8;
    public static final int INDEX_REDESSOCIAIS = 9;
    public static final int INDEX_FOTO = 10;
    public static final int INDEX_DATACADASTRO = 11;
    public static final int INDEX_DATACRIACAO = 12;
    public static final int INDEX_ESPECIALIZACAO = 13;
    public static final int INDEX_CONTATO = 14;
    public static final int INDEX_ATIVIDADE = 15;
    public static final int INDEX_ESCONDIDO = 16;

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
            case INDEX_CODIGO:
                return registroCentro.getCentroId();
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
            case INDEX_ESPECIALIZACAO:
                return registroCentro.getEspecializacao().get(0).getNome();
            case INDEX_CONTATO:
                return registroCentro.getContato().getNome();
            case INDEX_ATIVIDADE:
                return registroCentro.getAtividade().get(0).getNome();
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