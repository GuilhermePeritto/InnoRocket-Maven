package InnoRocket.Controller;

import InnoRocket.DAO.CidadeDAO;
import InnoRocket.DAO.ContatoDAO;
import InnoRocket.DAO.UfDAO;
import InnoRocket.Model.Cidade;
import InnoRocket.Model.Contato;
import InnoRocket.Model.Uf;

import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;

public class CidadeController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        String nome = getValidNome(null);
        Object[] selectionValues = UfDAO.listarPorSigla();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Listar Uf", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection);
        Cidade cidade = new Cidade(null, nome, uf.get(0));
        CidadeDAO.salvar(cidade);
    }

    public static void alterar() {
        Object[] selectionValues = CidadeDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a cidade!",
                "lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
        String nome =getValidNome(null);
        Object[] selectionValues1 = UfDAO.listarPorSigla();
        String initialSelection1 = (String) selectionValues1[0];
        Object selection1 = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Listar Uf", JOptionPane.QUESTION_MESSAGE, null, selectionValues1, initialSelection1);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection1);
        Cidade cidadeAlterar = new Cidade(null, nome, uf.get(0));
        CidadeDAO.alterar(cidadeAlterar);
    }

    public static void excluir() {
        Object[] selectionValues = CidadeDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a cidade!",
                "lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
        CidadeDAO.excluir(cidade.get(0));
    }

    private static String getValidNome(String nome) {
        do {
            nome = JOptionPane.showInputDialog("Digite a nome da Cidade ");
            if (nome == null) {
                return null;
            }
            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O nome não pode ser vazio. Por favor, digite um nome válido.");
            } else if (containsSpecialCharacters(nome)) {
                JOptionPane.showMessageDialog(null, "O nome não pode conter caracteres especiais. Por favor, digite um nome válido.");
            }
        } while (nome.isEmpty() || containsSpecialCharacters(nome));
        return nome;
    }

    private static boolean containsSpecialCharacters(String text) {
        Pattern specialChars = Pattern.compile("[^a-zA-Z0-9]");
        return specialChars.matcher(text).find();
    }
}
