package com.clubinho.api_mapa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "celulas") // Nome da tabela que será criada no banco de dados
public class Celula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco de dados vai gerar o ID automaticamente (1, 2, 3...)
    private Long id;

    private String nome;
    private String endereco;
    
    // Usamos Double porque coordenadas geográficas exigem muita precisão decimal
    private Double lat;
    private Double lon;
    
    private String status;
    private String telefone;
    private String instagram;
    // Campos antigos (mantidos para compatibilidade com o index.html)
    private String diaFuncionamento;
    private String horario;

    // Novo: múltiplos dias/horários
    private String horarios;

    // Construtor vazio (Obrigatório para o Spring Boot e o JPA funcionarem nos bastidores)
    public Celula() {
        // JPA e Spring precisam de um construtor sem argumentos para desserializar
    }

    // --------------------------------------------------------
    // Getters e Setters (Para acessar e modificar os atributos)
    // --------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDiaFuncionamento() {
        return diaFuncionamento;
    }

    public void setDiaFuncionamento(String diaFuncionamento) {
        this.diaFuncionamento = diaFuncionamento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

}