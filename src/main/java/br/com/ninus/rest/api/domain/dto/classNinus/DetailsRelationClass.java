package br.com.ninus.rest.api.domain.dto.classNinus;

import br.com.ninus.rest.api.domain.Class;
import br.com.ninus.rest.api.utils.constants.CategorieClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetailsRelationClass {
    private Long id;
    private String className;
    private CategorieClass categorie;

    public static DetailsRelationClass toDetailsRelationClass(Class c) {
        return new DetailsRelationClass(c.getId(), c.getClassName(), c.getCategorie());
    }

}
