package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.entity.ClassNinus;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusDetails;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusPostRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IClassNinusService {
    PagedModel<EntityModel<ClassNinusDetails>> listingAllInProgress(Pageable pageable);
    PagedModel<EntityModel<ClassNinusDetails>>listingAllInFinished(Pageable pageable);
    PagedModel<EntityModel<ClassNinusDetails>> listingAllInFavorite(Pageable pageable);
    ClassNinusDetails show(Long id);
    ClassNinusDetails insert(ClassNinusPostRequest request);
    ClassNinusDetails updateClassNinusName(Long id, String className);
    void delete(Long id);
    void finishClass(Long id);
    ClassNinusDetails favoriteClass(Long id);
}
