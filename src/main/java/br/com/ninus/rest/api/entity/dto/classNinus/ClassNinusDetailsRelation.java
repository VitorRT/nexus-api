package br.com.ninus.rest.api.entity.dto.classNinus;

import br.com.ninus.rest.api.entity.ClassNinus;
import br.com.ninus.rest.api.utils.constants.CategorieClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClassNinusDetailsRelation {
    private Long id;
    private String className;
    private CategorieClass categorie;

    public static ClassNinusDetailsRelation toDetailsRelationClass(ClassNinus c) {
        return new ClassNinusDetailsRelation(c.getId(), c.getClassName(), c.getCategorie());
    }

}
