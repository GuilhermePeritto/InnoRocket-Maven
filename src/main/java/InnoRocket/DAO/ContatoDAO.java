package InnoRocket.DAO;

import InnoRocket.Model.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContatoDAO {
    public static void salvar(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(contato);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static List<Contato> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contato> query = em.createQuery("SELECT contato FROM Contato contato", Contato.class);
        List<Contato> contatos = query.getResultList();

        em.close();
        emf.close();

        return contatos;
    }

    public static Contato buscarPorId(Integer contatoId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        Contato contato = em.find(Contato.class, contatoId);

        em.close();
        emf.close();

        return contato;
    }

    public static void alterar(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(contato);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void excluir(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        contato = em.merge(contato);
        em.remove(contato);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
