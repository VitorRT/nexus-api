package br.com.ninus.rest.api.domain.dto.modelClass;

import java.time.LocalDateTime;

import org.springframework.hateoas.Links;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.ninus.rest.api.domain.ModelClass;
import br.com.ninus.rest.api.domain.dto.modelInput.DetailsRelationModelInput;
import lombok.Data;

@Data
public class DetailsModelClass {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "model_input")
    private DetailsRelationModelInput modelInput;

    @JsonProperty(value = "introduction")
    private String introduction;
  
    @JsonProperty(value = "learning_objective")
    private String learningObjective;

    @JsonProperty(value = "deployment")
    private String deployment;

    @JsonProperty(value = "resources")
    private String resources;

    @JsonProperty(value = "adaptions")
    private String adaptions;
   
    @JsonProperty(value = "context_world")
    private String contextWorld;

    @JsonProperty(value = "valuing_culture_diversity")
    private String valuingCultureDiversity;

    @JsonProperty(value = "games")
    private String games;

    @JsonProperty(value = "family_participation")
    private String familyParticipation;

    @JsonProperty(value = "conclusion")
    private String conclusion;

    @JsonProperty(value = "final_remarks")
    private String finalRemarks;

    @JsonProperty(value = "goals")
    private String goals;

    @JsonProperty(value = "createdAt")
    private LocalDateTime createdAt;

    @JsonProperty(value = "updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty(value = "links")
    private Links links;


    public DetailsModelClass(ModelClass model) {
        this.id = model.getId();
        this.modelInput = DetailsRelationModelInput.toDetailsRelationModelInput(model.getModelInput());
        this.introduction = model.getIntroduction();
        this.learningObjective = model.getLearningObjective();
        this.deployment = model.getDeployment();
        this.resources = model.getResources();
        this.adaptions = model.getAdaptions();
        this.contextWorld = model.getContextWorld();
        this.valuingCultureDiversity = model.getValuingCultureDiversity();
        this.games = model.getGames();
        this.familyParticipation = model.getFamilyParticipation();
        this.conclusion = model.getConclusion();
        this.finalRemarks = model.getFinalRemarks();
        this.goals = model.getGoals();
        this.createdAt = model.getCreatedAt();
        this.updatedAt = model.getUpdatedAt();
        this.links = model.toEntityModel().getLinks();
    }

}
