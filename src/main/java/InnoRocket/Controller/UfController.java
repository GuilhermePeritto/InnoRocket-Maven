package InnoRocket.Controller;
import InnoRocket.DAO.*;
import InnoRocket.Model.Uf;
import javax.swing.*;
import java.util.List;

import static InnoRocket.View.MenuView.*;

public class UfController {
    public static void cadastrar() throws ClassNotFoundException {
        String sigla = JOptionPane.showInputDialog("Digite a sigla da uf: ");
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            cadastrar();
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da UF: ");
        Uf ufCadastrar = new Uf(null,sigla, nome);
        UfDAO.salvar(ufCadastrar);
        JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso!");
        chamaMenuPrincipal();
    }

    public static void alterar() {
        try{
            Object[] selectionValues = UfDAO.listarPorSigla();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione a UF",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            List<Uf> uf = UfDAO.buscaPorSigla((String) selection);
            String sigla = JOptionPane.showInputDialog("Digite a sigla da UF: ", uf.get(0).getSigla());
            if (sigla.length() > 2){
                JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
                alterar();
            }
            String nome = JOptionPane.showInputDialog("Digite o nome da UF: ", uf.get(0).getNome());
            Uf ufAlterar = new Uf(uf.get(0).getUfId(),sigla, nome);
            UfDAO.alterar(ufAlterar);
        }
        catch (NullPointerException e){
            int opcaoCancelar = JOptionPane.showOptionDialog(null, "Deseja realmente cancelar?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
                menuAlterar();
            } else{
                alterar();
            }
        }
        catch (Exception e) {
            chamaMenuPrincipal();
        }

        JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
        chamaMenuPrincipal();
    }

    public static void excluir() {
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
                excluir();
            }
        } catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null, "Deseja realmente cancelar?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
                menuExcluir();
            } else{
                excluir();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
        JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
    }
}