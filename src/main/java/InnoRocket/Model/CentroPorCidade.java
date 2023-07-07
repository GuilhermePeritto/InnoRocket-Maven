package InnoRocket.Model;

public class CentroPorCidade {
    public String cidade;
    public Integer quantidadeCentro;

    public CentroPorCidade(String cidade, Integer quantidadeCentro) {
        this.cidade = cidade;
        this.quantidadeCentro = quantidadeCentro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getQuantidadeCentro() {
        return quantidadeCentro;
    }

    public void setQuantidadeCentro(Integer quantidadeCentro) {
        this.quantidadeCentro = quantidadeCentro;
    }

    @Override
    public String toString() {
        return "CentroPorCidade{" +
                "cidade='" + cidade + '\'' +
                ", quantidadeCentro=" + quantidadeCentro +
                '}';
    }
}
