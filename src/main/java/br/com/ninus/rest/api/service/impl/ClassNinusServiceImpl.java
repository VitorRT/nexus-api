package br.com.ninus.rest.api.service.impl;

import br.com.ninus.rest.api.entity.ClassNinus;
import br.com.ninus.rest.api.entity.Client;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusDetails;
import br.com.ninus.rest.api.entity.dto.classNinus.ClassNinusPostRequest;
import br.com.ninus.rest.api.exception.IllegalRequestParamException;
import br.com.ninus.rest.api.exception.RestNotFoundException;
import br.com.ninus.rest.api.repository.ClassNinusRepository;
import br.com.ninus.rest.api.repository.ClientRepository;
import br.com.ninus.rest.api.service.IClassNinusService;
import jakarta.persistence.EntityNotFoundException;
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
public class ClassNinusServiceImpl implements IClassNinusService {

    private final ClassNinusRepository classNinusRepository;
    private final ClientRepository clientRepository;
    private final PagedResourcesAssembler<ClassNinusDetails> assembler;


    @Override
    public PagedModel<EntityModel<ClassNinusDetails>> listingAllInProgress(Pageable pageable) {
        Page<ClassNinusDetails> list = classNinusRepository.findAllByCategoriePROGRESS(pageable).map(ClassNinusDetails::new);
        return assembler.toModel(list);
    }

    @Override
    public PagedModel<EntityModel<ClassNinusDetails>>listingAllInFinished(Pageable pageable) {
        Page<ClassNinusDetails> list = classNinusRepository.findAllByCategorieFINISHED(pageable).map(ClassNinusDetails::new);
        return assembler.toModel(list);
    }

    @Override
    public PagedModel<EntityModel<ClassNinusDetails>> listingAllInFavorite(Pageable pageable) {
        Page<ClassNinusDetails> list = classNinusRepository.findAllByCategorieFAVORITE(pageable).map(ClassNinusDetails::new);
        return assembler.toModel(list);
    }

    @Override
    public ClassNinusDetails insert(ClassNinusPostRequest request) {
        Client client = this.getClient(request.getClientId());
        ClassNinus classNinus = new ClassNinus(request);
        classNinus.setClient(client);
        return new ClassNinusDetails(classNinusRepository.saveAndFlush(classNinus));
    }

    @Override
    public ClassNinusDetails show(Long id) {
        return toDetails(getClassNinus(id));
    }

    @Override
    public ClassNinusDetails updateClassNinusName(Long id, String className) {
        ClassNinus classNinus = getClassNinus(id);

        if(className.trim().equals("") || className.trim() == null) {
            throw new IllegalRequestParamException("class name is mandatory.");
        }
        else if(className.trim().length() < 4 || className.trim().length() > 40) {
            throw new IllegalRequestParamException("The class name must have a minimum of 4 characters and a maximum of 40 characters.");
        }

        classNinus.setId(id);
        classNinus.setUpdatedAt(LocalDateTime.now());
        classNinus.setClassName(className);
        return toDetails(classNinusRepository.saveAndFlush(classNinus));
    }

    @Override
    public void delete(Long id) {
        ClassNinus classNinusFound = getClassNinus(id);
        classNinusRepository.delete(classNinusFound);
    }

    @Override
    public void finishClass(Long id) {
        ClassNinus c = getClassNinus(id);
        c.finishClass();
        classNinusRepository.saveAndFlush(c);
    }

    @Override
    public ClassNinusDetails favoriteClass(Long id) {
        ClassNinus c = getClassNinus(id);
        c.addToFavorite();
        classNinusRepository.saveAndFlush(c);
        return toDetails(c);
    }


    private Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new RestNotFoundException("Nenhuma cliente com o id [ " + id + " ] foi encontrado.")
        );
    }

    private ClassNinus getClassNinus(Long id) {
        return classNinusRepository.findById(id).orElseThrow(() ->
            new RestNotFoundException("Nenhuma aula com o id [ " + id + " ] foi encontrada.")
        );
    }


    private ClassNinusDetails toDetails(ClassNinus c) {
        return new ClassNinusDetails(c);
    }

}
