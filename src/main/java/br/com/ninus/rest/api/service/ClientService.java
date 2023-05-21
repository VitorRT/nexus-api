package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.domain.Client;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ClientRepository;
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
public class ClientService {

    private final ClientRepository clientRepository;
    private final PagedResourcesAssembler<Client> assembler;


    public PagedModel<EntityModel<Client>> listGeneral(Pageable pageable) {
        Page<Client> clients = clientRepository.findAllByActiveTrue(pageable);
        return assembler.toModel(clients);
    }

    public Client show(Long id) {
        return getClient(id);
    }

    public Client insert(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    public Client update(Long id, Client client) {
        getClient(id);
        client.setUpdatedAt(LocalDateTime.now());
        client.setId(id);
        return clientRepository.saveAndFlush(client);
    }

    public void delete(Long id) {
        Client clientFound = clientRepository.findById(id).get();
        clientRepository.delete(clientFound);
    }



    private Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
          new RestNotFoundException("Nenhum cliente com o id [ " + id + " ] foi encontrado.")
        );
    }
}
