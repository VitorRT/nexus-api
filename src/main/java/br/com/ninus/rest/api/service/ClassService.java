package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.domain.Class;
import br.com.ninus.rest.api.domain.dto.classNinus.DetailsClass;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ClassRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class ClassService {

    private final ClassRepository classRepository;
    private final ClientService clientService;
    private final PagedResourcesAssembler<DetailsClass> assembler;


    public PagedModel<EntityModel<DetailsClass>> listingAllInProgress(Pageable pageable) {
        Page<DetailsClass> list = classRepository.findAllByCategoriePROGRESS(pageable).map(DetailsClass::new);
        return assembler.toModel(list);
    }

    public PagedModel<EntityModel<DetailsClass>>listingAllInFinished(Pageable pageable) {
        Page<DetailsClass> list = classRepository.findAllByCategorieFINISHED(pageable).map(DetailsClass::new);
        return assembler.toModel(list);
    }


    public PagedModel<EntityModel<DetailsClass>> listingAllInFavorite(Pageable pageable) {
        Page<DetailsClass> list = classRepository.findAllByCategorieFAVORITE(pageable).map(DetailsClass::new);
        return assembler.toModel(list);
    }

    public DetailsClass insert(Class c) {
        c.setClient(clientService.show(c.getClient().getId()));
        classRepository.saveAndFlush(c);
        DetailsClass details = new DetailsClass(c);
        return details;
    }

    public DetailsClass show(Long id) {
        return toDetails(getClass(id));
    }

    public DetailsClass update(Long id, Class c) {
        getClass(id);
        c.setId(id);
        c.setUpdatedAt(LocalDateTime.now());
        return toDetails(classRepository.saveAndFlush(c));
    }

    public void delete(Long id) {
        Class classFound = getClass(id);
        classRepository.delete(classFound);
    }

    public DetailsClass finishClass(Long id) {
        Class c = getClass(id);
        c.finishClass();
        classRepository.saveAndFlush(c);
        return toDetails(c);
    }

    public DetailsClass favoriteClass(Long id) {
        Class c = getClass(id);
        c.addToFavorite();
        classRepository.saveAndFlush(c);
        return toDetails(c);
    }




    private Class getClass(Long id) {
        return classRepository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhuma aula com o id [ " + id + " ] foi encontrada.")
        );
    }


    private DetailsClass toDetails(Class c) {
        return new DetailsClass(c);
    }

}
