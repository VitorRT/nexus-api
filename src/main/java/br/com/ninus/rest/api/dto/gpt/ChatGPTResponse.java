package br.com.ninus.rest.api.dto.gpt;

import java.util.List;

public record ChatGPTResponse(String warning, String id, Object object, Long created, String model, List<ChatGPTChoice> choices, ChatGPTUsage usage) {
}
