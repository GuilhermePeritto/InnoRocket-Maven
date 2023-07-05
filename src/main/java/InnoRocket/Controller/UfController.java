package InnoRocket.Controller;

import InnoRocket.DAO.*;
import InnoRocket.Model.Uf;
import javax.swing.*;
import java.util.List;

import static InnoRocket.View.MenuView.chamaMenuPrincipal;
import static InnoRocket.View.MenuView.menuExcluir;

public class UfController {
    public static void cadastroUf() throws ClassNotFoundException {
        String sigla = JOptionPane.showInputDialog("Digite a sigla da UF: ");
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            cadastroUf();
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da UF: ");
        Uf ufCadastrar = new Uf(null,sigla, nome);
        UfDAO.salvar(ufCadastrar);
        JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso!");
        chamaMenuPrincipal();
    }

    public static void alterarUf() {
        Object[] selectionValues = UfDAO.listarPorSigla();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a UF",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection);


        String sigla = JOptionPane.showInputDialog("Digite a sigla da UF: ", uf.get(0).getSigla());
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            alterarUf();
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da UF: ", uf.get(0).getNome());
        Uf ufAlterar = new Uf(uf.get(0).getUfId(),sigla, nome);
        UfDAO.alterar(ufAlterar);
        JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
        chamaMenuPrincipal();
    }

    public static void excluirUf() {
        try {
            Object[] selectionValues = UfDAO.listarPorSigla();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione a UF",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            List<Uf> uf = UfDAO.buscaPorSigla((String) selection);
            int opcaoExcluir = JOptionPane.showOptionDialog(null, "Deseja realmente excluir o registro?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoExcluir == JOptionPane.YES_NO_OPTION) {
                UfDAO.excluir(uf.get(0));
            } else {
                excluirUf();
            }
        } catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null, "Deseja realmente cancelar?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
                menuExcluir();
            } /*else {

            }*/
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
        JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
        chamaMenuPrincipal();
    }
}
