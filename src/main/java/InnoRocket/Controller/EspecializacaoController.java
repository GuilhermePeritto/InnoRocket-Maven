package InnoRocket.Controller;

import InnoRocket.DAO.EspecioalizacaoDAO;
import InnoRocket.DAO.FotoDAO;
import InnoRocket.Model.Especializacao;
import InnoRocket.Model.Foto;

import javax.swing.*;
import java.util.List;

import static InnoRocket.View.MenuView.chamaMenuPrincipal;

public class EspecializacaoController {
    public static void cadastrar() throws ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Digite a nome da Especializacao: ");
        Especializacao especializacao = new Especializacao(null, nome);
        EspecioalizacaoDAO.salvar(especializacao);
        chamaMenuPrincipal();
    }

    public static void alterar() {
        Object[] selectionValues = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Especializacao!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacao = EspecioalizacaoDAO.buscaPorNome((String) selection);

        String nome = JOptionPane.showInputDialog("Digite a nome da Especializacao: ", especializacao.get(0).getNome());

        Especializacao especializacaoAlterar = new Especializacao(especializacao.get(0).getEspecializacaoId(), nome);
        EspecioalizacaoDAO.alterar(especializacaoAlterar);
        chamaMenuPrincipal();
    }

    public static void excluir() {
        Object[] selectionValues = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Especializacao!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacao = EspecioalizacaoDAO.buscaPorNome((String) selection);
        EspecioalizacaoDAO.excluir(especializacao.get(0));
        chamaMenuPrincipal();
    }
}
