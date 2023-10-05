package br.com.ninus.rest.api.service.impl;

import br.com.ninus.rest.api.entity.Client;
import br.com.ninus.rest.api.entity.dto.feed.FeedClassesResponse;
import br.com.ninus.rest.api.repository.ClientRepository;
import br.com.ninus.rest.api.service.IFeedClassesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedClassesServiceImpl implements IFeedClassesService {
    private ClientRepository clientRepository;

    @Deprecated
    public FeedClassesServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<FeedClassesResponse> listFeedByClientId(Long clientId) {
        var client = getClientById(clientId);
        return clientRepository.getFeedClassesByClientId(client.getId());
    }

    private Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Id de usuário inválido.")
        );
    }
}
