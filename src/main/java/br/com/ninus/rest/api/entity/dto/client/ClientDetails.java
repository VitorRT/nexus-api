package br.com.ninus.rest.api.entity.dto.client;

import br.com.ninus.rest.api.controller.impl.ClientControllerImpl;
import br.com.ninus.rest.api.entity.Client;
import br.com.ninus.rest.api.utils.constants.SchoolType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Data
public class ClientDetails {
    private Long id;
    private String name;
    @JsonProperty(value = "school_type")
    private SchoolType schoolType;

    public ClientDetails(Long id, String name, SchoolType schoolType) {
        this.id = id;
        this.name = name;
        this.schoolType = schoolType;
    }

    public ClientDetails(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.schoolType = client.getSchoolType();
    }

    public static ClientDetails toDetailsClient(Client client) {
        return new ClientDetails(client.getId(), client.getName(), client.getSchoolType());
    }

    public EntityModel<ClientDetails> toEntityModel() {
        return EntityModel.of(this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientControllerImpl.class).show(this.id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientControllerImpl.class).delete(this.id)).withRel("delete"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientControllerImpl.class).findAll(Pageable.unpaged())).withRel("all"));
    }
}
