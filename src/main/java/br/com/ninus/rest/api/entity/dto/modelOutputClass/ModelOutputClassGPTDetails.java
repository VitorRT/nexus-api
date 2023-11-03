package br.com.ninus.rest.api.entity.dto.modelOutputClass;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModelOutputClassGPTDetails {
    @JsonProperty("introduction")
    private String introduction;
    @JsonProperty("learningObjective")
    private String learningObjective;
    @JsonProperty("deployment")
    private String deployment;
    @JsonProperty("resources")
    private String resources;
    @JsonProperty("adaptions")
    private String adaptions;
    @JsonProperty("contextWorld")
    private String contextWorld;
    @JsonProperty("valuingCultureDiversity")
    private String valuingCultureDiversity;
    @JsonProperty("games")
    private String games;
    @JsonProperty("familyParticipation")
    private String familyParticipation;
    @JsonProperty("conclusion")
    private String conclusion;
    @JsonProperty("finalRemarks")
    private String finalRemarks;
    @JsonProperty("goals")
    private String goals;

    public ModelOutputClassGPTDetails() { }

    @JsonCreator
    public ModelOutputClassGPTDetails(@JsonProperty("introduction") String introduction,
                                      @JsonProperty("learningObjective") String learningObjective,
                                      @JsonProperty("deployment") String deployment,
                                      @JsonProperty("resources") String resources,
                                      @JsonProperty("adaptions") String adaptions,
                                      @JsonProperty("contextWorld") String contextWorld,
                                      @JsonProperty("valuingCultureDiversity") String valuingCultureDiversity,
                                      @JsonProperty("games") String games,
                                      @JsonProperty("familyParticipation") String familyParticipation,
                                      @JsonProperty("conclusion") String conclusion,
                                      @JsonProperty("finalRemarks") String finalRemarks,
                                      @JsonProperty("goals") String goals) {
        this.introduction = introduction;
        this.learningObjective = learningObjective;
        this.deployment = deployment;
        this.resources = resources;
        this.adaptions = adaptions;
        this.contextWorld = contextWorld;
        this.valuingCultureDiversity = valuingCultureDiversity;
        this.games = games;
        this.familyParticipation = familyParticipation;
        this.conclusion = conclusion;
        this.finalRemarks = finalRemarks;
        this.goals = goals;
    }

}
