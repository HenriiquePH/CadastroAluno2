package br.unipar.devbackend.cadastroaluno2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;

import java.util.List;

@Repository
public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina, Long> {

    // Busca uma matrícula específica de um aluno em uma disciplina
    AlunoDisciplina findByAlunoAndDisciplina(Aluno aluno, Disciplina disciplina);

    // Busca todas as disciplinas de um aluno (para o boletim)
    List<AlunoDisciplina> findByAluno(Aluno aluno);
}
