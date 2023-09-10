package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassDetails;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassPostRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

    public interface IModelInputClassController {
    ResponseEntity<PagedModel<EntityModel<ModelInputClassDetails>>> findAll(
            @PageableDefault(size = 5) Pageable pageable);
    ResponseEntity<ModelInputClassDetails> create(@RequestBody @Valid ModelInputClassPostRequest request);
    ResponseEntity<ModelInputClassDetails> show(@PathVariable Long id);
    ResponseEntity<ModelInputClassDetails> edit(@PathVariable Long id, @RequestBody @Valid ModelInputClassPostRequest request);
    ResponseEntity<Void> delete(@PathVariable Long id);
}
