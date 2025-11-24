package br.unipar.devbackend.cadastroaluno2.controller;

import br.unipar.devbackend.cadastroaluno2.service.DisciplinaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Disciplina;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;

@RestController
@RequestMapping("/api/aula")
@CrossOrigin(origins = "*")
public class AulasDadasController {

    @Autowired
    private AulasDadasService aulasDadasService;

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/disciplina/{idDisciplina}")
    public AulasDadas cadastrarAula(@PathVariable Long idDisciplina, @RequestBody AulasDadas aula) {
        Disciplina disciplina = disciplinaService.findById(idDisciplina);
        aula.setDisciplina(disciplina);
        return aulasDadasService.save(aula);
    }

    @GetMapping("/disciplina/{idDisciplina}")
    public List<AulasDadas> listarAulas(@PathVariable Long idDisciplina) {
        Disciplina disciplina = disciplinaService.findById(idDisciplina);
        return aulasDadasService.findByDisciplina(disciplina);
    }
}
