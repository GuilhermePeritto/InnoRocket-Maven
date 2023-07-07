package InnoRocket.Form;
import InnoRocket.Model.CentroPorEspecializacao;
import InnoRocket.Relatorio.TableCentroPorEspecializacao;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Vector;

import static InnoRocket.View.MenuView.listBoxRelatorios;

public class RelatorioCentroPorEspecializacaoForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Especialização", "Quantidade Centro", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableCentroPorEspecializacao tabela;

    public RelatorioCentroPorEspecializacaoForm(Vector<CentroPorEspecializacao> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<CentroPorEspecializacao> vetorDados){
        tabela = new TableCentroPorEspecializacao(nomeColunas, vetorDados);
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

    public static void emitirRelatorio(List<CentroPorEspecializacao> centroPorEspecializacaos){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Centro por Especialização");

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
            Vector<CentroPorEspecializacao> vetorDados = new Vector<CentroPorEspecializacao>();
            for (CentroPorEspecializacao centroPorEspecializacao : centroPorEspecializacaos) {
                vetorDados.add(centroPorEspecializacao);
            }

            frame.getContentPane().add(new RelatorioCentroPorEspecializacaoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




