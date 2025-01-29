package br.com.psantanna1990.enums;

public enum FrequenciaEnum {
    SEMANAL(1), QUINZENAL(2), MENSAL(3);

    private final int frequencia;

    FrequenciaEnum(int frequencia) {
        this.frequencia = frequencia;
    }

    public int getFrequencia() {
        return frequencia;
    }
}
