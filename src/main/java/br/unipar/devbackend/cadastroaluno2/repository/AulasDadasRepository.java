package br.unipar.devbackend.cadastroaluno2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;

@Repository
public interface AulasDadasRepository extends JpaRepository<AulasDadas, Long> {
    List<AulasDadas> findByDisciplina(Disciplina disciplina);
}
