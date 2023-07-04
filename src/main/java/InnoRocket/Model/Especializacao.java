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
    public String descricao;

    public Especializacao(Integer especializacaoId, String descricao) {
        EspecializacaoId = especializacaoId;
        this.descricao = descricao;
    }

    public Integer getEspecializacaoId() {
        return EspecializacaoId;
    }

    public void setEspecializacaoId(Integer especializacaoId) {
        EspecializacaoId = especializacaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Especializacao{" +
                "EspecializacaoId=" + EspecializacaoId +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
