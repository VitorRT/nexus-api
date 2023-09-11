package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusDetails;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusPostRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IClassNInusController {
    ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAllInProgress(@PageableDefault(size = 5) Pageable pageable);
    ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAllInFinished(@PageableDefault(size = 5) Pageable pageable);
    ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAllInFavorite(@PageableDefault(size = 5) Pageable pageable);
    ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAll(@PageableDefault(size = 5) Pageable pageable);
    ResponseEntity<ClassNinusDetails> create(@RequestBody @Valid ClassNinusPostRequest request);
    ResponseEntity<ClassNinusDetails> show(@PathVariable Long id);
    ResponseEntity<ClassNinusDetails> updateClassNinusName(
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "className")
            String className
    );
    ResponseEntity<Void> delete(@PathVariable(name = "id") Long id);
    ResponseEntity<ClassNinusDetails> finishClass(@PathVariable(name = "id") Long id);
    ResponseEntity<ClassNinusDetails> favoriteClass(@PathVariable(name = "id") Long id);
}
