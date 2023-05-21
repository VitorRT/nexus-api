package br.com.ninus.rest.api.domain;

import br.com.ninus.rest.api.utils.constants.LearningObjective;
import br.com.ninus.rest.api.utils.constants.LearningObjectiveCode;
import br.com.ninus.rest.api.controller.ModelInputController;
import br.com.ninus.rest.api.utils.constants.Axle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Entity
@Table(name = "model_input")
@Data
public class ModelInput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "class_fk")
    @JsonProperty(value = "class")
    @NotNull(message = "o objeto class não pode ser nulo. Coloque a chave estrangeira no objeto.")
    private Class classFk;

    @OneToOne(mappedBy = "modelInput", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private ModelClass modelClass;

    @Column(nullable = false, length = 12)
    @NotNull(message = "o eixo não pode ser vazio ou nulo.")
    @Enumerated(EnumType.STRING)
    private Axle axle;

    @Column(nullable = false, length = 30)
    @NotBlank(message = "a turma não pode ser vazia ou nula.")
    private String classroom;

    @Column(name = "type_teaching", nullable = false, length = 40)
    @JsonProperty(value = "type_teaching")
    @NotBlank(message = "o tipo de ensino não pode ser vazio ou nulo.")
    private String typeTaching;

    @Column(name = "learning_objective", nullable = false, length = 30)
    @JsonProperty(value = "learning_objective")
    @NotNull(message = "o objetivo de aprendizagem não pode ser vazio ou nulo.")
    @Enumerated(EnumType.STRING)
    private LearningObjective learningObjective;

    @Column(name = "learning_objective_code", nullable = false, length = 8)
    @JsonProperty(value = "learning_objective_code")
    @Enumerated(EnumType.STRING)
    private LearningObjectiveCode learningObjectiveCode;

    @Column(name = "age_group", nullable = false, length = 80)
    @JsonProperty(value = "age_group")
    private String ageGroup;

    @Column(name = "class_objective", nullable = false)
    @JsonProperty(value = "class_objective")
    @Lob
    @NotBlank(message = "o objetivo de aula não pode ser vazio ou nulo.")
    private String classObjective;

    @Column(name = "fields_experience", nullable = false, length = 50)
    @JsonProperty(value = "fields_experience")
    @NotBlank(message = "o campo de experiência não pode ser vazio ou nulo.")
    private String fieldsExperience;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    @JsonIgnore
    private Boolean active;

    public ModelInput() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    public EntityModel<ModelInput> toEntityModel() {
        return EntityModel.of(this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ModelInputController.class).show(this.id))
                        .withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ModelInputController.class).delete(this.id))
                        .withRel("delete"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ModelInputController.class).findAll(Pageable.unpaged()))
                        .withRel("all"));
    }
}
