package hbd.operations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import hbd.entities.Alunos;

public class hbdOperations {
	
	private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public hbdOperations() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("estudodirigidos");
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    
    public List<Alunos> obterTodosAlunos() {
        Query query = entityManager.createQuery("SELECT a FROM Alunos a");
        return query.getResultList();
    }

    public void exibirAlunos(List<Alunos> alunos) {
        for (Alunos aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + ", Data de Nascimento: " + aluno.getData());
        }
    }

    public Long obterTotalAlunos() {
        Query query = entityManager.createQuery("SELECT COUNT(a) FROM Alunos a");
        return (Long) query.getSingleResult();
    }

    public void atualizarAlunoPeloNome(String nomeAtual, String novoNome) {
        entityManager.getTransaction().begin();

        // Encontrar o aluno pelo nome
        Query query = entityManager.createQuery("SELECT a FROM Alunos a WHERE a.nome = :nomeAtual");
        query.setParameter("nomeAtual", nomeAtual);
        List<Alunos> alunosCoincidentes = query.getResultList();

        if (!alunosCoincidentes.isEmpty()) {
            Alunos alunoParaAtualizar = alunosCoincidentes.get(0);
            alunoParaAtualizar.setNome(novoNome); // Atualizar o nome
            entityManager.merge(alunoParaAtualizar);
            entityManager.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Aluno com o nome fornecido não encontrado.");
        }
    }

    public void fecharRecursos() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

