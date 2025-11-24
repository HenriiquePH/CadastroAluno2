package br.unipar.devbackend.cadastroaluno2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ra;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    private Integer anoIngresso;

    private Integer periodoAtual;

    public Aluno() {}

    public Aluno(Long id, String ra, String nome, String cpf, Integer anoIngresso, Integer periodoAtual) {
        this.id = id;
        this.ra = ra;
        this.nome = nome;
        this.cpf = cpf;
        this.anoIngresso = anoIngresso;
        this.periodoAtual = periodoAtual;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public Integer getAnoIngresso() { return anoIngresso; }
    public void setAnoIngresso(Integer anoIngresso) { this.anoIngresso = anoIngresso; }
    public Integer getPeriodoAtual() { return periodoAtual; }
    public void setPeriodoAtual(Integer periodoAtual) { this.periodoAtual = periodoAtual; }
}
