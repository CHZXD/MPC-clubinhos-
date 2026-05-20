package com.clubinho.api_mapa;

public class HorarioFuncionamento {
    private String dia;
    private String horario;

    public HorarioFuncionamento() {}

    public HorarioFuncionamento(String dia, String horario) {
        this.dia = dia;
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}

