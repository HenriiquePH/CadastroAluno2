package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.model.AlunoDisciplina;
import br.unipar.devbackend.cadastroaluno2.service.AlunoDisciplinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplina")
@CrossOrigin(origins = "*")
public class AlunoDisciplinaController {

    private final AlunoDisciplinaService alunoDisciplinaService;

    public AlunoDisciplinaController(AlunoDisciplinaService alunoDisciplinaService) {
        this.alunoDisciplinaService = alunoDisciplinaService;
    }

    // 👉 LISTA TODOS ALUNOS MATRICULADOS EM UMA DISCIPLINA
    @GetMapping("/{idDisciplina}/matriculados")
    public List<AlunoDisciplina> listarMatriculados(@PathVariable Long idDisciplina) {
        return alunoDisciplinaService.findByDisciplina(idDisciplina);
    }
}
