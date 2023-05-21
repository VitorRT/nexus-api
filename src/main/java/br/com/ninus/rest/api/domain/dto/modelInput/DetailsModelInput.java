package br.com.ninus.rest.api.domain.dto.modelInput;

import br.com.ninus.rest.api.domain.ModelInput;
import br.com.ninus.rest.api.domain.dto.classNinus.DetailsRelationClass;
import br.com.ninus.rest.api.utils.constants.LearningObjective;
import br.com.ninus.rest.api.utils.constants.LearningObjectiveCode;
import br.com.ninus.rest.api.utils.constants.Axle;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

import org.springframework.hateoas.Links;

public class DetailsModelInput {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "class")
    private DetailsRelationClass classFk;
    @JsonProperty(value = "axle")
    private Axle axle;
    @JsonProperty(value = "classroom")
    private String classroom;
    @JsonProperty(value = "type_teaching")
    private String typeTaching;
    @JsonProperty(value = "learning_objective")
    private LearningObjective learningObjective;
    @JsonProperty(value = "learning_objective_code")
    private LearningObjectiveCode learningObjectiveCode;
    @JsonProperty(value = "age_group")
    private String ageGroup;
    @JsonProperty(value = "class_objective")
    private String classObjective;
    @JsonProperty(value = "fields_experience")
    private String fieldsExperience;
    @JsonProperty(value = "createdAt")
    private LocalDateTime createdAt;
    @JsonProperty(value = "updatedAt")
    private LocalDateTime updatedAt;
    @JsonProperty(value = "links")
    private Links links;

    public DetailsModelInput (ModelInput input) {
        this.id = input.getId();
        this.classFk = DetailsRelationClass.toDetailsRelationClass(input.getClassFk());
        this.axle = input.getAxle();
        this.classroom = input.getClassroom();
        this.typeTaching = input.getTypeTaching();
        this.learningObjective = input.getLearningObjective();
        this.learningObjectiveCode = input.getLearningObjectiveCode();
        this.ageGroup = input.getAgeGroup();
        this.classObjective = input.getClassObjective();
        this.fieldsExperience = input.getFieldsExperience();
        this.createdAt = input.getCreatedAt();
        this.updatedAt = input.getUpdatedAt();
        this.links = input.toEntityModel().getLinks();
    }

}
