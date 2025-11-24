package br.unipar.devbackend.cadastroaluno2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;

@Repository
public interface AulasDadasPresencasRepository extends JpaRepository<AulasDadasPresencas, Long> {
    List<AulasDadasPresencas> findByAulaDada(AulasDadas aulaDada);
    List<AulasDadasPresencas> findByAluno(Aluno aluno);
}
