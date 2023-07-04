package View;

import javax.swing.*;

import static Controller.MenuController.*;

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
}
