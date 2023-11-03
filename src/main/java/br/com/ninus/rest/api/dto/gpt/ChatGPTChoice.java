package br.com.ninus.rest.api.dto.gpt;

public record ChatGPTChoice(String text, Integer index, Object logprobs, Object finish_reason) {
}
