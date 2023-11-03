package br.com.ninus.rest.api.entity.dto.modelInputClass;

import br.com.ninus.rest.api.utils.constants.Axle;
import br.com.ninus.rest.api.utils.constants.LearningObjective;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelInputClassPostRequest {
    @NotNull(message = "class ninus id is mandatory.")
    @JsonProperty(value = "class_ninus_id")
    private Long classNinusId;
    @NotNull(message = "axle is mandatory.")
    private Axle axle;
    @NotBlank(message = "class room is mandatory.")
    @JsonProperty(value = "class_room")
    private String classRoom;
    @NotBlank(message = "type teaching is mandatory.")
    @JsonProperty(value = "type_teaching")
    private String typeTeaching;
    @NotNull(message = "duration in minutes is mandatory.")
    @JsonProperty(value = "duration_in_minutes")
    private Integer durationInMinutes;
    @NotBlank(message = "didadic resources is mandatory.")
    @JsonProperty(value = "didatic_resources")
    private String didaticResources;
    @NotNull(message = "learning objective is mandatory")
    @JsonProperty(value = "learning_objective")
    private LearningObjective learningObjective;
    @NotBlank(message = "class objetivo is mandatory.")
    @JsonProperty(value = "class_objective")
    private String classObjective;
    @NotBlank(message = "class theme is mandatory.")
    @JsonProperty(value = "class_theme")
    private String classTheme;
    @NotBlank(message = "fields experience is mandatory.")
    @JsonProperty(value = "fields_experience")
    private String fieldsExperience;

}
