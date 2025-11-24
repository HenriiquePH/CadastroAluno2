package br.unipar.devbackend.cadastroaluno2.dto;

public class ProfessorDTO {

    private Long id;
    private String matricula;
    private String nome;
    private String cpf;

    public ProfessorDTO() {}

    public ProfessorDTO(Long id, String matricula, String nome, String cpf) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}
