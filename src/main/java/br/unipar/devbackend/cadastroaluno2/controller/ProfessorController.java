package br.unipar.devbackend.cadastroaluno2.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.Professor;
import br.unipar.devbackend.cadastroaluno2.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
@CrossOrigin(origins = "*")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public Professor cadastrar(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

    @PutMapping
    public Professor atualizar(@RequestBody Professor professor) {
        return professorService.update(professor);
    }

    @GetMapping("/{id}")
    public Professor buscar(@PathVariable Long id) {
        return professorService.findById(id);
    }

    @GetMapping("/todos")
    public List<Professor> listarTodos() {
        return professorService.findAll();
    }
}
