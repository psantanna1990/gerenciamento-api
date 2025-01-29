package br.com.psantanna1990.enums;

public enum NivelEnum {

    INICIANTE(1), INTERMEDIARIO(2), AVANCADO(3), COMPETICAO(4);

    private final int nivel;

    NivelEnum(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

}
