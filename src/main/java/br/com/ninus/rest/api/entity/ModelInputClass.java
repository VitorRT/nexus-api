package br.com.ninus.rest.api.entity;

import br.com.ninus.rest.api.controller.impl.ModelInputClassControllerImpl;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassPostRequest;
import br.com.ninus.rest.api.utils.constants.Axle;
import br.com.ninus.rest.api.utils.constants.LearningObjective;
import br.com.ninus.rest.api.utils.constants.LearningObjectiveCode;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "model_input")
@Data
public class ModelInputClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "class_fk")
    private ClassNinus classNinusFk;

    @OneToOne(mappedBy = "modelInputClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private ModelOutputClass modelOutputClass;

    @Column(nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private Axle axle;

    @Column(nullable = false, length = 30)
    private String classroom;

    @Column(name = "type_teaching", nullable = false, length = 40)
    private String typeTaching;

    @Column(name = "duration_in_minutes", nullable = false)
    private Integer durationInMinutes;

    @Column(name = "didatic_resources")
    private String didaticResources;

    @Column(name = "learning_objective", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private LearningObjective learningObjective;

    @Column(name = "learning_objective_code", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private LearningObjectiveCode learningObjectiveCode;

    @Column(name = "age_group", nullable = false, length = 80)
    private String ageGroup;

    @Column(name = "class_objective", nullable = false)
    @Lob
    private String classObjective;

    @Column(name = "class_name", nullable = false)
    @Lob
    private String classTheme;

    @Column(name = "fields_experience", nullable = false, length = 50)
    private String fieldsExperience;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean active;

    public ModelInputClass() {
        this.prepare();
    }

    public ModelInputClass(ModelInputClassPostRequest request) {
        this.prepare();
        this.axle = request.getAxle();
        this.classroom = request.getClassRoom();
        this.typeTaching = request.getTypeTeaching();
        this.durationInMinutes = request.getDurationInMinutes();
        this.didaticResources = request.getDidaticResources();
        this.learningObjective = request.getLearningObjective();
        this.classObjective = request.getClassObjective();
        this.classTheme = request.getClassTheme();
        this.fieldsExperience = request.getFieldsExperience();
    }

    private void prepare() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    public EntityModel<ModelInputClass> toEntityModel() {
        return EntityModel.of(this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ModelInputClassControllerImpl.class).show(this.id))
                        .withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ModelInputClassControllerImpl.class).delete(this.id))
                        .withRel("delete"),
                WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(ModelInputClassControllerImpl.class).findAll(Pageable.unpaged()))
                        .withRel("all"));
    }
}
