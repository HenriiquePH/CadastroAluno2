package br.unipar.devbackend.cadastroaluno2.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.repository.AlunoDisciplinaRepository;
import br.unipar.devbackend.cadastroaluno2.enums.SituacaoAluno;

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

    // Atualiza nota e faltas de 1º bimestre
    public AlunoDisciplina atualizar1Bimestre(AlunoDisciplina ad, Double nota, Integer faltas) {
        ad.setNota1Bim(nota);
        ad.setFaltas1Bim(faltas);
        ad.setSituacao(SituacaoAluno.EM_CURSO);
        ad.setMatriculado(true);
        return alunoDisciplinaRepository.save(ad);
    }

    // Atualiza nota e faltas de 2º bimestre e calcula situação
    public AlunoDisciplina atualizar2Bimestre(AlunoDisciplina ad, Double nota, Integer faltas) {
        ad.setNota2Bim(nota);
        ad.setFaltas2Bim(faltas);

        // Pegando notas individuais de forma tradicional
        double nota1 = 0.0;
        if (ad.getNota1Bim() != null) {
            nota1 = ad.getNota1Bim();
        }

        double nota2 = 0.0;
        if (ad.getNota2Bim() != null) {
            nota2 = ad.getNota2Bim();
        }

        // Calculando média
        double media = (nota1 + nota2) / 2.0;

        // Pegando faltas individuais de forma tradicional
        int faltas1 = 0;
        if (ad.getFaltas1Bim() != null) {
            faltas1 = ad.getFaltas1Bim();
        }

        int faltas2 = 0;
        if (ad.getFaltas2Bim() != null) {
            faltas2 = ad.getFaltas2Bim();
        }

        int totalFaltas = faltas1 + faltas2;

        // Verificando aprovação
        if (media >= 6.0 && totalFaltas <= 75) { // Exemplo: 25% de faltas permitido
            ad.setSituacao(SituacaoAluno.APROVADO);
            ad.setMatriculado(false);
        } else {
            ad.setSituacao(SituacaoAluno.REPROVADO);
            ad.setMatriculado(true);
        }

        return alunoDisciplinaRepository.save(ad);
    }
}
