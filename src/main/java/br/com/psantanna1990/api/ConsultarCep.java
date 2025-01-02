package br.com.psantanna1990.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.psantanna1990.dto.RetornoConsultaCepDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/cep/v2")
@RegisterRestClient(configKey = "brasil-api")
public interface ConsultarCep {

    @GET
    @Path("/{cep}")
    RetornoConsultaCepDTO consultarCep(String cep);

}
