package Controller;

import Repository.UfDAO;

import javax.swing.*;

import static View.MenuView.chamaMenuPrincipal;

public class UfController {
    public static void cadastroUf() throws ClassNotFoundException {
        String sigla = JOptionPane.showInputDialog("Digite a sigla da uf: ");
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            cadastroUf();
        }
        String nome = JOptionPane.showInputDialog("Digite o nome da uf: ");
        UfDAO.salvar(sigla, nome);
        chamaMenuPrincipal();
    }
}
