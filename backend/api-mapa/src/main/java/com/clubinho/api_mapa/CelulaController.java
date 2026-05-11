package com.clubinho.api_mapa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/celulas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // Permite conexões do seu frontend (GitHub Pages)
public class CelulaController {

    @Autowired
    private CelulaRepository repository;

    // Rota GET: listar todas
    @GetMapping
    public List<Celula> listarTodas() {
        return repository.findAll();
    }

    // Rota GET: buscar por ID
    @GetMapping("/{id}")
    public Celula buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Célula não encontrada"));
    }

    // Rota POST: criar/salvar
    @PostMapping
    public Celula salvar(@RequestBody Celula celula) {
        return repository.save(celula);
    }

    // Rota PUT: atualizar por ID
    @PutMapping("/{id}")
    public Celula atualizar(@PathVariable Long id, @RequestBody Celula celulaAtualizada) {
        return repository.findById(id)
                .map(celula -> {
                    celula.setNome(celulaAtualizada.getNome());
                    celula.setEndereco(celulaAtualizada.getEndereco());
                    celula.setLat(celulaAtualizada.getLat());
                    celula.setLon(celulaAtualizada.getLon());
                    celula.setStatus(celulaAtualizada.getStatus());
                    celula.setTelefone(celulaAtualizada.getTelefone());
                    celula.setInstagram(celulaAtualizada.getInstagram());
                    celula.setDiaFuncionamento(celulaAtualizada.getDiaFuncionamento());
                    celula.setHorario(celulaAtualizada.getHorario());
                    return repository.save(celula);
                })
                .orElseThrow(() -> new RuntimeException("Célula não encontrada"));
    }

    // Rota DELETE: remover por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Célula não encontrada");
        }
        repository.deleteById(id);
    }
}

