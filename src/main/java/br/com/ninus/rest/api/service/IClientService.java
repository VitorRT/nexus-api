package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.entity.Client;
import br.com.ninus.rest.api.entity.dto.client.ClientPostRequest;
import br.com.ninus.rest.api.entity.dto.client.ClientDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IClientService {
    PagedModel<EntityModel<ClientDetails>> listGeneral(Pageable pageable);
    ClientDetails show(Long id);
    ClientDetails insert(ClientPostRequest clientRequest);
    ClientDetails updateClientName(Long id, String name);
    void delete(Long id);
}
