package br.unipar.devbackend.cadastroaluno2.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import br.unipar.devbackend.cadastroaluno2.model.AulasDadasPresencas;
import br.unipar.devbackend.cadastroaluno2.model.AulasDadas;
import br.unipar.devbackend.cadastroaluno2.model.Aluno;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasPresencasService;
import br.unipar.devbackend.cadastroaluno2.service.AulasDadasService;
import br.unipar.devbackend.cadastroaluno2.service.AlunoService;

@RestController
@RequestMapping("/api/auladada")
@CrossOrigin(origins = "*")
public class AulasDadasPresencasController {

    @Autowired
    private AulasDadasPresencasService presencasService;

    @Autowired
    private AulasDadasService aulasDadasService;

    @Autowired
    private AlunoService alunoService;

    // Registrar presenças de uma lista de alunos
    @PostMapping("/{idAulaDada}")
    public List<AulasDadasPresencas> registrarPresencas(
            @PathVariable Long idAulaDada,
            @RequestBody List<AulasDadasPresencas> presencas) {

        AulasDadas aula = aulasDadasService.findById(idAulaDada);

        for (AulasDadasPresencas p : presencas) {
            Aluno aluno = alunoService.findById(p.getAluno().getId());
            p.setAluno(aluno);
            p.setAulaDada(aula);
            presencasService.save(p);
        }

        return presencasService.findByAula(aula);
    }
}
