package br.com.psantanna1990.enums;

public enum ModalidadeEnum {
    JIU_JITSU(1), MUAY_THAI(2), JUDO(3);

    private final int modalidade;

    ModalidadeEnum(int modalidade) {
        this.modalidade = modalidade;
    }

    public int getModalidade() {
        return modalidade;
    }
}
