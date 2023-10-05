package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.entity.dto.feed.FeedClassesResponse;

import java.util.List;

public interface IFeedClassesService {
    List<FeedClassesResponse> listFeedByClientId(Long clientId);
}
