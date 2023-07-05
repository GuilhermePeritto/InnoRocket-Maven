package InnoRocket.Controller;

import InnoRocket.DAO.CentroDAO;
import InnoRocket.DAO.ContatoDAO;
import InnoRocket.Model.Centro;
import InnoRocket.Model.Contato;

import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;

import static InnoRocket.View.MenuView.chamaMenuPrincipal;

public class ContatoController {
    public static void cadastrar() throws ClassNotFoundException {
        String nome = getValidNome(null);
        String telefone = getValidTelefone(null);
        String email = JOptionPane.showInputDialog("Digite o email do Contato: ");
        Contato contato = new Contato(null, nome, telefone, email);
        ContatoDAO.salvar(contato);
        chamaMenuPrincipal();
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
        chamaMenuPrincipal();
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
        chamaMenuPrincipal();
    }


    // esse metodos eu pegui aqui da empresa é um teste para ver se da boa
    private static String getValidNome(String nome) {
        do {
            nome = JOptionPane.showInputDialog("Digite o nome do Contato: ");
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

    private static String getValidTelefone(String telefone) {
        do {
            telefone = JOptionPane.showInputDialog("Digite o telefone do Contato: ");
            if (telefone == null) {
                return null;
            }
            if (telefone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O telefone não pode ser vazio. Por favor, digite um telefone válido.");
            } else if (!containsOnlyNumbers(telefone)) {
                JOptionPane.showMessageDialog(null, "O telefone deve conter apenas números. Por favor, digite um telefone válido.");
            }
        } while (telefone.isEmpty() || !containsOnlyNumbers(telefone));
        return telefone;
    }

    private static boolean containsOnlyNumbers(String text) {
        return text.matches("[0-9]+");
        // o zé vi que essse !telefone.matches("\\d+")); significa que estamos procurando um ou mais dígitos
        // vi isso no chatGPT não tenho vergonha não minto tbm sou filho de deus KKKKKKK
    }

    private static boolean containsSpecialCharacters(String text) {
        Pattern specialChars = Pattern.compile("[^a-zA-Z0-9]");
        return specialChars.matcher(text).find();
    }
}
