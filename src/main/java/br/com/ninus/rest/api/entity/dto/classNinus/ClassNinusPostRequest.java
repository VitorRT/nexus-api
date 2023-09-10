package br.com.ninus.rest.api.entity.dto.classNinus;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassNinusPostRequest {
    @NotNull(message = "client id is mandatory.")
    @JsonProperty(value = "client_id")
    private Long clientId;
    @NotBlank(message = "class name is mandatory.")
    @JsonProperty(value = "class_name")
    @Size(min = 4, max = 40, message = "The class name must have a minimum of 4 characters and a maximum of 40 characters.")
    private String className;
}
