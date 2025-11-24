package br.unipar.devbackend.cadastroaluno2.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.service.AlunoService;
import br.unipar.devbackend.cadastroaluno2.service.AlunoDisciplinaService;

@RestController
@RequestMapping("/api/aluno")
@CrossOrigin(origins = "*")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoDisciplinaService alunoDisciplinaService;

    // Cadastrar aluno
    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    // Atualizar aluno
    @PutMapping("/api/aluno")
    public Aluno atualizarAluno(@RequestBody Aluno aluno) {
        return alunoService.update(aluno);
    }

    // Buscar aluno por ID
    @GetMapping("/aluno/{id}")
    public Aluno buscarAluno(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    // Listar todos os alunos
    @GetMapping("/todos")
    public List<Aluno> listarTodos() {
        return alunoService.findAll();
    }

    // Atualizar 1º bimestre
    @PutMapping("/{idAluno}/disciplina/{idDisciplina}/1bim")
    public AlunoDisciplina atualizar1Bimestre(
            @PathVariable Long idAluno,
            @PathVariable Long idDisciplina,
            @RequestBody AlunoDisciplina dados) {

        Aluno aluno = alunoService.findById(idAluno);

        Disciplina disciplina = new Disciplina();
        disciplina.setId(idDisciplina);

        AlunoDisciplina ad = alunoDisciplinaService.findByAlunoAndDisciplina(aluno, disciplina);

        return alunoDisciplinaService.atualizar1Bimestre(ad, dados.getNota1Bim(), dados.getFaltas1Bim());
    }

    // Atualizar 2º bimestre
    @PutMapping("/{idAluno}/disciplina/{idDisciplina}/2bim")
    public AlunoDisciplina atualizar2Bimestre(
            @PathVariable Long idAluno,
            @PathVariable Long idDisciplina,
            @RequestBody AlunoDisciplina dados) {

        Aluno aluno = alunoService.findById(idAluno);

        Disciplina disciplina = new Disciplina();
        disciplina.setId(idDisciplina);

        AlunoDisciplina ad = alunoDisciplinaService.findByAlunoAndDisciplina(aluno, disciplina);

        return alunoDisciplinaService.atualizar2Bimestre(ad, dados.getNota2Bim(), dados.getFaltas2Bim());
    }

    // Boletim do aluno
    @GetMapping("/{id}/boletim")
    public List<AlunoDisciplina> boletim(@PathVariable Long id) {
        Aluno aluno = alunoService.findById(id);
        // Aqui chamamos o método simples e tradicional do AlunoService
        return alunoService.getBoletim(aluno);
    }
}
