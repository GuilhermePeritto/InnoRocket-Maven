package InnoRocket.View;

import InnoRocket.Controller.UfController;
import javax.swing.*;
import static InnoRocket.Controller.UfController.cadastroUf;

public class MenuView {
    public static void chamaMenuPrincipal(){
        try {
            String[] opcoesMenu = {"Cadastros", "Processos", "Relatorios", "Sair"};
            int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção: ",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenu, opcoesMenu[0]);
            switch (opcao) {
                case 0: //Cadastros
                    listBoxCadastros();
                    break;
                case 1: //Processos
                    listBoxProcessos();
                    break;
                case 2: //Relatorios
                    listBoxRelatorios();
                    break;
                case 3: //Sair
                    int opcaoSair = JOptionPane.showOptionDialog(null," Deseja realmente sair ? ",
                            "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);

                    if (opcaoSair == JOptionPane.YES_NO_OPTION){
                        System.exit(0);
                    }else {
                        chamaMenuPrincipal();
                    }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu principal." + e.getMessage());
        }
    }
    public static void listBoxCadastros() {
        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especializacao", "Foto", "Uf"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de cadastro",
                    "Cadastro", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":
//                    cadastroAtividade();
                    break;
                case "Centro":

                    break;
                case "Cidade":
//                    cadastroCidade();
                    break;
                case "Contato":
//                    cadastroContato();
                    break;
                case "Especializacao":
//                    cadastroEspecializacao();
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
        Object[] selectionValues = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        switch ((String) selection) {
            case "Alterar Dados":
                menuAlterar();
                break;
            case "Excluir Cadastro":
                menuExcluir();
                break;
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

    public static void menuAlterar(){
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
                    UfController.alterarUf();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
        } catch (Exception e) {
            chamaMenuPrincipal();
        }
    }
    public static void menuExcluir(){
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
                    UfController.excluirUf();
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
