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

    // ➤ CADASTRAR
    @PostMapping
    public Professor cadastrar(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

    // ➤ ATUALIZAR
    @PutMapping
    public Professor atualizar(@RequestBody Professor professor) {
        return professorService.update(professor);
    }

    // ➤ BUSCAR INDIVIDUAL
    @GetMapping("/{id}")
    public Professor buscar(@PathVariable Long id) {
        return professorService.findById(id);
    }

    // ➤ LISTAR (endpoint padrão para o Angular)
    @GetMapping
    public List<Professor> listar() {
        return professorService.findAll();
    }

    // ➤ LISTAR /todos (opcional)
    @GetMapping("/todos")
    public List<Professor> listarTodos() {
        return professorService.findAll();
    }
}
