package InnoRocket.Form;

import InnoRocket.Model.Uf;
import InnoRocket.Relatorio.TableUf;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Vector;

import static InnoRocket.View.MenuView.listBoxRelatorios;

public class RelatorioUfForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Id", "Sigla", "Nome", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableUf tabela;

    public RelatorioUfForm(Vector<Uf> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<Uf> vetorDados){
        tabela = new TableUf(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(tabela.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorio(List<Uf> ufs){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - UF");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    try {
                        listBoxRelatorios();
                    } catch (SQLIntegrityConstraintViolationException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            Vector<Uf> vetorDados = new Vector<Uf>();
            for (Uf uf : ufs) {
                vetorDados.add(uf);
            }

            frame.getContentPane().add(new RelatorioUfForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




