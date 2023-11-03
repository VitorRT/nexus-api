package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassDetails;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassPostRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IModelInputClassService {
    PagedModel<EntityModel<ModelInputClassDetails>> listingAll(Pageable pageable);
    ModelInputClassDetails insert(ModelInputClassPostRequest request);
    ModelInputClassDetails show(Long id);
    ModelInputClassDetails update(Long id, ModelInputClassPostRequest request);
    void delete(Long id);
}
