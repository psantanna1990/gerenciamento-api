package br.com.psantanna1990.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {

    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private Character sexo;
    private Integer escolaridade;
    private String telefone;
    private String email;
}
