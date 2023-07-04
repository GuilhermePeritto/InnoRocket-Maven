package InnoRocket.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Especializacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer EspecializacaoId;
    public String nome;

    public Especializacao(Integer especializacaoId, String nome) {
        EspecializacaoId = especializacaoId;
        this.nome = nome;
    }

    public Integer getEspecializacaoId() {
        return EspecializacaoId;
    }

    public void setEspecializacaoId(Integer especializacaoId) {
        EspecializacaoId = especializacaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Especializacao{" +
                "EspecializacaoId=" + EspecializacaoId +
                ", descricao='" + nome + '\'' +
                '}';
    }
}
