package br.com.ninus.rest.api.dto.gpt;

public record ChatGPTUsage(Integer prompt_tokens, Integer completion_tokens, Integer total_tokens) {
}
