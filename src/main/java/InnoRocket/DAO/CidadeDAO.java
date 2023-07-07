package InnoRocket.DAO;

import InnoRocket.Model.Centro;
import InnoRocket.Model.CentroPorCidade;
import InnoRocket.Model.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    public static void salvar(Cidade cidade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
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


    public static Object[] listaPorNomes() {
        List<Cidade> cidades = listar();
        List<String> cidadeNomes = new ArrayList<>();

        for (Cidade cidade : cidades) {
            cidadeNomes.add(cidade.getNome());
        }
        return cidadeNomes.toArray();
    }

    public static List<Cidade> buscaPorNome(String nome) {
        List<Cidade> cidades = listar();
        List<Cidade> cidadeFiltradas = new ArrayList<>();
        for (Cidade centro : cidades) {
            if (centro.getNome().contains(nome)) {
                cidadeFiltradas.add(centro);
            }
        }
        return cidadeFiltradas;
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
