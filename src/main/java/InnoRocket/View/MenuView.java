package InnoRocket.View;

import InnoRocket.Controller.*;
import InnoRocket.DAO.*;
import InnoRocket.Form.*;

import javax.swing.*;
import java.sql.SQLIntegrityConstraintViolationException;

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
    public static void listBoxCadastros() throws Exception {
//        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especialização", "Foto", "UF"};
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
                case "Especialização":
                    EspecializacaoController.cadastrar();
                    break;
                case "Foto":
                    FotoController.cadastrar();
                    break;
                case "UF":
                    UfController.cadastrar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxCadastros();
            }
    }

    public static void listBoxProcessos() throws SQLIntegrityConstraintViolationException {
//        try {
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

    public static void listBoxRelatorios() throws SQLIntegrityConstraintViolationException {
//        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especialização", "UF"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o relatório",
                    "Relatórios", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":
                    RelatorioAtividadeForm.emitirRelatorio(AtividadeDAO.listar());
                    break;
                case "Centro":
                    listBoxRelatorioCentro();
                    break;
                case "Cidade":
                    RelatorioCidadeForm.emitirRelatorio(CidadeDAO.listar());
                    break;
                case "Contato":
                    RelatorioContatoForm.emitirRelatorio(ContatoDAO.listar());
                    break;
                case "Especialização":
                    RelatorioEspecializacaoForm.emitirRelatorio(EspecioalizacaoDAO.listar());
                    break;
                case "UF":
                    RelatorioUfForm.emitirRelatorio(UfDAO.listar());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
    }

    public static void menuAlterar() throws SQLIntegrityConstraintViolationException {
//        try {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especialização", "Foto", "UF"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":
                    AtividadeController.alterar();
                    break;
                case "Centro":
                    CentroController.alterar();
                    break;
                case "Cidade":
                    CidadeController.alterar();
                    break;
                case "Contato":
                    ContatoController.alterar();
                    break;
                case "Especialização":
                    EspecializacaoController.alterar();
                    break;
                case "Foto":
                    FotoController.alterar();
                    break;
                case "UF":
                    UfController.alterar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
    }

    public static void menuExcluir() throws SQLIntegrityConstraintViolationException {
            Object[] selectionValues = {"Atividade", "Centro", "Cidade", "Contato", "Especialização", "Foto", "UF"};
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o tipo de processo",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            switch ((String) selection) {
                case "Atividade":
                    AtividadeController.excluir();
                    break;
                case "Centro":
                    CentroController.excluir();
                    break;
                case "Cidade":
                    CidadeController.excluir();
                    break;
                case "Contato":
                    ContatoController.excluir();
                    break;
                case "Especialização":
                    EspecializacaoController.excluir();
                    break;
                case "Foto":
                    FotoController.excluir();
                    break;
                case "UF":
                    UfController.excluir();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                    listBoxProcessos();
            }
    }
    public static void listBoxRelatorioCentro() throws SQLIntegrityConstraintViolationException {
        String[] opcoesMenuProcesso = {"Centros", "Centro Por Especialização", "Centro Por Cidade", "Voltar"};
        int menu_processos = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Relatórios",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesMenuProcesso, opcoesMenuProcesso[0]);

        switch (menu_processos) {
            case 0:// "Centros":
                RelatorioCentroForm.emitirRelatorio(CentroDAO.listar());
                break;
            case 1:// "Centro Por Especialização":
                RelatorioCentroPorEspecializacaoForm.emitirRelatorio(CentroDAO.listarCentroPorEspecializacao());
                break;
            case 2: //"Centro Por Cidade":
                RelatorioCentroPorCidadeForm.emitirRelatorio(CentroDAO.listarCentroPorCidade());
                break;
            case 3: //"voltar":
                listBoxRelatorios();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma opção válida!");
                listBoxProcessos();
        }
    }
}
