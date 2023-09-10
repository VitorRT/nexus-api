package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.entity.ModelInputClass;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassDetails;
import br.com.ninus.rest.api.entity.dto.modelOutputClass.ModelOutputClassDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IModelOutputClassService {
    PagedModel<EntityModel<ModelOutputClassDetails>> listingAll(Pageable pageable);
    ModelOutputClassDetails showOutputModelByInputModelId(Long inputModelId);
    ModelOutputClassDetails insert(ModelInputClass input);

    ModelOutputClassDetails recreate(Long outputModelId ,ModelInputClass input);
    ModelOutputClassDetails show(Long id);
}
