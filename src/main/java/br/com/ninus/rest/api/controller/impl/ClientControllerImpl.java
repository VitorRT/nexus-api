package br.com.ninus.rest.api.controller.impl;

import br.com.ninus.rest.api.controller.IClientController;
import br.com.ninus.rest.api.entity.dto.client.ClientDetails;
import br.com.ninus.rest.api.entity.dto.client.ClientPostRequest;
import br.com.ninus.rest.api.service.IClientService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/client")
public class ClientControllerImpl implements IClientController {
    private IClientService clientService;

    public ClientControllerImpl(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public PagedModel<EntityModel<ClientDetails>> findAll(Pageable pageable) {
        return clientService.listGeneral(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ClientDetails>> create(ClientPostRequest request) {
        ClientDetails c = clientService.insert(request);
        return ResponseEntity.created(c.toEntityModel().getRequiredLink("self").toUri()).body(c.toEntityModel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ClientDetails>> show(Long id) {
        return ResponseEntity.ok(clientService.show(id).toEntityModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ClientDetails>> updateClientName(Long id, String name) {
        return ResponseEntity.ok(clientService.updateClientName(id, name).toEntityModel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
