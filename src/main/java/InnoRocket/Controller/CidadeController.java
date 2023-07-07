package InnoRocket.Controller;

import InnoRocket.DAO.CidadeDAO;
import InnoRocket.DAO.UfDAO;
import InnoRocket.Model.Cidade;
import InnoRocket.Model.Uf;
import javax.swing.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class CidadeController extends Validacoes{
    public static void cadastrar() throws Exception {
        try {
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade: ");
        ValidarCampoVazio(nome);
        Object[] selectionValues = UfDAO.listarPorSigla();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Listar Uf", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection);
        Cidade cidade = new Cidade(null, nome, uf.get(0));
        CidadeDAO.salvar(cidade);
        JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void alterar() {
        try {
        Object[] selectionValues = CidadeDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a cidade!",
                "lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade: ", cidade.get(0).getNome());
        ValidarCampoVazio(nome);
        Object[] selectionValues1 = UfDAO.listarPorSigla();
        String initialSelection1 = (String) selectionValues1[0];
        Object selection1 = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Listar Uf", JOptionPane.QUESTION_MESSAGE, null, selectionValues1, initialSelection1);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection1);
        Cidade cidadeAlterar = new Cidade(null, nome, uf.get(0));
        CidadeDAO.alterar(cidadeAlterar);
        JOptionPane.showMessageDialog(null, "Cidade alterada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void excluir() throws SQLIntegrityConstraintViolationException {
        try {
            Object[] selectionValues = CidadeDAO.listaPorNomes();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione a cidade!",
                    "lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
            CidadeDAO.excluir(cidade.get(0));
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Cidade não pode ser excluida pois está sendo usada em um processo!");
        }
    }
}
