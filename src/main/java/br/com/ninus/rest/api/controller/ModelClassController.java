package br.com.ninus.rest.api.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ninus.rest.api.domain.ModelClass;
import br.com.ninus.rest.api.domain.dto.modelClass.DetailsModelClass;
import br.com.ninus.rest.api.service.ModelClassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/class/model")
@RequiredArgsConstructor
public class ModelClassController {
    
    private final ModelClassService modelClassService;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<DetailsModelClass>>> findAll(@PageableDefault(size=5) Pageable pageable) {
        return ResponseEntity.ok(modelClassService.listingAll(pageable));
    }

    @PostMapping
    public ResponseEntity<DetailsModelClass> create(@RequestBody @Valid ModelClass model, BindingResult result) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modelClassService.insert(model));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsModelClass> show(@PathVariable Long id) {
        return ResponseEntity.ok(modelClassService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailsModelClass> edit(@PathVariable Long id, @RequestBody @Valid ModelClass model, BindingResult result) {
        return ResponseEntity.ok(modelClassService.update(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        modelClassService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
