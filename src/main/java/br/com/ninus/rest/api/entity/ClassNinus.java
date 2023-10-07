package br.com.ninus.rest.api.entity;

import br.com.ninus.rest.api.controller.impl.ClassNinusControllerImpl;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusPostRequest;
import br.com.ninus.rest.api.utils.constants.CategorieClass;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Entity
@Table(name = "class")
@Data
@EqualsAndHashCode(of = {"id"})
public class ClassNinus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_fk")
    private Client client;

    @OneToOne(mappedBy = "classNinusFk", cascade = CascadeType.ALL, orphanRemoval = true)
    private ModelInputClass modelInputClass;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategorieClass categorie;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "life_time_date")
    @Temporal(TemporalType.DATE)
    private LocalDate lifeTimeDate;

    private Boolean marked;
    
    @Column(nullable = false)
    private Boolean active;

    public ClassNinus() {
        this.prepare();
    }

    public ClassNinus(ClassNinusPostRequest request) {
        this.prepare();
        this.className = request.getClassName();
    }

    private void prepare() {
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

    public EntityModel<ClassNinus> toEntityModel() {
        return EntityModel.of(this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClassNinusControllerImpl.class).show(this.id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClassNinusControllerImpl.class).delete(this.id))
                        .withRel("delete"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ClassNinusControllerImpl.class).findAllInProgress(Pageable.unpaged()))
                        .withRel("all-progress"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ClassNinusControllerImpl.class).findAllInFinished(Pageable.unpaged()))
                        .withRel("all-finished"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ClassNinusControllerImpl.class).findAllInFavorite(Pageable.unpaged()))
                        .withRel("all-favorite"));
    }

}
