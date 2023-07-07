package InnoRocket.Model;

public class CentroPorEspecializacao {
    public String especializacao;
    public String quantidadeCentro;

    public CentroPorEspecializacao(String especializacao, String quantidadeCentro) {
        this.especializacao = especializacao;
        this.quantidadeCentro = quantidadeCentro;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getQuantidadeCentro() {
        return quantidadeCentro;
    }

    public void setQuantidadeCentro(String quantidadeCentro) {
        this.quantidadeCentro = quantidadeCentro;
    }

    @Override
    public String toString() {
        return "CentroPorEspecializacao{" +
                "especializacao='" + especializacao + '\'' +
                ", quantidadeCentro=" + quantidadeCentro +
                '}';
    }
}
