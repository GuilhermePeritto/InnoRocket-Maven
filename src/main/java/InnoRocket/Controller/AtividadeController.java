package InnoRocket.Controller;

import InnoRocket.DAO.AtividadeDAO;
import InnoRocket.Model.Atividade;
import javax.swing.*;
import java.util.List;

public class AtividadeController {
    public static void cadastrar() throws ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Digite o nome da atividade: ");
        String descricao = JOptionPane.showInputDialog("Digite a descrição da atividade: ");

        Atividade atividade = new Atividade(null, nome, descricao);

        AtividadeDAO.salvar(atividade);
        System.out.println("Atividade cadastrada com sucesso!");
    }

    public static void alterar() {
        Object[] selectionValues = AtividadeDAO.listaPorNome();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> atividades = AtividadeDAO.buscaPorNome((String) selection);
        String nome = JOptionPane.showInputDialog("Digite o nome da atividade: ", atividades.get(0).getNome());
        String descricao = JOptionPane.showInputDialog("Digite a descrição da atividade: ", atividades.get(0).getDescricao());
        Atividade atividadeAlterar = new Atividade(atividades.get(0).getAtividadeId(), nome, descricao);
        AtividadeDAO.alterar(atividadeAlterar);
        System.out.println("Atividade alterada com sucesso!");
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
