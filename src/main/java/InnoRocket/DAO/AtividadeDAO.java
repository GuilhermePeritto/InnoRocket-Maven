package InnoRocket.DAO;

import InnoRocket.Model.Atividade;
import InnoRocket.Model.Foto;
import InnoRocket.Model.Uf;

import javax.persistence.*;
import javax.swing.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtividadeDAO {


    public static void salvar (Atividade atividade) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(atividade);
        em.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso!");
        em.close();
        emf.close();
    }

    public static List<Atividade> listar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Atividade> query = em.createQuery("SELECT atividade FROM Atividade atividade", Atividade.class);
        List<Atividade> atividades = query.getResultList();
        em.close();
        emf.close();
        return atividades;
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

    public static List<Atividade> buscaPorData(Date data) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Atividade> query = em.createQuery("SELECT atividade FROM Atividade atividade WHERE atividade.data = :data", Atividade.class);
        query.setParameter("data", data);
        List<Atividade> atividades = query.getResultList();
        em.close();
        emf.close();
        return atividades;
    }

    public static List<Atividade> buscaPorStatus(String status) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Atividade> query = em.createQuery("SELECT atividade FROM Atividade atividade WHERE atividade.status = :status", Atividade.class);
        query.setParameter("status", status);
        List<Atividade> atividades = query.getResultList();
        em.close();
        emf.close();
        return atividades;
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

    public static void excluir(Atividade atividade) throws SQLIntegrityConstraintViolationException{
        try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(atividade));
        em.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Atividade excluída com sucesso!");
        em.close();
        emf.close();
        } catch (Exception e) {
            throw new SQLIntegrityConstraintViolationException();
        }
    }
}
