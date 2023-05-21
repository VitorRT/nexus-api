package br.com.ninus.rest.api.domain.dto.client;

import br.com.ninus.rest.api.domain.Client;
import br.com.ninus.rest.api.utils.constants.SchoolType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DetailsClient {
    private Long id;
    private String name;
    @JsonProperty(value = "school_type")
    private SchoolType schoolType;

    public DetailsClient(Long id, String name, SchoolType schoolType) {
        this.id = id;
        this.name = name;
        this.schoolType = schoolType;
    }

    public static DetailsClient toDetailsClient(Client client) {
        return new DetailsClient(client.getId(), client.getName(), client.getSchoolType());
    }
}
