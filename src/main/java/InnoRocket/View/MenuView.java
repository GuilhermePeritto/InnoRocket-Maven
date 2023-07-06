package InnoRocket.View;

import InnoRocket.Controller.*;
import InnoRocket.DAO.*;
import InnoRocket.Form.*;

import javax.swing.*;

public class MenuView {

    public static void sincronizarBanco() {
        AtividadeDAO.listar();
        CentroDAO.listar();
        CidadeDAO.listar();
        ContatoDAO.listar();
        EspecioalizacaoDAO.listar();
        FotoDAO.listar();
        UfDAO.listar();
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
            int opcaoCancelar = JOptionPane.showOptionDialog(null, " Deseja realmente cancelar? ",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
            } else {
                listBoxCadastros();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu de cadastro." + e.getMessage());
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
        } catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null, " Deseja realmente cancelar? ",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
            } else {
                listBoxProcessos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu de cadastro." + e.getMessage());
        }

    }

    public static void listBoxRelatorios() {
        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especializacao", "Uf", "Personalizado", "Personalizado-Centro"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o relatório",
                    "Relatórios", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":
                    RelatorioAtividadeForm.emitirRelatorio(AtividadeDAO.listar());
                    break;
                case "Centro":
                    RelatorioCentroForm.emitirRelatorio(CentroDAO.listar());
                    break;
                case "Cidade":
                    RelatorioCidadeForm.emitirRelatorio(CidadeDAO.listar());
                    break;
                case "Contato":
                    RelatorioContatoForm.emitirRelatorio(ContatoDAO.listar());
                    break;
                case "Especializacao":
                    RelatorioEspecializacaoForm.emitirRelatorio(EspecioalizacaoDAO.listar());
                    break;
                case "Uf":
                    RelatorioUfForm.emitirRelatorio(UfDAO.listar());
                    break;
                case "Personalizado":
                    RelatorioPersonalizadoForm.emitirRelatorio();
                    break;
                case "Personalizado-Centro":
                    RelatorioPersonalizadoDoisForm.emitirRelatorio();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu de cadastro." + e.getMessage());
        }
    }

    public static void menuAlterar() {
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
            int opcaoCancelar = JOptionPane.showOptionDialog(null, " Deseja realmente cancelar? ",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
                listBoxProcessos();
            } else {
                menuAlterar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu de processos." + e.getMessage());
        }
    }

    public static void menuExcluir() {
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
            int opcaoCancelar = JOptionPane.showOptionDialog(null, "Deseja realmente cancelar-----?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
                listBoxProcessos();
            } else {
                menuExcluir();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao chamar o menu de exclusão." + e.getMessage());
        }
    }
}
