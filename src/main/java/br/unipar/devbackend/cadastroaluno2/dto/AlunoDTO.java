package br.unipar.devbackend.cadastroaluno2.dto;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String ra;
    private Integer anoIngresso;
    private Integer periodoAtual;

    public AlunoDTO() {}

    public AlunoDTO(Long id, String nome, String cpf, String ra, Integer anoIngresso, Integer periodoAtual) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.ra = ra;
        this.anoIngresso = anoIngresso;
        this.periodoAtual = periodoAtual;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }
    public Integer getAnoIngresso() { return anoIngresso; }
    public void setAnoIngresso(Integer anoIngresso) { this.anoIngresso = anoIngresso; }
    public Integer getPeriodoAtual() { return periodoAtual; }
    public void setPeriodoAtual(Integer periodoAtual) { this.periodoAtual = periodoAtual; }
}
