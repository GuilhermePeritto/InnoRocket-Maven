package InnoRocket.Model;

public class CentroPorCidade {
    public String cidade;
    public int quantidadeCentro;

    public CentroPorCidade(String cidade, int quantidadeCentro) {
        this.cidade = cidade;
        this.quantidadeCentro = quantidadeCentro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getQuantidadeCentro() {
        return quantidadeCentro;
    }

    public void setQuantidadeCentro(int quantidadeCentro) {
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
