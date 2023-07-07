package InnoRocket.DAO;

import InnoRocket.Model.Cidade;
import InnoRocket.Model.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
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

    public static Object[] listaPorNomes() {
        List<Contato> contatos = listar();
        List<String> contatoNomes = new ArrayList<>();

        for (Contato contato : contatos) {
            contatoNomes.add(contato.getNome());
        }
        return contatoNomes.toArray();
    }

    public static List<Contato> buscaPorNome(String nome) {
        List<Contato> contatos = listar();
        List<Contato> contatosFiltrados = new ArrayList<>();
        for (Contato contato : contatos) {
            if (contato.getNome().contains(nome)) {
                contatosFiltrados.add(contato);
            }
        }
        return contatosFiltrados;
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

    public static void excluir(Contato contato) throws SQLIntegrityConstraintViolationException {
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        contato = em.merge(contato);
        em.remove(contato);
        em.getTransaction().commit();
        em.close();
        emf.close();
        } catch (Exception e) {
            throw new SQLIntegrityConstraintViolationException();
        }
    }
}
