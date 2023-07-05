package InnoRocket.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer ContatoId;
    public String nome;
    public String telefone;
    public String email;
    @OneToOne
    @JoinColumn(name = "CentroId")
    public Centro centro;

    public Contato(Integer contatoId, String nome, String telefone, String email, Centro centro) {
        ContatoId = contatoId;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.centro = centro;
    }

    public Contato() {

    }

    public Integer getContatoId() {
        return ContatoId;
    }

    public void setContatoId(Integer contatoId) {
        ContatoId = contatoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "ContatoId=" + ContatoId +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", centro=" + centro +
                '}';
    }
}
