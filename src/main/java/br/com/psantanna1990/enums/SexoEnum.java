package br.com.psantanna1990.enums;

public enum SexoEnum {
    FEMININO('f'), MASCULINO('m');

    private final char estadoCivil;

    SexoEnum(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }
}
