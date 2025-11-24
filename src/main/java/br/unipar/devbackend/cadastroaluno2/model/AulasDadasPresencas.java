package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aulas_dadas_presencas")
public class AulasDadasPresencas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private AulasDadas aulaDada;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    private Boolean falta;

    public AulasDadasPresencas() {}

    public AulasDadasPresencas(Long id, AulasDadas aulaDada, Aluno aluno, Boolean falta) {
        this.id = id;
        this.aulaDada = aulaDada;
        this.aluno = aluno;
        this.falta = falta;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public AulasDadas getAulaDada() { return aulaDada; }
    public void setAulaDada(AulasDadas aulaDada) { this.aulaDada = aulaDada; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public Boolean getFalta() { return falta; }
    public void setFalta(Boolean falta) { this.falta = falta; }
}
