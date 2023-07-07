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

    public static void ValidarCampoVazio(String campo) throws Exception {
        if(campo == null || campo.equals("")) throw new Exception("Campo inválido!");
    }

    public static void alterar() {
        try {
            Object[] selectionValues = AtividadeDAO.listaPorNome();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                    "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            if(selection== null) return;
            List<Atividade> atividades = AtividadeDAO.buscaPorNome((String) selection);
            String nome = JOptionPane.showInputDialog("Digite o novo nome da atividade: ", atividades.get(0).getNome());
            ValidarCampoVazio(nome);
            String descricao = JOptionPane.showInputDialog("Digite a nova descrição da atividade: ", atividades.get(0).getDescricao());
            ValidarCampoVazio(descricao);
            Atividade atividadeAlterar = new Atividade(atividades.get(0).getAtividadeId(), nome, descricao);
            AtividadeDAO.alterar(atividadeAlterar);
            JOptionPane.showMessageDialog(null, "Atividade alterada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            alterar();
        }
    }

    public static void excluir() {
        Object[] selectionValues = AtividadeDAO.listaPorNome();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> atividades = AtividadeDAO.buscaPorNome((String) selection);

        AtividadeDAO.excluir(atividades.get(0));
        JOptionPane.showMessageDialog(null, "Atividade excluída com sucesso!");

    }
}
