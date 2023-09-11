package br.com.ninus.rest.api.controller.impl;

import br.com.ninus.rest.api.controller.IClassNInusController;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusDetails;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusPostRequest;
import br.com.ninus.rest.api.service.IClassNinusService;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/class")
public class ClassNinusControllerImpl implements IClassNInusController {

    private IClassNinusService classService;

    public ClassNinusControllerImpl(IClassNinusService classService) {
        this.classService = classService;
    }

    @GetMapping("/progress")
    public ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAllInProgress(Pageable pageable) {
        return ResponseEntity.ok(classService.listingAllInProgress(pageable));
    }

    @GetMapping("/finished")
    public ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAllInFinished(Pageable pageable) {
        return ResponseEntity.ok(classService.listingAllInFinished(pageable));
    }

    @GetMapping("/favorite")
    public ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAllInFavorite(Pageable pageable) {
        return ResponseEntity.ok(classService.listingAllInFavorite(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<PagedModel<EntityModel<ClassNinusDetails>>> findAll(Pageable pageable) {
        return ResponseEntity.ok(classService.listingAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ClassNinusDetails> create(ClassNinusPostRequest request) {
        /* passar os dados para o gpt, se tiver retorno*/
        return ResponseEntity.status(HttpStatus.CREATED).body(classService.insert(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassNinusDetails> show(Long id) {
        return ResponseEntity.ok(classService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassNinusDetails> updateClassNinusName(Long id, String className) {
        return ResponseEntity.ok(classService.updateClassNinusName(id, className));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        classService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/finish")
    public ResponseEntity<ClassNinusDetails> finishClass(Long id) {
        classService.finishClass(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/favorite")
    public ResponseEntity<ClassNinusDetails> favoriteClass(Long id) {
        return ResponseEntity.ok(classService.favoriteClass(id));
    }
}
