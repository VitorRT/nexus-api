package br.com.ninus.rest.api.entity.dto.modelInputClass;

import br.com.ninus.rest.api.entity.ModelInputClass;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusDetailsRelation;
import br.com.ninus.rest.api.utils.constants.LearningObjective;
import br.com.ninus.rest.api.utils.constants.LearningObjectiveCode;
import br.com.ninus.rest.api.utils.constants.Axle;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Links;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelInputClassDetails {
    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "class")
    private ClassNinusDetailsRelation classFk;
    @JsonProperty(value = "axle")
    private Axle axle;
    @JsonProperty(value = "classroom")
    private String classroom;
    @JsonProperty(value = "type_teaching")
    private String typeTaching;
    @JsonProperty(value = "class_theme")
    private String classTheme;
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
    @JsonProperty(value = "duration_in_minutes")
    private Integer durationInMinutes;
    @JsonProperty(value = "createdAt")
    private LocalDateTime createdAt;
    @JsonProperty(value = "updatedAt")
    private LocalDateTime updatedAt;
    @JsonProperty(value = "links")
    private Links links;

    public ModelInputClassDetails(ModelInputClass input) {
        this.id = input.getId();
        this.classFk = ClassNinusDetailsRelation.toDetailsRelationClass(input.getClassNinusFk());
        this.axle = input.getAxle();
        this.classroom = input.getClassroom();
        this.typeTaching = input.getTypeTaching();
        this.classTheme = input.getClassTheme();
        this.learningObjective = input.getLearningObjective();
        this.learningObjectiveCode = input.getLearningObjectiveCode();
        this.ageGroup = input.getAgeGroup();
        this.classObjective = input.getClassObjective();
        this.fieldsExperience = input.getFieldsExperience();
        this.durationInMinutes = input.getDurationInMinutes();
        this.createdAt = input.getCreatedAt();
        this.updatedAt = input.getUpdatedAt();
        this.links = input.toEntityModel().getLinks();
    }

}
