package InnoRocket.Model;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer atividadeId;
    @NotNull
    @Column( nullable = false )
    public String nome;
    @NotNull
    @Column( nullable = false )
    public String descricao;

    public Atividade(Integer atividadeId, String nome, String descricao) {
        this.atividadeId = atividadeId;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Atividade() {

    }

    public Integer getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Integer atividadeId) {
        this.atividadeId = atividadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "atividadeId=" + atividadeId +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
