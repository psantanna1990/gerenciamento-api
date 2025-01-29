package br.com.psantanna1990.enums;

public enum DiaSemanaEnum {
    SEGUNDA(1), TERCA(2), QUARTA(3), QUINTA(4), SEXTA(5), SABADO(6), DOMINGO(7);

    private final int diaSemana;

    DiaSemanaEnum(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getDiaSemana() {
        return diaSemana;
    }
}
