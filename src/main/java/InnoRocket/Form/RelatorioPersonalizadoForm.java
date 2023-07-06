package InnoRocket.Form;

import InnoRocket.Relatorio.TablePersonalizado;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import static InnoRocket.View.MenuView.listBoxRelatorios;

public class RelatorioPersonalizadoForm extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Cidade", "Quantidade de Centros", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TablePersonalizado tabela;

    public RelatorioPersonalizadoForm(Vector<String[]> vetorDados) {
        iniciarVetorComponentes(vetorDados);
    }

    public void iniciarVetorComponentes(Vector<String[]> vetorDados) {
        tabela = new TablePersonalizado(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static Vector<String[]> executarConsulta() {
        Vector<String[]> vetorDados = new Vector<>();

        try (Connection connection = DriverManager.getConnection("jdbc:seu_banco_de_dados")) {
            String sql = "SELECT cid.cidade AS Cidade, COUNT(cid.CidadeId) AS QuantidadeCentro " +
                    "FROM cidade cid " +
                    "JOIN centro c ON c.CidadeId = cid.CidadeId " +
                    "GROUP BY cid.cidade";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String cidade = resultSet.getString("Cidade");
                String quantidadeCentro = resultSet.getString("QuantidadeCentro");
                vetorDados.add(new String[]{cidade, quantidadeCentro});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vetorDados;
    }

    public static void emitirRelatorio() {
        try {
            Vector<String[]> vetorDados = executarConsulta();
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio - Cidade");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    listBoxRelatorios();
                }
            });

            frame.getContentPane().add(new RelatorioPersonalizadoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}