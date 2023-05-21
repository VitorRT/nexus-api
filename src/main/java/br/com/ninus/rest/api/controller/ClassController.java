package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.domain.Class;
import br.com.ninus.rest.api.domain.dto.classNinus.DetailsClass;
import br.com.ninus.rest.api.service.ClassService;
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
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;


    @GetMapping("/progress")
    public ResponseEntity<PagedModel<EntityModel<DetailsClass>>> findAllInProgress(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(classService.listingAllInProgress(pageable));
    }

    @GetMapping("/finished")
    public ResponseEntity<PagedModel<EntityModel<DetailsClass>>> findAllInFinished(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(classService.listingAllInFinished(pageable));
    }

    @GetMapping("/favorite")
    public ResponseEntity<PagedModel<EntityModel<DetailsClass>>> findAllInFavorite(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(classService.listingAllInFavorite(pageable));
    }

    @PostMapping
    public ResponseEntity<DetailsClass> create(@RequestBody @Valid Class c, BindingResult result) {
        return ResponseEntity.status(HttpStatus.CREATED).body(classService.insert(c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsClass> show(@PathVariable Long id) {
        return ResponseEntity.ok(classService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailsClass> edit(@PathVariable Long id, @RequestBody @Valid Class c, BindingResult result) {
        return ResponseEntity.ok(classService.update(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        classService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/finish")
    public ResponseEntity<DetailsClass> finishClass(@PathVariable Long id) {
        return ResponseEntity.ok(classService.finishClass(id));
    }

    @PutMapping("/{id}/favorite")
    public ResponseEntity<DetailsClass> favoriteClass(@PathVariable Long id) {
        return ResponseEntity.ok(classService.favoriteClass(id));
    }
}
