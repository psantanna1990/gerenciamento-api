package br.com.psantanna1990.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetornoConsultaCepDTO {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;

}
