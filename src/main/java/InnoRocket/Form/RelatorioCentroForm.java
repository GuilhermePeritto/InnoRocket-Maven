package InnoRocket.Form;



import InnoRocket.Model.Centro;
import InnoRocket.Relatorio.TableCentro;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import static InnoRocket.View.MenuView.listBoxRelatorios;

public class RelatorioCentroForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Id", "Nome", "Rua", "CEP", "Número", "Bairro", "Complemento", "Cidade", "Status", "Redes Sociais", "Foto", "Data de Cadastro", "Data de Criação", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableCentro tabela;

    public RelatorioCentroForm(Vector<Centro> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<Centro> vetorDados){
        tabela = new TableCentro(nomeColunas, vetorDados);
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

    public static void emitirRelatorio(List<Centro> centros){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Centro");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    listBoxRelatorios();
                }
            });
            Vector<Centro> vetorDados = new Vector<Centro>();
            for (Centro centro : centros) {
                vetorDados.add(centro);
            }

            frame.getContentPane().add(new RelatorioCentroForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
