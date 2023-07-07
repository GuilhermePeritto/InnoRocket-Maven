package InnoRocket.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;

import static InnoRocket.View.MenuView.*;

public class MenuFrame extends JFrame {

    public MenuFrame() {
        setTitle("InnoRocket");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 600);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src\\main\\java\\InnoRocket\\Imagens\\icon.png").getImage());



        // Criando o painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        JPanel menuPanel = new JPanel();
        mainPanel.add(menuPanel, BorderLayout.WEST);
        ImageIcon gifIcon = new ImageIcon("src\\main\\java\\InnoRocket\\Imagens\\background.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        mainPanel.add(gifLabel);
        JPanel sideMenuPanel = new JPanel();
        sideMenuPanel.setBackground(Color.BLACK);
        sideMenuPanel.setPreferredSize(new Dimension(60, 30));
        sideMenuPanel.setLayout(new GridLayout(4, 1, 0, 10));
        mainPanel.add(sideMenuPanel, BorderLayout.WEST);

        // Adicionando ícones ao menu lateral
        JButton cadastrarButton = createMenuButton("", "src\\main\\java\\InnoRocket\\Imagens\\cadastrar.png");
        JButton editarButton = createMenuButton("", "src\\main\\java\\InnoRocket\\Imagens\\editar.png");
        JButton relatorioButton = createMenuButton("", "src\\main\\java\\InnoRocket\\Imagens\\relatorio.png");
        JButton sairButton = createMenuButton("", "src\\main\\java\\InnoRocket\\Imagens\\sair.png");

        sideMenuPanel.add(cadastrarButton);
        sideMenuPanel.add(editarButton);
        sideMenuPanel.add(relatorioButton);
        sideMenuPanel.add(sairButton);

        // Eventos dos botões do menu
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listBoxCadastros();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listBoxProcessos();
                } catch (SQLIntegrityConstraintViolationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        relatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listBoxRelatorios();
                } catch (SQLIntegrityConstraintViolationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private JButton createMenuButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);

        ImageIcon icon = new ImageIcon(iconPath);
        Image scaledIcon = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(scaledIcon));

        return button;
    }
}