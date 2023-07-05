package InnoRocket.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer cidadeId;
    public String nome;
    public Uf uf;

    public Cidade(Integer cidadeId, String nome, Uf uf) {
        this.cidadeId = cidadeId;
        this.nome = nome;
        this.uf = uf;
    }

    public Cidade() {

    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "cidadeId=" + cidadeId +
                ", cidade='" + nome + '\'' +
                ", uf=" + uf +
                '}';
    }

}
