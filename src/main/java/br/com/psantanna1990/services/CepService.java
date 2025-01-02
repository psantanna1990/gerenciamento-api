package br.com.psantanna1990.services;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.psantanna1990.dto.RetornoConsultaCepDTO;
import br.com.psantanna1990.services.http.ConsultarCepHttpService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CepService {


    // Usar injeção de dependencias utilizando o construtor
    private final ConsultarCepHttpService consultarCepHttpService;

    public CepService(@RestClient ConsultarCepHttpService consultarCepHttpService) {
        this.consultarCepHttpService = consultarCepHttpService;
    }

    public RetornoConsultaCepDTO consultarCep(String cep) {
        return consultarCepHttpService.consultarCep(cep);
    }
}