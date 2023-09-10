package br.com.ninus.rest.api.service.impl;

import br.com.ninus.rest.api.entity.ModelInputClass;
import br.com.ninus.rest.api.entity.ModelOutputClass;
import br.com.ninus.rest.api.entity.dto.modelInputClass.ModelInputClassDetails;
import br.com.ninus.rest.api.entity.dto.modelOutputClass.ModelOutputClassDetails;
import br.com.ninus.rest.api.entity.dto.modelOutputClass.ModelOutputClassGPTDetails;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ModelInputClassRepository;
import br.com.ninus.rest.api.repository.ModelOutputClassRepository;
import br.com.ninus.rest.api.service.IGPTService;
import br.com.ninus.rest.api.service.IModelOutputClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelOutputClassServiceImpl implements IModelOutputClassService {

    private final ModelOutputClassRepository modelOutputClassRepository;
    private final ModelInputClassRepository modelInputClassRepository;
    private final IGPTService gptService;
    private final PagedResourcesAssembler<ModelOutputClassDetails> assembler;
    @Value("${spring.profiles.active}")
    private String enviroment;

    @Override
    public PagedModel<EntityModel<ModelOutputClassDetails>> listingAll(Pageable pageable) {
        Page<ModelOutputClassDetails> list = modelOutputClassRepository.findAllByActiveTrue(pageable).map(ModelOutputClassDetails::new);
        return assembler.toModel(list);
    }

    @Override
    public ModelOutputClassDetails showOutputModelByInputModelId(Long inputModelId) {
        getInputModel(inputModelId);
        return new ModelOutputClassDetails(modelOutputClassRepository.findByInputModelId(inputModelId));
    }

    @Override
    public ModelOutputClassDetails insert(ModelInputClass input) {
        /* chamar o gpt */
        ModelOutputClass response;
        if(enviroment.equals("prod")) {
            response = gptService.createRequest(input);
        } else {
            response = createResponseDefault();
        }

        /* salvar os dados de entrada no banco */
        ModelInputClass inputPersisted = modelInputClassRepository.saveAndFlush(input);

        response.setModelInputClass(inputPersisted);

        ModelOutputClass outputPersisted = modelOutputClassRepository.saveAndFlush(response);
        return new ModelOutputClassDetails(outputPersisted);
    }

    @Override
    public ModelOutputClassDetails recreate(Long outputModelId, ModelInputClass input) {
        getOutputModel(outputModelId);

        ModelInputClass inputClass = getInputModel(input.getId());
        ModelOutputClass response;

        if(enviroment.equals("prod")) {
            response = gptService.createRequest(input);
        } else {
            response = createResponseDefault();
        }

        response.setId(outputModelId);
        response.setModelInputClass(inputClass);

        ModelOutputClass persisted = modelOutputClassRepository.saveAndFlush(response);

        return new ModelOutputClassDetails(persisted);
    }

    @Override
    public ModelOutputClassDetails show(Long id) {
        return toDetails(getOutputModel(id));
    }


    private ModelOutputClassDetails toDetails(ModelOutputClass model) {
        return new ModelOutputClassDetails(model);
    }

    private ModelOutputClass getOutputModel(Long id) {
        return modelOutputClassRepository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhum modelo de aula com o id [ " + id + " ] foi encontrado.")
        );
    }

    private ModelInputClass getInputModel(Long id) {
        return modelInputClassRepository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhum modelo de entrada com o id [ " + id + " ] foi encontrado.")
        );
    }

    private ModelOutputClass createResponseDefault() {
        ModelOutputClassGPTDetails dto = new ModelOutputClassGPTDetails(
            "Esta aula tem como objetivo ensinar as crianças a conviverem entre si, abordando o tema 'Conviver'. O tema será trabalhado por meio do eixo 'O eu, o outro e o nós', com duração de 50 minutos.",
            "Ao final desta aula, as crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.",
            "A aula será iniciada com uma conversa sobre o tema, seguida de uma atividade em grupo para que as crianças possam praticar o que foi discutido.",
            "Livros didâticos, brinquedos.",
            "Serão feitas adaptações para que as crianças com necessidades especiais possam participar da aula.",
            "Serão abordados conceitos de convivência, respeito e empatia.",
            "Serão abordadas as diferenças culturais entre as crianças, valorizando a diversidade.",
            "Serão realizados jogos para que as crianças possam praticar o que foi discutido.",
            "Será incentivada a participação dos pais na aula.",
            "Será realizada uma conversa para que as crianças possam compartilhar o que aprenderam.",
            "Serão dadas orientações para que as crianças possam aplicar o que aprenderam em suas vidas.",
            "As crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia."
        );
        return new ModelOutputClass(dto);
    }

}
