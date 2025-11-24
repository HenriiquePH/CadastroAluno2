package br.unipar.devbackend.cadastroaluno2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import br.unipar.devbackend.cadastroaluno2.model.Professor;
import br.unipar.devbackend.cadastroaluno2.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElse(null);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor update(Professor professor) {
        return professorRepository.save(professor);
    }

    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}
