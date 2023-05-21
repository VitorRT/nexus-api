package br.com.ninus.rest.api.domain.dto.classNinus;

import br.com.ninus.rest.api.domain.Class;
import br.com.ninus.rest.api.domain.dto.client.DetailsClient;
import br.com.ninus.rest.api.utils.constants.CategorieClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.hateoas.Links;

@Data
public class DetailsClass {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "client")
    private DetailsClient client;
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


    public DetailsClass(Class c) {
        this.id = c.getId();
        this.client = DetailsClient.toDetailsClient(c.getClient());
        this.className = c.getClassName();
        this.categorie = c.getCategorie();
        this.createdAt = c.getCreatedAt();
        this.updatedAt = c.getUpdatedAt();
        this.links = c.toEntityModel().getLinks();
    }
}
