package Controller;

import Repository.UfDAO;
import View.MenuView;

import javax.swing.*;

import static Controller.AtividadeController.cadastroAtividade;
import static Controller.CidadeController.cadastroCidade;
import static Controller.ContatoController.cadastroContato;
import static Controller.EspecializacaoController.cadastroEspecializacao;
import static Controller.UfController.cadastroUf;

public class MenuController extends MenuView {

    public static void listBoxCadastros() {
        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especializacao", "Foto", "Uf"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de cadastro",
                    "Cadastro", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":
                    cadastroAtividade();
                    break;
                case "Centro":

                    break;
                case "Cidade":
                    cadastroCidade();
                    break;
                case "Contato":
                    cadastroContato();
                    break;
                case "Especializacao":
                    cadastroEspecializacao();
                    break;
                case "Foto":

                    break;
                case "Uf":
                    cadastroUf();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxCadastros();
            }
        } catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null," Deseja realmente cancelar? ",
                    "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION){
                chamaMenuPrincipal();
            }else {
                listBoxCadastros();
            }
        }

        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu de cadastro." + e.getMessage());
            chamaMenuPrincipal();
        }
    }

    public static void listBoxProcessos() {
        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especializacao", "Foto", "Uf"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":

                    break;
                case "Centro":

                    break;
                case "Cidade":

                    break;
                case "Contato":

                    break;
                case "Especializacao":

                    break;
                case "Foto":

                    break;
                case "Uf":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }

    public static void listBoxRelatorios() {
        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especializacao", "Foto", "Uf"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o relatório",
                    "Relatórios", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":

                    break;
                case "Centro":

                    break;
                case "Cidade":

                    break;
                case "Contato":

                    break;
                case "Especializacao":

                    break;
                case "Foto":

                    break;
                case "Uf":

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }
}
