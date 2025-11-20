CREATE TABLE aluno (
    id BIGSERIAL PRIMARY KEY,
    nome_completo VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo CHAR(1) NOT NULL
);

create sequence Aluno_SEQ start with 1 increment by 50;



ALTER TABLE endereco
    ADD COLUMN aluno_id BIGINT,
    ADD CONSTRAINT fk_endereco_aluno
        FOREIGN KEY (aluno_id)
        REFERENCES aluno(id)
        ON DELETE SET NULL;

