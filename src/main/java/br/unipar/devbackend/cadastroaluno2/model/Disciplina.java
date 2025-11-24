package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private String descricao;

    private String ementa;

    // --- RELAÇÃO COM ALUNOS ---
    @ManyToMany
    @JoinTable(
            name = "disciplina_aluno",
            joinColumns = @JoinColumn(name = "disciplina_codigo", referencedColumnName = "codigo"),
            inverseJoinColumns = @JoinColumn(name = "aluno_ra", referencedColumnName = "ra")
    )
    private List<Aluno> alunos;

    public Disciplina() {}

    public Disciplina(Long id, Professor professor, String codigo, String descricao, String ementa) {
        this.id = id;
        this.professor = professor;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ementa = ementa;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getEmenta() { return ementa; }
    public void setEmenta(String ementa) { this.ementa = ementa; }

    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }
}
