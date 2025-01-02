package br.com.psantanna1990.services;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.psantanna1990.api.ConsultarCep;
import br.com.psantanna1990.dto.RetornoConsultaCepDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CepService {


    // Usar injeção de dependencias utilizando o construtor
    private final ConsultarCep consultarCepHttpService;

    public CepService(@RestClient ConsultarCep consultarCepHttpService) {
        this.consultarCepHttpService = consultarCepHttpService;
    }

    public RetornoConsultaCepDTO consultarCep(String cep) {
        return consultarCepHttpService.consultarCep(cep);
    }
}