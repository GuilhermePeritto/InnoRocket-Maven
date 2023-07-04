package InnoRocket.Controller;

import InnoRocket.DAO.CidadeDAO;
import InnoRocket.DAO.ContatoDAO;
import InnoRocket.DAO.UfDAO;
import InnoRocket.Model.Cidade;
import InnoRocket.Model.Contato;
import InnoRocket.Model.Uf;

import javax.swing.*;
import java.util.List;

import static InnoRocket.View.MenuView.chamaMenuPrincipal;

public class CidadeController {
    public static void cadastrar() throws ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade: ");
        Object[] selectionValues = UfDAO.listarPorSigla();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Listar Uf", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection);
        Cidade cidade = new Cidade(null, nome, uf.get(0));
        CidadeDAO.salvar(cidade);
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
