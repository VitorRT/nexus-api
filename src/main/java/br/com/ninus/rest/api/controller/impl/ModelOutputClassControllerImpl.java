package br.com.ninus.rest.api.controller.impl;

import br.com.ninus.rest.api.controller.IModelOutputClassController;
import br.com.ninus.rest.api.entity.dto.modelOutputClass.ModelOutputClassDetails;
import br.com.ninus.rest.api.service.IModelOutputClassService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class/model")
public class ModelOutputClassControllerImpl implements IModelOutputClassController {

    private IModelOutputClassService modelClassService;

    public ModelOutputClassControllerImpl(IModelOutputClassService modelClassService) {
        this.modelClassService = modelClassService;
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ModelOutputClassDetails>>> findAll(Pageable pageable) {
        return ResponseEntity.ok(modelClassService.listingAll(pageable));
    }

    @GetMapping("/input/{inputModelId}")
    public ResponseEntity<ModelOutputClassDetails> showByInputModelId(Long inputModelId) {
        return ResponseEntity.ok(modelClassService.showOutputModelByInputModelId(inputModelId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelOutputClassDetails> show(Long id) {
        return ResponseEntity.ok(modelClassService.show(id));
    }

}
