package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import br.unipar.devbackend.cadastroaluno2.enums.SituacaoAluno; // <-- import do enum

@Entity
@Table(name = "aluno_disciplina")
public class AlunoDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    private Double nota1Bim;
    private Double nota2Bim;
    private Integer faltas1Bim;
    private Integer faltas2Bim;
    private Boolean matriculado;

    @Enumerated(EnumType.STRING)
    private SituacaoAluno situacao;

    public AlunoDisciplina() {}

    public AlunoDisciplina(Long id, Aluno aluno, Disciplina disciplina, Double nota1Bim, Double nota2Bim,
                           Integer faltas1Bim, Integer faltas2Bim, Boolean matriculado, SituacaoAluno situacao) {
        this.id = id;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.nota1Bim = nota1Bim;
        this.nota2Bim = nota2Bim;
        this.faltas1Bim = faltas1Bim;
        this.faltas2Bim = faltas2Bim;
        this.matriculado = matriculado;
        this.situacao = situacao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
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
