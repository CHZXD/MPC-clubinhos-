package com.clubinho.api_mapa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Celula salvar(@RequestBody com.clubinho.api_mapa.Dto.CelulaCreateUpdateDTO dto) {
        Celula celula = new Celula();
        celula.setNome(dto.getNome());
        celula.setEndereco(dto.getEndereco());
        celula.setLat(dto.getLat());
        celula.setLon(dto.getLon());
        celula.setStatus(dto.getStatus());
        celula.setTelefone(dto.getTelefone());
        celula.setInstagram(dto.getInstagram());

        // compatibilidade com seu index.html (string antiga)
        mapearHorarios(dto, celula);

        return repository.save(celula);
    }

    // Rota PUT: atualizar por ID
    @PutMapping("/{id}")
    public Celula atualizar(@PathVariable Long id, @RequestBody com.clubinho.api_mapa.Dto.CelulaCreateUpdateDTO dto) {
        return repository.findById(id)
                .map(celula -> {
                    celula.setNome(dto.getNome());
                    celula.setEndereco(dto.getEndereco());
                    celula.setLat(dto.getLat());
                    celula.setLon(dto.getLon());
                    celula.setStatus(dto.getStatus());
                    celula.setTelefone(dto.getTelefone());
                    celula.setInstagram(dto.getInstagram());

                    mapearHorarios(dto, celula);

                    return repository.save(celula);
                })
                .orElseThrow(() -> new RuntimeException("Célula não encontrada"));
    }

    private void mapearHorarios(com.clubinho.api_mapa.Dto.CelulaCreateUpdateDTO dto, Celula celula) {
        System.out.println("BACKEND: mapearHorarios chamado");
        System.out.println("BACKEND: dto.getHorarios() = " + dto.getHorarios());
        
        if (dto.getHorarios() == null || dto.getHorarios().isEmpty()) {
            System.out.println("BACKEND: Horarios vazio/nulo. Mantendo valores existentes no entity.");

            if ((celula.getDiaFuncionamento() == null || celula.getDiaFuncionamento().isBlank()) &&
                    (celula.getHorario() == null || celula.getHorario().isBlank()) &&
                    celula.getHorarios() != null && !celula.getHorarios().isBlank()) {

                String diaFunc = null;
                String hrs = null;

                try {
                    String[] itens = celula.getHorarios().split(";");
                    StringBuilder diasSb = new StringBuilder();
                    StringBuilder horasSb = new StringBuilder();

                    for (String item : itens) {
                        if (item == null || item.isBlank()) continue;
                        String[] partes = item.split("\\|");
                        if (partes.length != 2) continue;
                        String dia = partes[0] != null ? partes[0].trim() : "";
                        String hora = partes[1] != null ? partes[1].trim() : "";
                        if (!dia.isBlank() && !hora.isBlank()) {
                            if (diasSb.length() > 0) diasSb.append(",");
                            if (horasSb.length() > 0) horasSb.append(",");
                            diasSb.append(dia);
                            horasSb.append(hora);
                        }
                    }

                    diaFunc = diasSb.length() > 0 ? diasSb.toString() : null;
                    hrs = horasSb.length() > 0 ? horasSb.toString() : null;
                } catch (Exception e) {
                    System.out.println("BACKEND: Falha ao reconstituir campos a partir de celula.horarios: " + e.getMessage());
                }

                celula.setDiaFuncionamento(diaFunc);
                celula.setHorario(hrs);
            }

            return;
        }

        System.out.println("BACKEND: Processando " + dto.getHorarios().size() + " horarios");

        String diasFunc = dto.getHorarios().stream()
                .map(h -> h == null ? null : h.getDia())
                .filter(x -> x != null && !x.isBlank())
                .reduce((a, b) -> a + "," + b)
                .orElse(null);

        String hrsFunc = dto.getHorarios().stream()
                .map(h -> h == null ? null : h.getHorario())
                .filter(x -> x != null && !x.isBlank())
                .reduce((a, b) -> a + "," + b)
                .orElse(null);

        System.out.println("BACKEND: diasFunc = " + diasFunc);
        System.out.println("BACKEND: hrsFunc = " + hrsFunc);

        celula.setDiaFuncionamento(diasFunc);
        celula.setHorario(hrsFunc);

        String hrsStr = dto.getHorarios().stream()
                .filter(h -> h != null)
                .map(h -> (h.getDia() == null ? "" : h.getDia()) + "|" + (h.getHorario() == null ? "" : h.getHorario()))
                .reduce((a, b) -> a + ";" + b)
                .orElse(null);

        System.out.println("BACKEND: hrsStr = " + hrsStr);
        celula.setHorarios(hrsStr);
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

