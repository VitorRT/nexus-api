package br.com.ninus.rest.api.dto.gpt;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public record ChatGPTRequest(String model, String prompt, Double temperature, Integer maxTokens, Double topP, Double frequencyPenalty, Double presencePenalty) { }
