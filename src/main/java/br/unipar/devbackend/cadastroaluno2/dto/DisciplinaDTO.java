package br.unipar.devbackend.cadastroaluno2.dto;

public class DisciplinaDTO {

    private Long id;
    private Long professorId;
    private String codigo;
    private String descricao;
    private String ementa;

    public DisciplinaDTO() {}

    public DisciplinaDTO(Long id, Long professorId, String codigo, String descricao, String ementa) {
        this.id = id;
        this.professorId = professorId;
        this.codigo = codigo;
        this.descricao = descricao;
        this.ementa = ementa;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getEmenta() { return ementa; }
    public void setEmenta(String ementa) { this.ementa = ementa; }
}
