package InnoRocket.Controller;

import InnoRocket.DAO.*;
import InnoRocket.Model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CentroController extends Validacoes{
    public static void cadastrar() throws ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Digite o nome do Centro: ");
        String rua = JOptionPane.showInputDialog("Digite o nome da rua: ");
        String cep = JOptionPane.showInputDialog("Digite o CEP: ");
        String numero = JOptionPane.showInputDialog("Digite o número: ");
        String bairro = JOptionPane.showInputDialog("Digite o bairro: ");
        String complemento = JOptionPane.showInputDialog("Digite o complemento: ");
        Object[] selectionValues = CidadeDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Cidade!",
                "Listar Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
        Object[] selectionValues1 = {"ATIVO", "INATIVO"};
        String initialSelection1 = "ATIVO";
        Object selection1 = JOptionPane.showInputDialog(null, "Selecione o status do centro!",
                "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionValues1, initialSelection1);
        EnumStatusCentro statusCentro = EnumStatusCentro.ATIVO;
        if (selection1.equals("ATIVO")) {
            statusCentro = EnumStatusCentro.ATIVO;
        } else if (selection1.equals("INATIVO")) {
            statusCentro = EnumStatusCentro.INATIVO;
        }
        String redesSociais = JOptionPane.showInputDialog("Digite as redes sociais: ");
        Object[] selectionValues5 = FotoDAO.listaPorNomes();
        String initialSelection5 = (String) selectionValues5[0];
        Object selection5 = JOptionPane.showInputDialog(null, "Selecione a foto!",
                "Listar Fotos", JOptionPane.QUESTION_MESSAGE, null, selectionValues5, initialSelection5);
        List<Foto> fotos = FotoDAO.buscaPorNome((String) selection5);
        LocalDate dataCadastro = LocalDate.now();
        LocalDate dataCriacao = LocalDate.now();
        String imputDataCriacao = JOptionPane.showInputDialog(null, "Informe a de criação:");
        try {
            dataCriacao = LocalDate.parse(imputDataCriacao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        Object[] selectionValues2 = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection2 = (String) selectionValues[0];
        Object selection2 = JOptionPane.showInputDialog(null, "Selecione a especializacao!",
                "Listar Especializações", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacaos = EspecioalizacaoDAO.buscaPorNome((String) selection);
        Object[] selectionValues3 = ContatoDAO.listaPorNomes();
        String initialSelection3 = (String) selectionValues[0];
        Object selection3 = JOptionPane.showInputDialog(null, "Selecione o contato!",
                "Listar Contatos", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);
        Object[] selectionValues4 = AtividadeDAO.listaPorNome();
        String initialSelection4 = (String) selectionValues[0];
        Object selection4 = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Listar Atividades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> ativiadade = AtividadeDAO.buscaPorNome((String) selection);
        Centro centro = new Centro(null, nome, rua, cep, numero, bairro, complemento, cidade.get(0), statusCentro, redesSociais, fotos.get(0), dataCadastro, dataCriacao, especializacaos, contato.get(0), ativiadade);
        CentroDAO.salvar(centro);
        System.out.println("Centro cadastrada com sucesso!");
    }

    public static void alterar() {
        Object[] selectionValues5 = CentroDAO.listaPorNomes();
        String initialSelection5 = (String) selectionValues5[0];
        Object selection5 = JOptionPane.showInputDialog(null, "Selecione o centro que deseja alterar!",
                "Lista Centro", JOptionPane.QUESTION_MESSAGE, null, selectionValues5, initialSelection5);
        List<Centro> centro = CentroDAO.buscaPorNome((String) selection5);

        String nome = JOptionPane.showInputDialog("Digite o nome do Centro: ", centro.get(0).getNome());
        String rua = JOptionPane.showInputDialog("Digite o nome da rua: ", centro.get(0).getRua());
        String cep = JOptionPane.showInputDialog("Digite o CEP: ", centro.get(0).getCep());
        String numero = JOptionPane.showInputDialog("Digite o número: ", centro.get(0).getNumero());
        String bairro = JOptionPane.showInputDialog("Digite o bairro: ", centro.get(0).getBairro());
        String complemento = JOptionPane.showInputDialog("Digite o complemento: ", centro.get(0).getComplemento());
        Object[] selectionValues = CidadeDAO.listaPorNomes();
        String initialSelection = (String) centro.get(0).getCidade().getNome();
        Object selection = JOptionPane.showInputDialog(null, "Selecione a Cidade!",
                "Listar Cidades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Cidade> cidade = CidadeDAO.buscaPorNome((String) selection);
        Object[] selectionValues1 = {"ATIVO", "INATIVO"};
        String initialSelection1 = centro.get(0).getStatus().toString();
        Object selection1 = JOptionPane.showInputDialog(null, "Selecione o status do centro!",
                "Lista de Status", JOptionPane.QUESTION_MESSAGE, null, selectionValues1, initialSelection1);
        EnumStatusCentro statusCentro = EnumStatusCentro.ATIVO;
        if (selection1.equals("ATIVO")) {
            statusCentro = EnumStatusCentro.ATIVO;
        } else if (selection1.equals("INATIVO")) {
            statusCentro = EnumStatusCentro.INATIVO;
        }
        String redesSociais = JOptionPane.showInputDialog("Digite a rede social: ", centro.get(0).getRedesSociais());
        Object[] selectionValues6 = FotoDAO.listaPorNomes();
        String initialSelection6 = (String) selectionValues6[0];
        Object selection6 = JOptionPane.showInputDialog(null, "Selecione a foto!",
                "Listar Fotos", JOptionPane.QUESTION_MESSAGE, null, selectionValues6, initialSelection6);
        List<Foto> foto = FotoDAO.buscaPorNome((String) selection6);
        LocalDate dataCadastro = LocalDate.now();
        LocalDate dataCriacao = LocalDate.now();
        String imputDataCriacao = JOptionPane.showInputDialog(null, "Informe a de criação:", centro.get(0).getDataCriacao().toString());
        try {
            dataCriacao = LocalDate.parse(imputDataCriacao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida, tente no formato dd/MM/yyyy");
        }
        Object[] selectionValues2 = EspecioalizacaoDAO.listaPorNomes();
        String initialSelection2 = (String) centro.get(0).getEspecializacao().get(0).getNome();
        Object selection2 = JOptionPane.showInputDialog(null, "Selecione a especializacao!",
                "Listar Especializações", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Especializacao> especializacaos = EspecioalizacaoDAO.buscaPorNome((String) selection);
        Object[] selectionValues3 = ContatoDAO.listaPorNomes();
        String initialSelection3 = (String) centro.get(0).getContato().getNome();
        Object selection3 = JOptionPane.showInputDialog(null, "Selecione o contato!",
                "Listar Contatos", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Contato> contato = ContatoDAO.buscaPorNome((String) selection);
        Object[] selectionValues4 = AtividadeDAO.listaPorNome();
        String initialSelection4 = (String) centro.get(0).getAtividade().get(0).getNome();
        Object selection4 = JOptionPane.showInputDialog(null, "Selecione a atividade!",
                "Listar Atividades", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Atividade> ativiadade = AtividadeDAO.buscaPorNome((String) selection);
        Centro centroAlterar = new Centro(null, nome, rua, cep, numero, bairro, complemento, cidade.get(0), statusCentro, redesSociais, foto.get(0), dataCadastro, dataCriacao, especializacaos, contato.get(0), ativiadade);
        CentroDAO.alterar(centroAlterar);
        System.out.println("Centro alterada com sucesso!");
    }

    public static void excluir() {
        Object[] selectionValues = CentroDAO.listaPorNomes();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o centro!",
                "Processo", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        List<Centro> centros = CentroDAO.buscaPorNome((String) selection);

        CentroDAO.excluir(centros.get(0));
        System.out.println("Centro excluída com sucesso!");
    }
}
