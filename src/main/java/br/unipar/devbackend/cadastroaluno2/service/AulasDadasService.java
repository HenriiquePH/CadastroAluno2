package br.unipar.devbackend.cadastroaluno2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasRepository;

@Service
public class AulasDadasService {

    @Autowired
    private AulasDadasRepository aulasDadasRepository;

    // Listar todas as aulas
    public List<AulasDadas> findAll() {
        return aulasDadasRepository.findAll();
    }

    // Buscar aula por ID
    public AulasDadas findById(Long id) {
        Optional<AulasDadas> aula = aulasDadasRepository.findById(id);
        return aula.orElse(null);
    }

    // Listar aulas de uma disciplina específica
    public List<AulasDadas> findByDisciplina(Disciplina disciplina) {
        return aulasDadasRepository.findByDisciplina(disciplina);
    }

    // Salvar nova aula
    public AulasDadas save(AulasDadas aula) {
        return aulasDadasRepository.save(aula);
    }

    // Atualizar aula existente
    public AulasDadas update(AulasDadas aula) {
        return aulasDadasRepository.save(aula);
    }

    // Deletar aula
    public void delete(Long id) {
        aulasDadasRepository.deleteById(id);
    }
}
