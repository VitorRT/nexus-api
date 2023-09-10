package br.com.ninus.rest.api.entity.dto.modelInputClass;

import br.com.ninus.rest.api.entity.ModelInputClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModelInputClassDetailsRelation {
    private Long id;
    
    public static ModelInputClassDetailsRelation toDetailsRelationModelInput(ModelInputClass input) {
        return new ModelInputClassDetailsRelation(input.getId());
    }
}
