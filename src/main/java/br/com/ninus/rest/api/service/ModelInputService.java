package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.domain.Class;
import br.com.ninus.rest.api.domain.ModelInput;
import br.com.ninus.rest.api.domain.dto.modelInput.DetailsModelInput;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ClassRepository;
import br.com.ninus.rest.api.repository.ModelInputRepository;
import br.com.ninus.rest.api.utils.LearningObjectiveCodeHandler;
import br.com.ninus.rest.api.utils.constants.LearningObjective;
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
public class ModelInputService {

    private final ModelInputRepository modelInputRepository;
    private final ClassRepository classRepository;
    private final PagedResourcesAssembler<DetailsModelInput> assembler;


    public PagedModel<EntityModel<DetailsModelInput>> listingAll(Pageable pageable) {
        Page<DetailsModelInput> list = modelInputRepository.findAllByActiveTrue(pageable).map(DetailsModelInput::new);
        return assembler.toModel(list);
    }

    public DetailsModelInput insert(ModelInput input) {
        /*
         * Regra de Negócio - Ajuste na faixa etária de acordo com o compo de
         * experiência.
         */
        if (input.getFieldsExperience().equals(LearningObjective.BEBES)) {
            input.setAgeGroup("de 0 anos até 1 ano e 6 meses");
        } else if (input.getFieldsExperience().equals(LearningObjective.CRIANCAS_BEM_PEQUENAS)) {
            input.setAgeGroup("de 1 ano e 7 meses até 3 anos e 11 meses");
        } else {
            input.setAgeGroup("de 4 anos até 5 anos e 11 meses");
        }

        /*
         * Regra de Negócio - Ajuste no código do objetivo de aprendizagem de acordo com
         * o objetivo de aprendizagem.
         */
        input.setLearningObjectiveCode(
                LearningObjectiveCodeHandler
                        .getCode(input.getLearningObjective(), input.getFieldsExperience()));

        input.setClassFk(getClass(input.getClassFk().getId()));
        modelInputRepository.saveAndFlush(input);
        return toDetails(input);
    }

    public DetailsModelInput show(Long id) {
        ModelInput input = getModelInput(id);
        return toDetails(input);
    }

    public DetailsModelInput update(Long id, ModelInput input) {
        getModelInput(id);
        input.setId(id);
        input.setUpdatedAt(LocalDateTime.now());
        modelInputRepository.saveAndFlush(input);
        return toDetails(input);
    }

    public void delete(Long id) {
        ModelInput input = getModelInput(id);
        modelInputRepository.delete(input);
    }

    private ModelInput getModelInput(Long id) {
        return modelInputRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("Nenhum input de aula com o id [ " + id + " ] foi encontrado."));
    }

    private Class getClass(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Nenhuma aula com o id [ " + id + " ] foi encontrada."));
    }

    private DetailsModelInput toDetails(ModelInput input) {
        return new DetailsModelInput(input);
    }

}
