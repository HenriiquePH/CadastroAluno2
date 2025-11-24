package br.unipar.devbackend.cadastroaluno2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.repository.AulasDadasPresencasRepository;

@Service
public class AulasDadasPresencasService {

    @Autowired
    private AulasDadasPresencasRepository presencasRepository;

    // Listar todas as presenças
    public List<AulasDadasPresencas> findAll() {
        return presencasRepository.findAll();
    }

    // Buscar presença por ID
    public AulasDadasPresencas findById(Long id) {
        Optional<AulasDadasPresencas> presenca = presencasRepository.findById(id);
        return presenca.orElse(null);
    }

    // Listar presenças de uma aula específica
    public List<AulasDadasPresencas> findByAula(AulasDadas aula) {
        return presencasRepository.findByAulaDada(aula);
    }

    // Listar presenças de um aluno específico
    public List<AulasDadasPresencas> findByAluno(Aluno aluno) {
        return presencasRepository.findByAluno(aluno);
    }

    // Salvar nova presença
    public AulasDadasPresencas save(AulasDadasPresencas presenca) {
        return presencasRepository.save(presenca);
    }

    // Atualizar presença existente
    public AulasDadasPresencas update(AulasDadasPresencas presenca) {
        return presencasRepository.save(presenca);
    }

    // Deletar presença
    public void delete(Long id) {
        presencasRepository.deleteById(id);
    }
}
