package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.domain.Client;
import br.com.ninus.rest.api.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @GetMapping
    public PagedModel<EntityModel<Client>> findAll(@PageableDefault(size = 5) Pageable pageable) {
        return clientService.listGeneral(pageable);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Client>> create(@RequestBody @Valid Client client, BindingResult result) {
        Client c = clientService.insert(client);
        return ResponseEntity.created(c.toEntityModel().getRequiredLink("self").toUri()).body(c.toEntityModel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Client>> show(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.show(id).toEntityModel());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Client>> edit(@PathVariable Long id, @RequestBody @Valid Client client, BindingResult result) {
        return ResponseEntity.ok(clientService.update(id, client).toEntityModel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
