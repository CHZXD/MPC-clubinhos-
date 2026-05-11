package com.clubinho.api_mapa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/celulas")
@CrossOrigin(origins = "*") // Permite conexões do seu frontend (GitHub Pages)
public class CelulaController {

    @Autowired
    private CelulaRepository repository;

    // Rota GET: O seu index.html vai chamar essa rota para plotar os marcadores
    @GetMapping
    public List<Celula> listarTodas() {
        return repository.findAll();
    }

    // Rota POST: O seu admin.html vai chamar essa rota para salvar ou atualizar dados
    @PostMapping
    public Celula salvar(@RequestBody Celula celula) {
        return repository.save(celula);
    }
}