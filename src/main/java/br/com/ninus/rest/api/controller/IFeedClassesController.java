package br.com.ninus.rest.api.controller;

import br.com.ninus.rest.api.entity.dto.feed.FeedClassesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IFeedClassesController {
    ResponseEntity<List<FeedClassesResponse>> getFeedInProgress(@PathVariable(name = "clientId") Long clientId);
    ResponseEntity<List<FeedClassesResponse>> getFeedFinished(@PathVariable(name = "clientId") Long clientId);
}
