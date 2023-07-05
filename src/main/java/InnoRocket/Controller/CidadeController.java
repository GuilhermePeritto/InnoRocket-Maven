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
        Object[] selectionValues = CidadeDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a cidade!",
                "lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
        String nome = JOptionPane.showInputDialog("Digite o nome do Contato: ", cidade.get(0).getNome());
        Object[] selectionValues1 = UfDAO.listarPorSigla();
        String initialSelection1 = (String) selectionValues1[0];
        Object selection1 = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Listar Uf", JOptionPane.QUESTION_MESSAGE, null, selectionValues1, initialSelection1);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection1);
        Cidade cidadeAlterar = new Cidade(null, nome, uf.get(0));
        CidadeDAO.alterar(cidadeAlterar);
        chamaMenuPrincipal();
    }

    public static void excluir() {
        Object[] selectionValues = CidadeDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a cidade!",
                "lista de Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
        CidadeDAO.excluir(cidade.get(0));
        chamaMenuPrincipal();
    }
}
