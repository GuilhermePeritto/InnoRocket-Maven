package InnoRocket.Controller;

import InnoRocket.DAO.EspecioalizacaoDAO;
import InnoRocket.Model.Especializacao;
import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;


public class EspecializacaoController extends Validacoes{
    public static void cadastrar() throws Exception {
        try {
        String nome = JOptionPane.showInputDialog("Digite o nome da Especializacao: ");
        ValidarCampoVazio(nome);
        Especializacao especializacao = new Especializacao(null, nome);
        EspecioalizacaoDAO.salvar(especializacao);
        JOptionPane.showMessageDialog(null, "Especializacao cadastrada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void alterar() {
        try {
        Object[] selectionValues = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Especializacao!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacao = EspecioalizacaoDAO.buscaPorNome((String) selection);

        String nome = JOptionPane.showInputDialog("Digite o nome da Especializacao: ", especializacao.get(0).getNome());
        ValidarCampoVazio(nome);
        Especializacao especializacaoAlterar = new Especializacao(especializacao.get(0).getEspecializacaoId(), nome);
        EspecioalizacaoDAO.alterar(especializacaoAlterar);
        JOptionPane.showMessageDialog(null, "Especializacao alterada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void excluir() {
        Object[] selectionValues = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Especializacao!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacao = EspecioalizacaoDAO.buscaPorNome((String) selection);
        EspecioalizacaoDAO.excluir(especializacao.get(0));
        JOptionPane.showMessageDialog(null, "Especializacao excluida com sucesso!");
    }
}
