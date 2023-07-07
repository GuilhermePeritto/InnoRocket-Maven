package InnoRocket.Form;
import InnoRocket.Model.Atividade;
import InnoRocket.Relatorio.TableAtividade;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Vector;

import static InnoRocket.View.MenuView.listBoxRelatorios;
import static com.sun.javafx.fxml.expression.Expression.add;

public class RelatorioAtividadeForm extends JPanel{
    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Id", "Nome", "Descrição", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableAtividade tabela;

    public RelatorioAtividadeForm(Vector<Atividade> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<Atividade> vetorDados){
        tabela = new TableAtividade(nomeColunas, vetorDados);
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

    public static void emitirRelatorio(List<Atividade> atividades) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Contato");

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
            Vector<Atividade> vetorDados = new Vector<Atividade>();
            for (Atividade atividade : atividades) {
                vetorDados.add(atividade);
            }

            frame.getContentPane().add(new RelatorioAtividadeForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
