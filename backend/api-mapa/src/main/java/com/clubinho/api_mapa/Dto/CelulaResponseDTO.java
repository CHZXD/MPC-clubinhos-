package com.clubinho.api_mapa.Dto;

import java.util.List;

import com.clubinho.api_mapa.Celula;

public class CelulaResponseDTO {
    private Long id;
    private String nome;
    private String endereco;
    private Double lat;
    private Double lon;
    private String status;
    private String telefone;
    private String instagram;
    private String diaFuncionamento;
    private String horario;

    public static CelulaResponseDTO fromEntity(Celula c) {
        CelulaResponseDTO dto = new CelulaResponseDTO();
        dto.id = c.getId();
        dto.nome = c.getNome();
        dto.endereco = c.getEndereco();
        dto.lat = c.getLat();
        dto.lon = c.getLon();
        dto.status = c.getStatus();
        dto.telefone = c.getTelefone();
        dto.instagram = c.getInstagram();
        dto.diaFuncionamento = c.getDiaFuncionamento();
        dto.horario = c.getHorario();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getStatus() {
        return status;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getDiaFuncionamento() {
        return diaFuncionamento;
    }

    public String getHorario() {
        return horario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setDiaFuncionamento(String diaFuncionamento) {
        this.diaFuncionamento = diaFuncionamento;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

