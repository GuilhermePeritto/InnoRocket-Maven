package InnoRocket.Controller;

import InnoRocket.DAO.*;
import InnoRocket.Model.Uf;
import javax.swing.*;
import java.util.List;

import static InnoRocket.View.MenuView.chamaMenuPrincipal;

public class UfController {
    public static void cadastrar() throws ClassNotFoundException {
        String sigla = JOptionPane.showInputDialog("Digite a sigla da uf: ");
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            cadastrar();
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da uf: ");
        Uf ufCadastrar = new Uf(null,sigla, nome);
        UfDAO.salvar(ufCadastrar);
        chamaMenuPrincipal();
    }

    public static void alterar() {
        Object[] selectionValues = UfDAO.listarPorSigla();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection);


        String sigla = JOptionPane.showInputDialog("Digite a sigla da uf: ", uf.get(0).getSigla());
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            alterar();
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da uf: ", uf.get(0).getNome());
        Uf ufAlterar = new Uf(uf.get(0).getUfId(),sigla, nome);
        UfDAO.alterar(ufAlterar);
        chamaMenuPrincipal();
    }

    public static void excluir() {
        Object[] selectionValues = UfDAO.listarPorSigla();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a UF!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection);
        UfDAO.excluir(uf.get(0));
        chamaMenuPrincipal();
    }
}
