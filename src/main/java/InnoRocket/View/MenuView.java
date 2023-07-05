package InnoRocket.View;

import InnoRocket.Controller.*;
import InnoRocket.DAO.*;
import InnoRocket.Form.RelatorioUfForm;

import javax.swing.*;

public class MenuView {

    public  static void sincronizarBanco(){
        AtividadeDAO.listar();
        CentroDAO.listar();
        CidadeDAO.listar();
        ContatoDAO.listar();
        EspecioalizacaoDAO.listar();
        FotoDAO.listar();
        UfDAO.listar();
    }
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
                    AtividadeController.cadastrar();
                    break;
                case "Centro":
                    CentroController.cadastrar();
                    break;
                case "Cidade":
                    CidadeController.cadastrar();
                    break;
                case "Contato":
                    ContatoController.cadastrar();
                    break;
                case "Especializacao":
                    EspecializacaoController.cadastrar();
                    break;
                case "Foto":
                    FotoController.cadastrar();
                    break;
                case "Uf":
                    UfController.cadastrar();
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
        }catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null," Deseja realmente cancelar? ",
                    "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION){
                chamaMenuPrincipal();
            }else {
                listBoxProcessos();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu de cadastro." + e.getMessage());
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
//
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
                    RelatorioUfForm.emitirRelatorio(UfDAO.listar());
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
                    AtividadeController.alterar();
                    break;
                case "Centro":
//                    CentroController.alterar();
                    break;
                case "Cidade":
                    CidadeController.alterar();
                    break;
                case "Contato":
                    ContatoController.alterar();
                    break;
                case "Especializacao":
                    EspecializacaoController.alterar();
                    break;
                case "Foto":
                    FotoController.alterar();
                    break;
                case "Uf":
                    UfController.alterar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }

        } catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null," Deseja realmente cancelar? ",
                    "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION){
                listBoxProcessos();
            }else {
                menuAlterar();
            }
        }

        catch (Exception e) {
            chamaMenuPrincipal();
        }
    }
    public static void menuExcluir(){
        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especializacao", "Foto", "UF"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":
                    AtividadeController.excluir();
                    break;
                case "Centro":

                    break;
                case "Cidade":
                    CidadeController.excluir();
                    break;
                case "Contato":
                    ContatoController.excluir();
                    break;
                case "Especializacao":
                    EspecializacaoController.excluir();
                    break;
                case "Foto":
                    FotoController.excluir();
                    break;
                case "UF":
                    UfController.excluir();
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
        } catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null,"Deseja realmente cancelar-----?",
                    "Confirmação",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION){
                listBoxProcessos();
            }else {
                menuExcluir();
            }
        }
        catch (Exception e) {
            chamaMenuPrincipal();
        }
    }
}
