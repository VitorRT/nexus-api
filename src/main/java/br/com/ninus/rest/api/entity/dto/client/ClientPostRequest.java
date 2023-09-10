package br.com.ninus.rest.api.entity.dto.client;

import br.com.ninus.rest.api.utils.constants.SchoolType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientPostRequest {
    @NotBlank(message = "name is mandatory.")
    @Size(min = 4, max = 40, message = "the name must have a minimum of 4 characters and a maximum of 40 characters.")
    public String name;
    @NotBlank(message = "email is mandatory.")
    @Email(message = "the value entered must be a valid email.")
    public String email;
    @NotBlank(message = "password is mandatory.")
    @Size(min = 8, message = "password must be at least 8 characters long.")
    public String password;
    @NotNull(message = "school type is mandatory.")
    @JsonProperty(value = "school_type")
    public SchoolType schoolType;
}
