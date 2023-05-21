package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.domain.ModelInput;
import br.com.ninus.rest.api.domain.dto.modelInput.DetailsModelInput;
import br.com.ninus.rest.api.service.ModelInputService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class/input")
@RequiredArgsConstructor
public class ModelInputController {

    private final ModelInputService modelInputService;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<DetailsModelInput>>> findAll(
            @PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(modelInputService.listingAll(pageable));
    }

    @PostMapping
    public ResponseEntity<DetailsModelInput> create(@RequestBody @Valid ModelInput input, BindingResult result) {
        return ResponseEntity.status(HttpStatus.CREATED).body(modelInputService.insert(input));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsModelInput> show(@PathVariable Long id) {
        return ResponseEntity.ok(modelInputService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailsModelInput> edit(@PathVariable Long id, @RequestBody @Valid ModelInput input,
            BindingResult result) {
        return ResponseEntity.ok(modelInputService.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        modelInputService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
