package br.unipar.devbackend.cadastroaluno2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;
import br.unipar.devbackend.cadastroaluno2.enums.SituacaoAluno;

import java.util.List;

@Service
public class AlunoDisciplinaService {

    @Autowired
    private AlunoDisciplinaRepository alunoDisciplinaRepository;

    public AlunoDisciplina findByAlunoAndDisciplina(Aluno aluno, Disciplina disciplina) {
        return alunoDisciplinaRepository.findByAlunoAndDisciplina(aluno, disciplina);
    }

    public AlunoDisciplina save(AlunoDisciplina alunoDisciplina) {
        return alunoDisciplinaRepository.save(alunoDisciplina);
    }

    // 👉 NOVO MÉTODO NECESSÁRIO PARA O FRONT
    public List<AlunoDisciplina> findByDisciplina(Long idDisciplina) {
        return alunoDisciplinaRepository.findByDisciplinaId(idDisciplina);
    }

    // Atualiza nota e faltas de 1º bimestre
    public AlunoDisciplina atualizar1Bimestre(AlunoDisciplina ad, Double nota, Integer faltas) {
        ad.setNota1Bim(nota);
        ad.setFaltas1Bim(faltas);
        ad.setSituacao(SituacaoAluno.EM_CURSO);
        ad.setMatriculado(true);
        return alunoDisciplinaRepository.save(ad);
    }

    // Atualiza nota e faltas de 2º bimestre
    public AlunoDisciplina atualizar2Bimestre(AlunoDisciplina ad, Double nota, Integer faltas) {
        ad.setNota2Bim(nota);
        ad.setFaltas2Bim(faltas);

        double nota1 = (ad.getNota1Bim() != null) ? ad.getNota1Bim() : 0.0;
        double nota2 = (ad.getNota2Bim() != null) ? ad.getNota2Bim() : 0.0;

        double media = (nota1 + nota2) / 2.0;

        int faltas1 = (ad.getFaltas1Bim() != null) ? ad.getFaltas1Bim() : 0;
        int faltas2 = (ad.getFaltas2Bim() != null) ? ad.getFaltas2Bim() : 0;
        int totalFaltas = faltas1 + faltas2;

        if (media >= 6.0 && totalFaltas <= 75) {
            ad.setSituacao(SituacaoAluno.APROVADO);
            ad.setMatriculado(false);
        } else {
            ad.setSituacao(SituacaoAluno.REPROVADO);
            ad.setMatriculado(true);
        }

        return alunoDisciplinaRepository.save(ad);
    }
}
