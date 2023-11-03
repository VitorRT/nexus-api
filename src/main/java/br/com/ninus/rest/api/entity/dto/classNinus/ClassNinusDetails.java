package br.com.ninus.rest.api.entity.dto.classNinus;

import br.com.ninus.rest.api.entity.ClassNinus;
import br.com.ninus.rest.api.entity.dto.client.ClientDetails;
import br.com.ninus.rest.api.utils.constants.CategorieClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.hateoas.Links;

@Data
public class ClassNinusDetails {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "client")
    private ClientDetails client;
    @JsonProperty(value = "class_name")
    private String className;
    @JsonProperty(value = "categorie")
    private CategorieClass categorie;


    @JsonProperty(value = "createdAt")
    private LocalDateTime createdAt;

    @JsonProperty(value = "updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty(value = "links")
    private Links links;


    public ClassNinusDetails(ClassNinus c) {
        this.id = c.getId();
        this.client = ClientDetails.toDetailsClient(c.getClient());
        this.className = c.getClassName();
        this.categorie = c.getCategorie();
        this.createdAt = c.getCreatedAt();
        this.updatedAt = c.getUpdatedAt();
        this.links = c.toEntityModel().getLinks();
    }
}
