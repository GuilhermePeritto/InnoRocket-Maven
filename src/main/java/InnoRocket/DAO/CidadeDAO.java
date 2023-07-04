package InnoRocket.DAO;

import InnoRocket.Model.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CidadeDAO {
    public static void salvar(Cidade cidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        System.out.println("Cidade salva com sucesso!");
        em.getTransaction().begin();
        em.persist(cidade);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public static List<Cidade> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Cidade> query = em.createQuery("SELECT cidade FROM Cidade cidade", Cidade.class);
        List<Cidade> cidades = query.getResultList();

        em.close();
        emf.close();

        return cidades;
    }

    public static Cidade buscarPorId(Integer cidadeId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        Cidade cidade = em.find(Cidade.class, cidadeId);

        em.close();
        emf.close();

        return cidade;
    }

    public static void alterar(Cidade cidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(cidade);
        em.getTransaction().commit();
        System.out.println("Cidade alterada com sucesso!");
        em.close();
        emf.close();
    }

    public static void excluir(Cidade cidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        cidade = em.merge(cidade);
        em.remove(cidade);
        em.getTransaction().commit();
        System.out.println("Cidade excluída com sucesso!");
        em.close();
        emf.close();
    }
}
