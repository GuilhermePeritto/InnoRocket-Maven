package InnoRocket.Controller;

import InnoRocket.DAO.AtividadeDAO;
import InnoRocket.Model.Atividade;

import javax.swing.*;
import java.util.List;

import static InnoRocket.View.MenuView.chamaMenuPrincipal;

public class AtividadeController {
    public static void cadastro() throws ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Digite o nome da atividade: ");
        String descricao = JOptionPane.showInputDialog("Digite a descrição da atividade: ");

        Atividade atividadeCadastrar = new Atividade();
        atividadeCadastrar.setNome(nome);
        atividadeCadastrar.setDescricao(descricao);

        AtividadeDAO.salvar(atividadeCadastrar);
        System.out.println("Atividade cadastrada com sucesso!");

        chamaMenuPrincipal();
    }

    public static void alterar() {
        Object[] selectionValues = AtividadeDAO.listarPorNome();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> atividades = AtividadeDAO.buscaPorNome((String) selection);

        String nome = JOptionPane.showInputDialog("Digite o nome da atividade: ", atividades.get(0).getNome());
        String descricao = JOptionPane.showInputDialog("Digite a descrição da atividade: ", atividades.get(0).getDescricao());

        Atividade atividadeAlterar = new Atividade();
        atividadeAlterar.setAtividadeId(atividades.get(0).getAtividadeId());
        atividadeAlterar.setNome(nome);
        atividadeAlterar.setDescricao(descricao);

        AtividadeDAO.alterar(atividadeAlterar);
        System.out.println("Atividade alterada com sucesso!");

        chamaMenuPrincipal();
    }

    public static void excluir() {
        Object[] selectionValues = AtividadeDAO.listarPorNome();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> atividades = AtividadeDAO.buscaPorNome((String) selection);

        AtividadeDAO.excluir(atividades.get(0));
        System.out.println("Atividade excluída com sucesso!");

        chamaMenuPrincipal();
    }
}
