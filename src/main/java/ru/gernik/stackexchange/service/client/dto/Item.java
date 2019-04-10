package ru.gernik.stackexchange.service.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private Owner owner;
    private Integer score;
    @JsonProperty("accepted_answer_id")
    private Integer acceptedAnswerId;
    private String link;
    @JsonProperty("last_activity_date")
    private Long lastActivityDate;
    @JsonProperty("is_answered")
    private Boolean isAnswered;
    @JsonProperty("creation_date")
    private Long creationDate;
    @JsonProperty("answer_count")
    private Integer answerCount;
    private String title;
    @JsonProperty("question_id")
    private Integer questionId;
    @JsonProperty("view_count")
    private Integer viewCount;
    private List<String> tags;
    @JsonProperty("last_edit_date")
    private Long lastEditDate;
    @JsonProperty("closed_date")
    private Long closedDate;
    @JsonProperty("closed_reason")
    private String closedReason;
}