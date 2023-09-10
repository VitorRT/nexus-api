package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.entity.dto.client.ClientDetails;
import br.com.ninus.rest.api.entity.dto.client.ClientPostRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IClientController {
    PagedModel<EntityModel<ClientDetails>> findAll(@PageableDefault(size = 5) Pageable pageable);
    ResponseEntity<EntityModel<ClientDetails>> create(@RequestBody @Valid ClientPostRequest request);
    ResponseEntity<EntityModel<ClientDetails>> show(@PathVariable Long id);
    ResponseEntity<EntityModel<ClientDetails>> updateClientName(
            @PathVariable Long id,
                @RequestParam(name = "name")
                @NotBlank(message = "plase enter a valid name.")
                @Size(min = 4, max = 40, message = "the name must have a minimum of 4 characters and a maximum of 40 characters.")
                String name
    );
    ResponseEntity<Void> delete(@PathVariable Long id);
}
