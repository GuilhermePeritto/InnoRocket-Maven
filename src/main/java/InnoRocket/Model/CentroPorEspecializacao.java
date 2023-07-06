package InnoRocket.Model;

public class CentroPorEspecializacao {
    public String especializacao;
    public int quantidadeCentro;

    public CentroPorEspecializacao(String especializacao, int quantidadeCentro) {
        this.especializacao = especializacao;
        this.quantidadeCentro = quantidadeCentro;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public int getQuantidadeCentro() {
        return quantidadeCentro;
    }

    public void setQuantidadeCentro(int quantidadeCentro) {
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
