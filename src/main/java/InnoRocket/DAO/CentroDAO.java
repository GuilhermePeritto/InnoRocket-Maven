package InnoRocket.DAO;

import InnoRocket.Model.Centro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CentroDAO {
    public static void salvar(Centro centro) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(centro);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static List<Centro> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Centro> query = em.createQuery("SELECT centro FROM Centro centro", Centro.class);
        List<Centro> centros = query.getResultList();

        em.close();
        emf.close();

        return centros;
    }

    public static Centro buscarPorId(Integer centroId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        Centro centro = em.find(Centro.class, centroId);

        em.close();
        emf.close();

        return centro;
    }

    public static void alterar(Centro centro) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(centro);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static void excluir(Centro centro) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        centro = em.merge(centro);
        em.remove(centro);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
