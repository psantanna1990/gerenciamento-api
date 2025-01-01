package br.com.psantanna1990.services.http;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaCepRetornoDTO {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;

}
