package br.unipar.devbackend.cadastroaluno2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipar.devbackend.cadastroaluno2.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
