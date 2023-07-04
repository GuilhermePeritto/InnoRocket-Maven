package InnoRocket.DAO;
import InnoRocket.Model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EspecioalizacaoDAO {
    public static void salvar (Especializacao especializacao) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(especializacao);
        em.getTransaction().commit();
        System.out.println("Especializacao salva com sucesso!");
        em.close();
        emf.close();
    }

    public static List<Especializacao> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Especializacao> query = em.createQuery("SELECT especializacao FROM Especializacao especializacao", Especializacao.class);
        List<Especializacao> especializacoes = query.getResultList();
        em.close();
        emf.close();
        return especializacoes;
    }

    public static Object[] listaPorNomes() {
        List<Especializacao> especializacoes = listar();
        List<String> especializacaoNomes = new ArrayList<>();

        for (Especializacao especializacao : especializacoes) {
            especializacaoNomes.add(especializacao.getDescricao());
        }
        return especializacaoNomes.toArray();
    }

    public static List<Especializacao> buscaPorNome(String descricao) {
        List<Especializacao> especializacoes = listar();
        List<Especializacao> especializacoesFiltradas = new ArrayList<>();
        for (Especializacao especializacao : especializacoes) {
            if (especializacao.getDescricao().contains(descricao)) {
                especializacoesFiltradas.add(especializacao);
            }
        }
        return especializacoesFiltradas;
    }

    public static void alterar(Especializacao especializacao) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(especializacao);
        em.getTransaction().commit();
        System.out.println("Especializacao alterada com sucesso!");
        em.close();
        emf.close();
    }

    public static void excluir(Especializacao especializacao) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.merge(especializacao));
        em.getTransaction().commit();
        System.out.println("Especializacao excluída com sucesso!");
        em.close();
        emf.close();
    }

}