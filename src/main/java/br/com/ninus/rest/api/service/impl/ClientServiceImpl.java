package br.com.ninus.rest.api.service.impl;

import br.com.ninus.rest.api.entity.Client;
import br.com.ninus.rest.api.entity.dto.client.ClientDetails;
import br.com.ninus.rest.api.entity.dto.client.ClientPostRequest;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ClientRepository;
import br.com.ninus.rest.api.service.IClientService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;
    private final PagedResourcesAssembler<ClientDetails> assembler;


    @Override
    public PagedModel<EntityModel<ClientDetails>> listGeneral(Pageable pageable) {
        Page<ClientDetails> clients = clientRepository.findAllByActiveTrue(pageable).map(ClientDetails::new);
        return assembler.toModel(clients);
    }

    @Override
    public ClientDetails show(Long id) {
        return new ClientDetails(getClient(id));
    }

    @Override
    public ClientDetails insert(ClientPostRequest client) {
        return new ClientDetails(clientRepository.saveAndFlush(new Client(client)));
    }

    @Override
    public ClientDetails updateClientName(Long id, String name) {
        Client client = getClient(id);
        client.setUpdatedAt(LocalDateTime.now());
        client.setName(name);
        return new ClientDetails(clientRepository.saveAndFlush(client));
    }

    @Override
    public void delete(Long id) {
        Client clientFound = getClient(id);
        clientRepository.delete(clientFound);
    }



    private Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
          new RestNotFoundException("Nenhum cliente com o id [ " + id + " ] foi encontrado.")
        );
    }
}
