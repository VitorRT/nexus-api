package br.com.ninus.rest.api.controller.impl;

import br.com.ninus.rest.api.controller.IModelInputClassController;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassDetails;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassPostRequest;
import br.com.ninus.rest.api.service.IModelInputClassService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class/input")
public class ModelInputClassControllerImpl implements IModelInputClassController {

    private IModelInputClassService modelInputService;

    public ModelInputClassControllerImpl(IModelInputClassService modelInputService) {
        this.modelInputService = modelInputService;
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<ModelInputClassDetails>>> findAll(Pageable pageable) {
        return ResponseEntity.ok(modelInputService.listingAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ModelInputClassDetails> create(ModelInputClassPostRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modelInputService.insert(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelInputClassDetails> show(Long id) {
        return ResponseEntity.ok(modelInputService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelInputClassDetails> edit(Long id, ModelInputClassPostRequest request) {
        return ResponseEntity.ok(modelInputService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        modelInputService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
