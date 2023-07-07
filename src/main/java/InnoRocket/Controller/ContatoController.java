package InnoRocket.Controller;

import InnoRocket.DAO.ContatoDAO;
import InnoRocket.Model.Contato;
import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;


public class ContatoController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        String nome = getValidNome(null);
        String telefone = getValidTelefone(null);
        String email = JOptionPane.showInputDialog("Digite o email do Contato: ");
        Contato contato = new Contato(null, nome, telefone, email);
        ContatoDAO.salvar(contato);
    }

    public static void alterar() {
        Object[] selectionValues = ContatoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o contato!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);

        String nome = getValidNome(contato.get(0).getNome());
        String telefone = getValidTelefone(contato.get(0).getTelefone());
        String email = JOptionPane.showInputDialog("Digite o email do Contato: ", contato.get(0).getEmail());
        Contato contatoAlterar = new Contato(null, nome, telefone, email);
        ContatoDAO.alterar(contatoAlterar);
    }

//    public static void alterar() {
//        Object[] selectionValues = ContatoDAO.listaPorNomes();
//        String initialSelection = (String) selectionValues[0];
//        Object selection = JOptionPane.showInputDialog(null, "Selecione o contato!",
//                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
//        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);
//
//        String nome = JOptionPane.showInputDialog("Digite o nome do Contato: ", contato.get(0).getNome());
//        String telefone = JOptionPane.showInputDialog("Digite o telefone do Contato: ", contato.get(0).getTelefone());
//        String email = JOptionPane.showInputDialog("Digite o email do Contato: ", contato.get(0).getEmail());
//        Contato contatoAlterar = new Contato(null, nome, telefone, email);
//
//        ContatoDAO.alterar(contatoAlterar);
//        chamaMenuPrincipal();
//    }

    public static void excluir() {
        Object[] selectionValues = ContatoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o Contato!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);
        ContatoDAO.excluir(contato.get(0));
    }
}
