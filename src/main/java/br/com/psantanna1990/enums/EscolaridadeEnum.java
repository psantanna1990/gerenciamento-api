package br.com.psantanna1990.enums;

public enum EscolaridadeEnum {
    FUNDAMENTAL(1), MEDIO(2), SUPERIOR(3), POS_GRADUACAO(4), MESTRADO(5), DOUTORADO(6);

    private final int escolaridade;

    EscolaridadeEnum(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    public int getEscolaridade() {
        return escolaridade;
    }
}
