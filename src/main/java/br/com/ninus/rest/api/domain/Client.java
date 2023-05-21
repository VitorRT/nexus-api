package br.com.ninus.rest.api.domain;

import br.com.ninus.rest.api.utils.constants.SchoolType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import br.com.ninus.rest.api.controller.ClientController;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Class> classes;

    @Column(length = 80, nullable = false)
    @NotBlank(message = "o nome não pode ser vazio ou nulo.")
    private String name;

    @Column(length = 80, nullable = false, unique = true)
    @NotBlank(message = "o email não pode ser vazio ou nulo.")
    private String email;

    @Column(length = 150, nullable = false)
    @NotBlank(message = "a senha não pode ser vazia ou nula.")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "school_type",length = 40, nullable = false)
    @NotNull(message = "o tipo de escola(school_type) não pode ser nulo.")
    @JsonProperty(value = "school_type")
    private SchoolType schoolType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    @JsonIgnore
    private Boolean active;

    public Client() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    /* Um dia irei usar este método ;) */
    public void deactivateAccount() {
        this.active = false;
    }



    public EntityModel<Client> toEntityModel() {
        return EntityModel.of(this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).show(this.id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).delete(this.id)).withRel("delete"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).findAll(Pageable.unpaged())).withRel("all"));
    }


}
