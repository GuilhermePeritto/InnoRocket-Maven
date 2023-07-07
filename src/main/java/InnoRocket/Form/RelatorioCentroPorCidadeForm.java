package InnoRocket.Form;

import InnoRocket.Model.CentroPorCidade;
import InnoRocket.Relatorio.TableCentroPorCidade;
import InnoRocket.Relatorio.TableCentroPorEspecializacao;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import static InnoRocket.View.MenuView.listBoxRelatorios;

public class RelatorioCentroPorCidadeForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Cidade", "Quantidade Centro", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableCentroPorCidade tabela;

    public RelatorioCentroPorCidadeForm(Vector<CentroPorCidade> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<CentroPorCidade> vetorDados){
        tabela = new TableCentroPorCidade(nomeColunas, vetorDados);
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

    public static void emitirRelatorio(List<CentroPorCidade> centroPorCidades){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Centro por Cidade");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    listBoxRelatorios();
                }
            });
            Vector<CentroPorCidade> vetorDados = new Vector<CentroPorCidade>();
            for (CentroPorCidade centroPorCidade : centroPorCidades) {
                vetorDados.add(centroPorCidade);
            }

            frame.getContentPane().add(new RelatorioCentroPorCidadeForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




