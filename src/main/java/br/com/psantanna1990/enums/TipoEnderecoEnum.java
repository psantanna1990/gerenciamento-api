package br.com.psantanna1990.enums;

public enum TipoEnderecoEnum {
    RESIDENCIAL(0),
    COMERCIAL(1),
    OUTRO(2);

    private final int value;

    TipoEnderecoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}