package br.com.ninus.rest.api.controller.impl;

import br.com.ninus.rest.api.controller.IFeedClassesController;
import br.com.ninus.rest.api.entity.dto.feed.FeedClassesResponse;
import br.com.ninus.rest.api.service.IFeedClassesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feed/class")
public class FeedClassesControllerImpl implements IFeedClassesController {
    private IFeedClassesService service;

    @Deprecated
    public FeedClassesControllerImpl(IFeedClassesService service) {
        this.service = service;
    }

    @GetMapping("/progress/{clientId}")
    public ResponseEntity<List<FeedClassesResponse>> getFeedInProgress(Long clientId) {
        return ResponseEntity.ok(service.listFeedInProgessByClientId(clientId));
    }

    @GetMapping("/finished/{clientId}")
    public ResponseEntity<List<FeedClassesResponse>> getFeedFinished(Long clientId) {
        return ResponseEntity.ok(service.listFeedFineshedByClientId(clientId));
    }
}
