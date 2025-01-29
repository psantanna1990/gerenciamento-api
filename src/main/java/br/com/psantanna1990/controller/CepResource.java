package br.com.psantanna1990.controller;

import java.util.Objects;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.reactive.RestResponse;

import br.com.psantanna1990.dto.RetornoConsultaCepDTO;
import br.com.psantanna1990.services.CepService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cep")
public class CepResource {

    private CepService cepService;

    public CepResource(CepService cepService) {
        this.cepService = cepService;
    }

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Retorna as informações de endereço para um determinado CEP.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Consulta realizada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RetornoConsultaCepDTO.class))),
            @APIResponse(responseCode = "500", description = "Erro no servidor")
    })
    public RestResponse<RetornoConsultaCepDTO> consultarCep(String cep) {

        if (Objects.nonNull(cep) && cep.length() != 8) {
            return RestResponse.serverError();
        }

        return RestResponse.ok(cepService.consultarCep(cep));

    }

}
