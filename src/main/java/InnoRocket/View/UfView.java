package InnoRocket.View;

import InnoRocket.Controller.UfController;

import javax.swing.*;

public class UfView {
    public static void processoUf() {
        Object[] selectionValues = {"Alterar Dados", "Excluir Cadastro"};
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o processo!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        switch ((String) selection) {
            case "Alterar Dados":
                UfController.alterarUf();
                break;
            case "Excluir Cadastro":
                UfController.excluirUf();
                break;
        }
    }
}
