package br.unipar.devbackend.cadastroaluno2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.model.Professor;
import br.unipar.devbackend.cadastroaluno2.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Disciplina findById(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    public Disciplina findByCodigo(String codigo) {
        return disciplinaRepository.findByCodigo(codigo);
    }

    public List<Disciplina> findByProfessor(Professor professor) {
        return disciplinaRepository.findByProfessor(professor);
    }

    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina update(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void delete(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
