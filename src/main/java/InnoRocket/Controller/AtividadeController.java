package InnoRocket.Controller;
import InnoRocket.DAO.AtividadeDAO;
import InnoRocket.DAO.UfDAO;
import InnoRocket.Model.Atividade;
import InnoRocket.Model.Uf;

import javax.swing.*;
import java.util.List;

public class AtividadeController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        String nome = getValidNome(null);
        String descricao = getValidDescricao(null);

        Atividade atividade = new Atividade(null, nome, descricao);

        AtividadeDAO.salvar(atividade);
    }

    public static void alterar() {
        Object[] selectionValues = AtividadeDAO.listaPorNome();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> atividades = AtividadeDAO.buscaPorNome((String) selection);
        String nome = JOptionPane.showInputDialog("Digite o novo nome da atividade: ", atividades.get(0).getNome());

        if(nome == null || nome=="") {
            JOptionPane.showMessageDialog(null, "Nome inválido!");
            alterar();
        }

        String descricao = JOptionPane.showInputDialog("Digite a nova descrição da atividade: ", atividades.get(0).getDescricao());
        if(descricao == null || descricao=="") {
            JOptionPane.showMessageDialog(null, "Descrição inválida!");
            alterar();
        }
        Atividade atividadeAlterar = new Atividade(atividades.get(0).getAtividadeId(), nome, descricao);
        AtividadeDAO.alterar(atividadeAlterar);
        JOptionPane.showMessageDialog(null, "Atividade alterada com sucesso!");
    }

    public static void excluir() {
        Object[] selectionValues = AtividadeDAO.listaPorNome();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> atividades = AtividadeDAO.buscaPorNome((String) selection);

        AtividadeDAO.excluir(atividades.get(0));
        System.out.println("Atividade excluída com sucesso!");

    }
}
