package br.com.ninus.rest.api.domain.dto.client;

import br.com.ninus.rest.api.utils.constants.SchoolType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShowClient {
    @JsonProperty(value = "class_name")
    private String className;
    @JsonProperty(value = "school_type")
    private SchoolType schoolType;
}
