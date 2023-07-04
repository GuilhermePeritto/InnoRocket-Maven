package Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Foto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer FotoId;
    public String url;

    public Foto(Integer fotoId, String nome) {
        FotoId = fotoId;
        this.url = nome;
    }

    public Integer getFotoId() {
        return FotoId;
    }

    public void setFotoId(Integer fotoId) {
        FotoId = fotoId;
    }

    public String getNome() {
        return url;
    }

    public void setNome(String nome) {
        this.url = nome;
    }

    @Override
    public String toString() {
        return "Foto{" +
                "FotoId=" + FotoId +
                ", url='" + url + '\'' +
                '}';
    }
}
