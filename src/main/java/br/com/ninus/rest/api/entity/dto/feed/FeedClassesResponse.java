package br.com.ninus.rest.api.entity.dto.feed;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class FeedClassesResponse {
    private Long clientId;
    private Long classId;
    private String className;
    private String introduction;

    public FeedClassesResponse(Long clientId, Long classId, String className, String introduction) {
        this.clientId = clientId;
        this.classId = classId;
        this.className = className;
        this.introduction = introduction;
    }

    public FeedClassesResponse() { }
}

