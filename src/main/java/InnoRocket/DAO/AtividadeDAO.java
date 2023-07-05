package InnoRocket.DAO;

import InnoRocket.Model.Atividade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO {
    public static void salvar (Atividade atividade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(atividade);
        em.getTransaction().commit();
        System.out.println("Atividade salva com sucesso!");
        em.close();
        emf.close();
    }

    public static List<Atividade> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Atividade> query = em.createQuery("SELECT atividade FROM Atividade atividade", Atividade.class);
        List<Atividade> ufs = query.getResultList();
        em.close();
        emf.close();
        return ufs;
    }

    public static Object[] listaPorNome() {
        List<Atividade> atividades = listar();
        List<String> atividadeNome = new ArrayList<>();

        for (Atividade atividade : atividades) {
            atividadeNome.add(atividade.getNome());
        }
        return atividadeNome.toArray();
    }

    public static List<Atividade> buscaPorNome(String nome) {
        List<Atividade> atividades = listar();
        List<Atividade> atividadesFiltradas = new ArrayList<>();
        for (Atividade atividade : atividades) {
            if (atividade.getNome().contains(nome)) {
                atividadesFiltradas.add(atividade);
            }
        }
        return atividadesFiltradas;
    }

    public static void alterar(Atividade atividade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(atividade);
        em.getTransaction().commit();
        System.out.println("Atividade alterada com sucesso!");
        em.close();
        emf.close();
    }

    public static void excluir(Atividade atividade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.merge(atividade));
        em.getTransaction().commit();
        System.out.println("Atividade excluída com sucesso!");
        em.close();
        emf.close();
    }
}
