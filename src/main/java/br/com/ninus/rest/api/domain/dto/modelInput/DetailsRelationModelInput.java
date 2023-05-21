package br.com.ninus.rest.api.domain.dto.modelInput;

import br.com.ninus.rest.api.domain.ModelInput;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsRelationModelInput {
    private Long id;
    
    public static DetailsRelationModelInput toDetailsRelationModelInput(ModelInput input) {
        return new DetailsRelationModelInput(input.getId());
    }
}
