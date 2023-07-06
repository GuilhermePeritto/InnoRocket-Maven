package InnoRocket.Controller;

import InnoRocket.DAO.EspecioalizacaoDAO;
import InnoRocket.Model.Especializacao;
import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;


public class EspecializacaoController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        String nome = getValidNome(null);
        Especializacao especializacao = new Especializacao(null, nome);
        EspecioalizacaoDAO.salvar(especializacao);
    }

    public static void alterar() {
        Object[] selectionValues = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Especializacao!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacao = EspecioalizacaoDAO.buscaPorNome((String) selection);

        String nome = getValidNome(null);

        Especializacao especializacaoAlterar = new Especializacao(especializacao.get(0).getEspecializacaoId(), nome);
        EspecioalizacaoDAO.alterar(especializacaoAlterar);
    }

    public static void excluir() {
        Object[] selectionValues = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Especializacao!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacao = EspecioalizacaoDAO.buscaPorNome((String) selection);
        EspecioalizacaoDAO.excluir(especializacao.get(0));
    }

    private static String getValidNome(String nome) {
        do {
            nome = JOptionPane.showInputDialog("Digite a nome da Especializacao ");
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
