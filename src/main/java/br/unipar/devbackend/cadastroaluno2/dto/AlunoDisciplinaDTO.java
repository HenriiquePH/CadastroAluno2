package br.unipar.devbackend.cadastroaluno2.dto;

import br.unipar.devbackend.cadastroaluno2.enums.SituacaoAluno; // <-- import necessário

public class AlunoDisciplinaDTO {

    private Long id;
    private Long alunoId;
    private Long disciplinaId;
    private Double nota1Bim;
    private Double nota2Bim;
    private Integer faltas1Bim;
    private Integer faltas2Bim;
    private Boolean matriculado;
    private SituacaoAluno situacao;

    public AlunoDisciplinaDTO() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Long disciplinaId) { this.disciplinaId = disciplinaId; }

    public Double getNota1Bim() { return nota1Bim; }
    public void setNota1Bim(Double nota1Bim) { this.nota1Bim = nota1Bim; }

    public Double getNota2Bim() { return nota2Bim; }
    public void setNota2Bim(Double nota2Bim) { this.nota2Bim = nota2Bim; }

    public Integer getFaltas1Bim() { return faltas1Bim; }
    public void setFaltas1Bim(Integer faltas1Bim) { this.faltas1Bim = faltas1Bim; }

    public Integer getFaltas2Bim() { return faltas2Bim; }
    public void setFaltas2Bim(Integer faltas2Bim) { this.faltas2Bim = faltas2Bim; }

    public Boolean getMatriculado() { return matriculado; }
    public void setMatriculado(Boolean matriculado) { this.matriculado = matriculado; }

    public SituacaoAluno getSituacao() { return situacao; }
    public void setSituacao(SituacaoAluno situacao) { this.situacao = situacao; }
}
