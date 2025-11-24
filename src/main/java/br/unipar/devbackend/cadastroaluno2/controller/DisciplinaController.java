package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.model.Professor;
import br.unipar.devbackend.cadastroaluno2.service.DisciplinaService;
import br.unipar.devbackend.cadastroaluno2.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplina")
@CrossOrigin(origins = "*")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    private final ProfessorService professorService;

    public DisciplinaController(DisciplinaService disciplinaService,
                                ProfessorService professorService) {
        this.disciplinaService = disciplinaService;
        this.professorService = professorService;
    }

    // --------------------------------------
    // BUSCAR POR CÓDIGO
    // --------------------------------------
    @GetMapping("/{codigo}")
    public Disciplina buscarPorCodigo(@PathVariable String codigo) {
        return disciplinaService.findByCodigo(codigo);  // <--- Nome correto
    }

    // --------------------------------------
    // LISTAR TODAS AS DISCIPLINAS
    // --------------------------------------
    @GetMapping("/todas")
    public List<Disciplina> listarTodas() {
        return disciplinaService.findAll();
    }

    // --------------------------------------
    // LISTAR DISCIPLINAS DE UM PROFESSOR
    // --------------------------------------
    @GetMapping("/professor/{idProfessor}")
    public List<Disciplina> listarPorProfessor(@PathVariable Long idProfessor) {
        Professor professor = professorService.findById(idProfessor);

        if (professor == null) {
            throw new RuntimeException("Professor não encontrado");
        }

        return disciplinaService.findByProfessor(professor);
    }
}
