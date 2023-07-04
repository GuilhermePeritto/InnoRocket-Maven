package InnoRocket.Controller;

import InnoRocket.DAO.ContatoDAO;
import InnoRocket.DAO.EspecioalizacaoDAO;
import InnoRocket.Model.Contato;
import InnoRocket.Model.Especializacao;

import javax.swing.*;
import java.util.List;

import static InnoRocket.View.MenuView.chamaMenuPrincipal;

public class ContatoController {
    public static void cadastrar() throws ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Digite o nome do Contato: ");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do Contato: ");
        String email = JOptionPane.showInputDialog("Digite o email do Contato: ");
        Contato contato = new Contato(null, nome, telefone, email);
        ContatoDAO.salvar(contato);
        chamaMenuPrincipal();
    }

    public static void alterar() {
        Object[] selectionValues = ContatoDAO.listarPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o contato!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome(((String) selection);

        String nome = JOptionPane.showInputDialog("Digite o nome do Contato: ", contato.get(0).getNome());
        String telefone = JOptionPane.showInputDialog("Digite o telefone do Contato: ", contato.get(0).getTelefone());
        String email = JOptionPane.showInputDialog("Digite o email do Contato: ", contato.get(0).getEmail());
        Contato contatoAlterar = new Contato(null, nome, telefone, email);

        ContatoDAO.alterar(contatoAlterar);
        chamaMenuPrincipal();
    }

    public static void excluir() {
        Object[] selectionValues = ContatoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o Contato!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);
        ContatoDAO.excluir(contato.get(0));
        chamaMenuPrincipal();
    }
}
