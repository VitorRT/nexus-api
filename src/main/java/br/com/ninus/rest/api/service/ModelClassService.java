package br.com.ninus.rest.api.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import br.com.ninus.rest.api.domain.ModelClass;
import br.com.ninus.rest.api.domain.ModelInput;
import br.com.ninus.rest.api.domain.dto.modelClass.DetailsModelClass;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ModelClassRepository;
import br.com.ninus.rest.api.repository.ModelInputRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModelClassService {

    private final ModelClassRepository modelClassRepository;
    private final ModelInputRepository modelInputRepository;
    private final PagedResourcesAssembler<DetailsModelClass> assembler;


    public PagedModel<EntityModel<DetailsModelClass>> listingAll(Pageable pageable) {
        Page<DetailsModelClass> list = modelClassRepository.findAllByActiveTrue(pageable).map(DetailsModelClass::new);
        return assembler.toModel(list);
    }

    public DetailsModelClass insert(ModelClass model) {
        model.setModelInput(getModelInput(model.getModelInput().getId()));
        modelClassRepository.saveAndFlush(model);
        return toDetails(model);
    }

    public DetailsModelClass show(Long id) {
        return toDetails(getModelClass(id));
    }

    public DetailsModelClass update(Long id, ModelClass model) {
        getModelClass(id);
        model.setId(id);
        model.setUpdatedAt(LocalDateTime.now());
        return toDetails(modelClassRepository.saveAndFlush(model));
    }

    public void delete(Long id) {
        ModelClass model = getModelClass(id);
        modelClassRepository.delete(model);
    }




    private DetailsModelClass toDetails(ModelClass model) {
        return new DetailsModelClass(model);
    }

    private ModelClass getModelClass(Long id) {
        return modelClassRepository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhum modelo de aula com o id [ " + id + " ] foi encontrado.")
        );
    }

    private ModelInput getModelInput(Long id) {
        return modelInputRepository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhum modelo de entrada com o id [ " + id + " ] foi encontrado.")
        );
    }

}
