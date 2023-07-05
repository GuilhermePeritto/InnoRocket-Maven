package InnoRocket;

import InnoRocket.View.MenuFrame;
import InnoRocket.View.MenuView;

import javax.swing.*;

public class Main extends MenuView {
    public static void main(String[] args) {
        sincronizarBanco();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame().setVisible(true);
            }
        });
    }
}