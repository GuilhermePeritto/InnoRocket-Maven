package InnoRocket.DAO;

import InnoRocket.Model.Centro;
import InnoRocket.Model.CentroPorCidade;
import InnoRocket.Model.CentroPorEspecializacao;

import javax.persistence.*;
import javax.swing.*;
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

    public static List<CentroPorEspecializacao> listarCentroPorEspecializacao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        String sqlQuery = "SELECT e.nome AS especializacao, COUNT(*) AS quantidadeCentro " +
                "FROM centro c " +
                "JOIN centroEspecializacao ce ON c.CentroId = ce.CentroId " +
                "JOIN especializacao e ON e.EspecializacaoId = ce.EspecializacaoId " +
                "GROUP BY ce.EspecializacaoId";

        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery(sqlQuery);
        List<Object[]> results = query.getResultList();

        List<CentroPorEspecializacao> centroPorEspecializacoes = new ArrayList<>();
        for (Object[] result : results) {
            String especializacao = (String) result[0];
            Integer quantidadeCentro = ((Number) result[1]).intValue();

            CentroPorEspecializacao centroPorEspecializacao = new CentroPorEspecializacao(especializacao, quantidadeCentro.toString());
            centroPorEspecializacoes.add(centroPorEspecializacao);
        }

        return centroPorEspecializacoes;
    }

    public static List<CentroPorCidade> listarCentroPorCidade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnoRocketMaven");
        EntityManager em = emf.createEntityManager();
        String sqlQuery = "SELECT cid.nome AS cidade, COUNT(cid.CidadeId) AS quantidadecentro " +
                "FROM cidade cid " +
                "JOIN centro c ON c.CidadeId = cid.CidadeId " +
                "GROUP BY cid.nome";

        TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNativeQuery(sqlQuery);
        List<Object[]> results = query.getResultList();

        List<CentroPorCidade> centroPorCidades = new ArrayList<>();
        for (Object[] result : results) {
            String cidade = (String) result[0];
            Integer quantidadeCentro = ((Number) result[1]).intValue();

            CentroPorCidade centroPorCidade = new CentroPorCidade(cidade, quantidadeCentro);
            centroPorCidades.add(centroPorCidade);
        }

        em.close();
        emf.close();

        return centroPorCidades;
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
        JOptionPane.showMessageDialog(null, "Centro excluído com sucesso!");
    }
}
