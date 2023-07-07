package InnoRocket.Controller;

import InnoRocket.DAO.ContatoDAO;
import InnoRocket.Model.Contato;
import javax.swing.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.regex.Pattern;


public class ContatoController extends Validacoes{
    public static void cadastrar() throws Exception {
        try {
        String nome = JOptionPane.showInputDialog("Digite o nome do Contato: ");
        ValidarCampoVazio(nome);
        String telefone = JOptionPane.showInputDialog("Digite o telefone do Contato: ");
        ValidarCampoVazio(telefone);
        String email = JOptionPane.showInputDialog("Digite o email do Contato: ");
        ValidarCampoVazio(email);
        Contato contato = new Contato(null, nome, telefone, email);
        ContatoDAO.salvar(contato);
        JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void alterar() {
        try {
        Object[] selectionValues = ContatoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o contato!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);

        String nome = JOptionPane.showInputDialog("Digite o nome do Contato: ", contato.get(0).getNome());
        ValidarCampoVazio(nome);
        String telefone = JOptionPane.showInputDialog("Digite o telefone do Contato: ", contato.get(0).getTelefone());
        ValidarCampoVazio(telefone);
        String email = JOptionPane.showInputDialog("Digite o email do Contato: ", contato.get(0).getEmail());
        ValidarCampoVazio(email);
        Contato contatoAlterar = new Contato(null, nome, telefone, email);
        ContatoDAO.alterar(contatoAlterar);
        JOptionPane.showMessageDialog(null, "Contato alterado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void excluir() {
        try{
        Object[] selectionValues = ContatoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o Contato!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);
        ContatoDAO.excluir(contato.get(0));
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Contato não pode ser excluido pois está sendo usado em um processo!");
        }
    }
}
