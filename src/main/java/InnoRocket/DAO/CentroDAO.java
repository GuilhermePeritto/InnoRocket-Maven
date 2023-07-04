package InnoRocket.DAO;

import InnoRocket.Model.Centro;
import InnoRocket.Model.Foto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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

    public static Object[] listaPorNomes() {
        List<Centro> centros = listar();
        List<String> centroNomes = new ArrayList<>();

        for (Centro centro : centros) {
            centroNomes.add(centro.getNome());
        }
        return centroNomes.toArray();
    }

    public static List<Centro> buscaPorNome(String nome) {
        List<Centro> centros = listar();
        List<Centro> centrosFiltradas = new ArrayList<>();
        for (Centro centro : centros) {
            if (centro.getNome().contains(nome)) {
                centrosFiltradas.add(centro);
            }
        }
        return centrosFiltradas;
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
