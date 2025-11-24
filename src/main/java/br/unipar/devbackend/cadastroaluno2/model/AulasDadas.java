package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "aulas_dadas")
public class AulasDadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @Temporal(TemporalType.DATE)
    private Date data;

    private String observacoes;

    public AulasDadas() {}

    public AulasDadas(Long id, Disciplina disciplina, Date data, String observacoes) {
        this.id = id;
        this.disciplina = disciplina;
        this.data = data;
        this.observacoes = observacoes;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
