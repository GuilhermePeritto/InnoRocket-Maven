package InnoRocket.Form;

public class RelatorioAtividadeForm {

import static InnoRocket.View.MenuView.listBoxRelatorios;

    public class RelatorioCidadeForm extends JPanel {

        private static final long serialVersionUID = 1L;

        public static final String[] nomeColunas =
                {"Id", "Nome", "UF", ""};

        protected JTable table;
        protected JScrollPane scroller;
        protected TableCidade tabela;

        public RelatorioCidadeForm(Vector<Cidade> vetorDados) {
            iniciarVetorComponentes(vetorDados);
        }

        public void iniciarVetorComponentes(Vector<Cidade> vetorDados){
            tabela = new TableCidade(nomeColunas, vetorDados);
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

        public static void emitirRelatorio(List<Cidade> contatos){
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                JFrame frame = new JFrame("Relatorio - Contato");

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent evt) {
                        frame.setVisible(false);
                        listBoxRelatorios();
                    }
                });
                Vector<Cidade> vetorDados = new Vector<Cidade>();
                for (Cidade cidade : contatos) {
                    vetorDados.add(cidade);
                }

                frame.getContentPane().add(new RelatorioCidadeForm(vetorDados));
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
