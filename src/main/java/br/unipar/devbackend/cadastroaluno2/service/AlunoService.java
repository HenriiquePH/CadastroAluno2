package br.unipar.devbackend.cadastroaluno2.service;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoRepository;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoDisciplinaRepository alunoDisciplinaRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno findById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Método para retornar o boletim do aluno
    public List<AlunoDisciplina> getBoletim(Aluno aluno) {
        return alunoDisciplinaRepository.findByAluno(aluno);
    }
}
