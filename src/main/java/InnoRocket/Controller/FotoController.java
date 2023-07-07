package InnoRocket.Controller;

import InnoRocket.DAO.FotoDAO;
import InnoRocket.Model.Foto;
import javax.swing.*;
import java.util.List;

public class FotoController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        try {
        String url = JOptionPane.showInputDialog("Digite a url da foto: ");
        ValidarCampoVazio(url);
        Foto foto = new Foto(null, url);
        FotoDAO.salvar(foto);
        JOptionPane.showMessageDialog(null, "Foto cadastrada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void alterar() {
        try {
        Object[] selectionValues = FotoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Foto!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Foto> foto = FotoDAO.buscaPorNome((String) selection);
        String url = JOptionPane.showInputDialog("Digite a url da foto: ", foto.get(0).getNome());
        ValidarCampoVazio(url);
        Foto fotoAlterar = new Foto(foto.get(0).getFotoId(), url);
        FotoDAO.alterar(fotoAlterar);
        JOptionPane.showMessageDialog(null, "Foto alterada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void excluir() {
        Object[] selectionValues = FotoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Foto!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Foto> foto = FotoDAO.buscaPorNome((String) selection);
        FotoDAO.excluir(foto.get(0));
        JOptionPane.showMessageDialog(null, "Foto excluida com sucesso!");
    }
}
