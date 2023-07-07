package InnoRocket.DAO;
import InnoRocket.Model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class FotoDAO {
    public static void salvar (Foto foto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(foto);
        em.getTransaction().commit();
        System.out.println("Foto salva com sucesso!");
        em.close();
        emf.close();
    }

    public static List<Foto> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Foto> query = em.createQuery("SELECT foto FROM Foto foto", Foto.class);
        List<Foto> fotos = query.getResultList();
        em.close();
        emf.close();
        return fotos;
    }

    public static Object[] listaPorNomes() {
        List<Foto> fotos = listar();
        List<String> fotosNomes = new ArrayList<>();

        for (Foto foto : fotos) {
            fotosNomes.add(foto.getNome());
        }
        return fotosNomes.toArray();
    }

    public static List<Foto> buscaPorNome(String nome) {
        List<Foto> fotos = listar();
        List<Foto> fotosFiltradas = new ArrayList<>();
        for (Foto foto : fotos) {
            if (foto.getNome().contains(nome)) {
                fotosFiltradas.add(foto);
            }
        }
        return fotosFiltradas;
    }

    public static void alterar(Foto foto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(foto);
        em.getTransaction().commit();
        System.out.println("Foto alterada com sucesso!");
        em.close();
        emf.close();
    }

    public static void excluir(Foto foto) throws SQLIntegrityConstraintViolationException {
        try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.merge(foto));
        em.getTransaction().commit();
        System.out.println("Foto excluída com sucesso!");
        em.close();
        emf.close();
        } catch (Exception e) {
            throw new SQLIntegrityConstraintViolationException();
        }
    }

}
