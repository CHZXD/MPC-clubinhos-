package com.clubinho.api_mapa.Dto;

import java.util.List;

public class CelulaCreateUpdateDTO {
    private String nome;
    private String endereco;
    private Double lat;
    private Double lon;
    private String status;
    private String telefone;
    private String instagram;

    // Novo: múltiplos dias/horários
    private List<HorarioFuncionamentoDTO> horarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public List<HorarioFuncionamentoDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioFuncionamentoDTO> horarios) {
        this.horarios = horarios;
    }
}

