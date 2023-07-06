package InnoRocket.Controller;

import InnoRocket.DAO.FotoDAO;
import InnoRocket.Model.Foto;
import javax.swing.*;
import java.util.List;

public class FotoController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        String url = JOptionPane.showInputDialog("Digite a url da foto: ");
        Foto foto = new Foto(null, url);
        FotoDAO.salvar(foto);
    }

    public static void alterar() {
        Object[] selectionValues = FotoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Foto!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Foto> foto = FotoDAO.buscaPorNome((String) selection);


        String url = JOptionPane.showInputDialog("Digite a url da foto: ", foto.get(0).getNome());

        Foto fotoAlterar = new Foto(foto.get(0).getFotoId(), url);
        FotoDAO.alterar(fotoAlterar);
    }

    public static void excluir() {
        Object[] selectionValues = FotoDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Foto!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Foto> foto = FotoDAO.buscaPorNome((String) selection);
        FotoDAO.excluir(foto.get(0));
    }
}
