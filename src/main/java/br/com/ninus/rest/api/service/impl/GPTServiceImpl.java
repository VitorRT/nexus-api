package br.com.ninus.rest.api.service.impl;

import br.com.ninus.rest.api.dto.gpt.ChatGPTChoice;
import br.com.ninus.rest.api.dto.gpt.ChatGPTRequest;
import br.com.ninus.rest.api.dto.gpt.ChatGPTResponse;
import br.com.ninus.rest.api.entity.ModelInputClass;
import br.com.ninus.rest.api.entity.ModelOutputClass;
import br.com.ninus.rest.api.entity.dto.modelOutputClass.ModelOutputClassGPTDetails;
import br.com.ninus.rest.api.exception.IllegalRequestException;
import br.com.ninus.rest.api.service.IGPTService;
import br.com.ninus.rest.api.utils.GeneratorPromptGPT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class GPTServiceImpl implements IGPTService {
    @Value("${gpt.openai.api_key}")
    private String GPT_API_KEY;
    @Value("${gpt.openai.model}")
    private String GPT_MODEL;
    @Value("${gpt.openai.base_url}")
    private String BASE_URL_GPT;

    @Override
    public ModelOutputClass createRequest(ModelInputClass input) {
        String prompt = GeneratorPromptGPT.createPrompt(input);
        ModelOutputClassGPTDetails response = exchange(prompt);
        ModelOutputClass modelOutputClass = new ModelOutputClass(response);
        return modelOutputClass;
    }

    private ModelOutputClassGPTDetails exchange(String prompt) {
        ChatGPTRequest request = createRequest(prompt);
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest;
        HttpRequest httpRequest;
        HttpResponse<String> response;
        ChatGPTResponse gptResponse;
        String outputJsonString;
        ModelOutputClassGPTDetails finalResponse = new ModelOutputClassGPTDetails();

        try {
            jsonRequest = mapper.writeValueAsString(request);
            httpRequest = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .header("Authorization", "Bearer " + GPT_API_KEY)
                    .header("Content-type", "application/json")
                    .timeout(Duration.ofSeconds(50))
                    .uri(new URI(BASE_URL_GPT))
                    .build()
            ;

            response =  httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            gptResponse = mapper.readValue(response.body(), ChatGPTResponse.class);
            System.out.println(response.statusCode());
            for(ChatGPTChoice choice : gptResponse.choices()) {
                outputJsonString = choice.text().trim();
                finalResponse = mapper.readValue(outputJsonString, ModelOutputClassGPTDetails.class);
            }
        } catch (JsonProcessingException e) {
            throw new IllegalRequestException(e.getMessage());
        } catch (Exception e) {
            throw new IllegalRequestException("Ocorreu um erro ao fazer a requisição para o GPT :(");
        }
        return finalResponse;
    }

    private ChatGPTRequest createRequest(String prompt) {
        return new ChatGPTRequest(
                GPT_MODEL,
                prompt,
                0.3,
                2000,
                1.0,
                0.0,
                0.0
        );
    }
}
