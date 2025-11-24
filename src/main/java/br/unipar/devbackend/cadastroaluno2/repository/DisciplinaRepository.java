package br.unipar.devbackend.cadastroaluno2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.model.Professor;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Disciplina findByCodigo(String codigo);
    List<Disciplina> findByProfessor(Professor professor);
}
