package InnoRocket.Form;

import InnoRocket.Model.Especializacao;
import InnoRocket.Model.Uf;
import InnoRocket.Relatorio.TableEspecializacao;
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

public class RelatorioEspecializacaoForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Id", "Nome", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableEspecializacao tabela;

    public RelatorioEspecializacaoForm(Vector<Especializacao> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<Especializacao> vetorDados){
        tabela = new TableEspecializacao(nomeColunas, vetorDados);
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

    public static void emitirRelatorio(List<Especializacao> especializacaos){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Especialização");

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
            Vector<Especializacao> vetorDados = new Vector<Especializacao>();
            for (Especializacao especializacao : especializacaos) {
                vetorDados.add(especializacao);
            }

            frame.getContentPane().add(new RelatorioEspecializacaoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




