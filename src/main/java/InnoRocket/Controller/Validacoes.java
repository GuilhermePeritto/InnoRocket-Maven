package InnoRocket.Controller;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Validacoes {

    public static String getValidTelefone(String telefone) {
        do {
            telefone = JOptionPane.showInputDialog("Digite o telefone do Contato: ");
            if (telefone == null) {
                return null;
            }
            if (telefone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O telefone não pode ser vazio. Por favor, digite um telefone válido.");
            } else if (!containsOnlyNumbers(telefone)) {
                JOptionPane.showMessageDialog(null, "O telefone deve conter apenas números. Por favor, digite um telefone válido.");
            }
        } while (telefone.isEmpty() || !containsOnlyNumbers(telefone));
        return telefone;
    }

    public static boolean containsSpecialCharacters(String text) {
        Pattern specialChars = Pattern.compile("[^a-zA-Z0-9]");
        return specialChars.matcher(text).find();
    }

    public static boolean containsOnlyNumbers(String text) {
        return text.matches("[0-9]+");
        // o zé vi que essse !telefone.matches("\\d+")); significa que estamos procurando um ou mais dígitos
        // vi isso no chatGPT não tenho vergonha não minto tbm sou filho de deus KKKKKKK
    }

    public static void ValidarCampoVazio(String campo) throws Exception {
        if(campo == null || campo.equals("")) throw new Exception("Campo inválido!");
    }
}
