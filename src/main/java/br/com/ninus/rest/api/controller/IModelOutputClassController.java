package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.entity.dto.modelOutputClass.ModelOutputClassDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IModelOutputClassController {
    ResponseEntity<PagedModel<EntityModel<ModelOutputClassDetails>>> findAll(@PageableDefault(size=5) Pageable pageable);
    ResponseEntity<ModelOutputClassDetails> showByInputModelId(@PathVariable("inputModelId") Long inputModelId);
    ResponseEntity<ModelOutputClassDetails> show(@PathVariable Long id);
}
