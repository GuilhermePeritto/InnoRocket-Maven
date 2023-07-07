package InnoRocket.Controller;
import InnoRocket.DAO.*;
import InnoRocket.Model.Uf;
import javax.swing.*;
import java.util.List;
import static InnoRocket.View.MenuView.menuExcluir;

public class UfController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        String sigla = JOptionPane.showInputDialog("Digite a sigla da uf: ");
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            cadastrar();
        }
        String nome = getValidNome(null);
        Uf ufCadastrar = new Uf(null,sigla, nome);
        UfDAO.salvar(ufCadastrar);
        JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso!");
    }

    public static void alterar() {
        Object[] selectionValues = UfDAO.listarPorSigla();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a UF",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Uf> uf = UfDAO.buscaPorSigla((String) selection);

        String sigla = JOptionPane.showInputDialog("Digite a sigla da UF: ", uf.get(0).getSigla());
        if (sigla.length() > 2){
            JOptionPane.showMessageDialog(null, "A sigla deve conter apenas 2 caracteres.");
            alterar();
        }
        String nome = getValidNome(null);
        Uf ufAlterar = new Uf(uf.get(0).getUfId(),sigla, nome);
        UfDAO.alterar(ufAlterar);
        JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
    }

    public static void excluir() {
        try {
            Object[] selectionValues = UfDAO.listarPorSigla();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione a UF",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            List<Uf> uf = UfDAO.buscaPorSigla((String) selection);
            int opcaoExcluir = JOptionPane.showOptionDialog(null, "Deseja realmente excluir o registro?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoExcluir == JOptionPane.YES_NO_OPTION) {
                UfDAO.excluir(uf.get(0));
            } else {
                excluir();
            }
        } catch (NullPointerException e) {
            int opcaoCancelar = JOptionPane.showOptionDialog(null, "Deseja realmente cancelar?",
                    "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (opcaoCancelar == JOptionPane.YES_NO_OPTION) {
                menuExcluir();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o registro!");
        }
        JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
    }
}