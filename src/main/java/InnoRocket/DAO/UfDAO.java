package InnoRocket.DAO;
import InnoRocket.Model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UfDAO {
    public static void salvar (Uf uf) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(uf);
        em.getTransaction().commit();
        System.out.println("UF salva com sucesso!");
        em.close();
        emf.close();
    }

    public static List<Uf> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Uf> query = em.createQuery("SELECT uf FROM Uf uf", Uf.class);
        List<Uf> ufs = query.getResultList();
        em.close();
        emf.close();
        return ufs;
    }

    public static Object[] listarPorSigla() {
        List<Uf> ufs = listar();
        List<String> ufSiglas = new ArrayList<>();

        for (Uf uf : ufs) {
            ufSiglas.add(uf.getSigla());
        }
        return ufSiglas.toArray();
    }

    public static List<Uf> buscaPorSigla(String sigla) {
        List<Uf> ufs = listar();
        List<Uf> ufsFiltradas = new ArrayList<>();
        for (Uf uf : ufs) {
            if (uf.getSigla().contains(sigla)) {
                ufsFiltradas.add(uf);
            }
        }
        return ufsFiltradas;
    }

    public static void alterar(Uf uf) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(uf);
        em.getTransaction().commit();
        System.out.println("UF alterada com sucesso!");
        em.close();
        emf.close();
    }

    public static void excluir(Uf uf) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.merge(uf));
        em.getTransaction().commit();
        System.out.println("UF excluída com sucesso!");
        em.close();
        emf.close();
    }

}
