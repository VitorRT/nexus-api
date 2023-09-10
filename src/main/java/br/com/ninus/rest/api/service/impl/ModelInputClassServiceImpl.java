package br.com.ninus.rest.api.service.impl;

import br.com.ninus.rest.api.entity.ClassNinus;
import br.com.ninus.rest.api.entity.ModelInputClass;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassDetails;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassPostRequest;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ClassNinusRepository;
import br.com.ninus.rest.api.repository.ModelInputClassRepository;
import br.com.ninus.rest.api.service.IModelInputClassService;
import br.com.ninus.rest.api.service.IModelOutputClassService;
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
public class ModelInputClassServiceImpl implements IModelInputClassService {

    private final ModelInputClassRepository modelInputClassRepository;
    private final ClassNinusRepository classNinusRepository;
    private final IModelOutputClassService modelOutputClassService;
    private final PagedResourcesAssembler<ModelInputClassDetails> assembler;

    @Override
    public PagedModel<EntityModel<ModelInputClassDetails>> listingAll(Pageable pageable) {
        Page<ModelInputClassDetails> list = modelInputClassRepository.findAllByActiveTrue(pageable).map(ModelInputClassDetails::new);
        return assembler.toModel(list);
    }

    @Override
    public ModelInputClassDetails insert(ModelInputClassPostRequest request) {
        ClassNinus classNinus = getClassNinus(request.getClassNinusId());
        ModelInputClass input = new ModelInputClass(request);

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

        input.setClassNinusFk(classNinus);

        /* persistindo os dados de entrada e gerando dados de saída com o gpt */
        modelOutputClassService.insert(input);

        ModelInputClassDetails details = toDetails(input);
        return details;
    }

    @Override
    public ModelInputClassDetails show(Long id) {
        ModelInputClass input = getModelInput(id);
        return toDetails(input);
    }

    @Override
    public ModelInputClassDetails update(Long id, ModelInputClassPostRequest request) {
        ModelInputClass found = getModelInput(id);
        ModelInputClass input = new ModelInputClass(request);

        input.setId(id);
        input.setUpdatedAt(LocalDateTime.now());


        /* recriando uma aula com o gpt */
        modelOutputClassService.recreate(found.getModelOutputClass().getId(), input);

        modelInputClassRepository.saveAndFlush(input);
        return toDetails(input);
    }
    
    @Override
    public void delete(Long id) {
        ModelInputClass input = getModelInput(id);
        modelInputClassRepository.delete(input);
    }


    private ModelInputClass getModelInput(Long id) {
        return modelInputClassRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("Nenhum input de aula com o id [ " + id + " ] foi encontrado."));
    }

    private ClassNinus getClassNinus(Long id) {
        return classNinusRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Nenhuma aula com o id [ " + id + " ] foi encontrada."));
    }

    private ModelInputClassDetails toDetails(ModelInputClass input) {
        return new ModelInputClassDetails(input);
    }

}
