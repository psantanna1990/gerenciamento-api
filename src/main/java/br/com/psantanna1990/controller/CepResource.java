package br.com.psantanna1990.controller;

import java.util.Objects;

import org.jboss.resteasy.reactive.RestResponse;

import br.com.psantanna1990.dto.RetornoConsultaCepDTO;
import br.com.psantanna1990.services.CepService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/cep")
public class CepController {

    private CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GET
    @Path("/{cep}")
    public RestResponse<RetornoConsultaCepDTO> consultarCep(String cep) {

        if (Objects.nonNull(cep) && cep.length() != 8) {
            return RestResponse.serverError();
        }

        return RestResponse.ok(cepService.consultarCep(cep));

    }

}
