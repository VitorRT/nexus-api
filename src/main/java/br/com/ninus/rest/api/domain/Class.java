package br.com.ninus.rest.api.domain;

import br.com.ninus.rest.api.controller.ClassController;
import br.com.ninus.rest.api.utils.constants.CategorieClass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Entity
@Table(name = "class")
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_fk")
    @NotNull(message = "o objeto client não pode ser nulo. Coloque a chave estrangeira no objeto.")
    private Client client;

    @OneToOne(mappedBy = "classFk", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private ModelInput modelInput;

    @Column(name = "class_name", nullable = false)
    @NotBlank(message = "o nome de aula não pode ser vazio ou nulo.")
    @JsonProperty(value = "class_name")
    private String className;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "a categoria de aula não pode ser vazia ou nula.")
    @Column(nullable = false)
    private CategorieClass categorie;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "life_time_date")
    @Temporal(TemporalType.DATE)
    private LocalDate lifeTimeDate;

    @JsonIgnore
    private Boolean marked;
    
    @Column(nullable = false)
    private Boolean active;

    public Class() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.categorie = CategorieClass.PROGRESS;
        this.marked = false;
        this.active = true;
    }

    public void finishClass() {
        LocalDate currentDate = LocalDate.now();
        LocalDate newDate = currentDate.plusDays(3);
        this.categorie = CategorieClass.FINISHED;
        this.marked = true;
        this.lifeTimeDate = newDate;
    }

    public void addToFavorite() {
        this.categorie = CategorieClass.FAVORITE;
        this.marked = false;
    }

    public EntityModel<Class> toEntityModel() {
        return EntityModel.of(this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClassController.class).show(this.id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClassController.class).delete(this.id))
                        .withRel("delete"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ClassController.class).findAllInProgress(Pageable.unpaged()))
                        .withRel("all-progress"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ClassController.class).findAllInFinished(Pageable.unpaged()))
                        .withRel("all-finished"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ClassController.class).findAllInFavorite(Pageable.unpaged()))
                        .withRel("all-favorite"));
    }

}
