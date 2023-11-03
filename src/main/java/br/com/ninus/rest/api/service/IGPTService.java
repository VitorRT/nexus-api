package br.com.ninus.rest.api.service;

import br.com.ninus.rest.api.entity.ModelInputClass;
import br.com.ninus.rest.api.entity.ModelOutputClass;

public interface IGPTService {
    ModelOutputClass createRequest(ModelInputClass input);
}
