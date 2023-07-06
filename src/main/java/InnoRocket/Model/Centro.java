package InnoRocket.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Centro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer CentroId;
    public String nome;
    public String rua;
    public String cep;
    public String numero;
    public String bairro;
    public String complemento;
    @ManyToOne
    @JoinColumn(name = "cidadeId", referencedColumnName = "cidadeId", nullable = false)
    public Cidade cidade;
    public EnumStatusCentro status;
    public String redesSociais;
    @OneToOne
    @JoinColumn(name = "fotoId", referencedColumnName = "fotoId", nullable = false)
    public Foto foto;
    public LocalDate dataCadastro;
    public LocalDate dataCriacao;

   @ManyToMany
    @JoinTable(name = "centroEspecializacao",
              joinColumns = @JoinColumn(name = "centroId"),
              inverseJoinColumns = @JoinColumn(name = "especializacaoId"))
    public List<Especializacao> especializacao;
    @OneToOne
    @JoinColumn(name = "contatoId", referencedColumnName = "contatoId", nullable = false)
    public Contato contato;
    @ManyToMany
    @JoinTable(name = "centroAtividade",
              joinColumns = @JoinColumn(name = "centroId"),
              inverseJoinColumns = @JoinColumn(name = "atividadeId"))
    public List<Atividade> atividade;
    public Centro(Integer centroId, String nome, String rua, String cep, String numero, String bairro, String complemento, Cidade cidade, EnumStatusCentro status, String redesSociais, Foto foto, LocalDate dataCadastro, LocalDate dataCriacao, List<Especializacao> especializacao, Contato contato, List<Atividade> atividade) {
        CentroId = centroId;
        this.nome = nome;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.status = status;
        this.redesSociais = redesSociais;
        this.foto = foto;
        this.dataCadastro = dataCadastro;
        this.dataCriacao = dataCriacao;
        this.especializacao = especializacao;
        this.contato = contato;
        this.atividade = atividade;
    }

    public Centro() {

    }

    public Integer getCentroId() {
        return CentroId;
    }

    public void setCentroId(Integer centroId) {
        CentroId = centroId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public EnumStatusCentro getStatus() {
        return status;
    }

    public void setStatus(EnumStatusCentro status) {
        this.status = status;
    }

    public String getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(String redesSociais) {
        this.redesSociais = redesSociais;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Especializacao> getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(List<Especializacao> especializacao) {
        this.especializacao = especializacao;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Atividade> getAtividade() {
        return atividade;
    }

    public void setAtividade(List<Atividade> atividade) {
        this.atividade = atividade;
    }

    @Override
    public String toString() {
        return "Centro{" +
                "CentroId=" + CentroId +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade=" + cidade +
                ", status=" + status +
                ", redesSociais='" + redesSociais + '\'' +
                ", foto=" + foto +
                ", dataCadastro=" + dataCadastro +
                ", dataCriacao=" + dataCriacao +
                ", especializacao=" + especializacao +
                ", contato=" + contato +
                ", atividade=" + atividade +
                '}';
    }
}
