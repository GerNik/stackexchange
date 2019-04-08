package ru.gernik.stackexchange.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Owner owner;
    private Integer score;
    private Integer acceptedAnswerId;
    private String link;
    private Long lastActivityDate;
    private Boolean isAnswered;
    private Long creationDate;
    private Integer answerCount;
    private String title;
    private Integer questionId;
    private Integer viewCount;
    private List<String> tags;
    private Long lastEditDate;
    private Long closedDate;
    private String closedReason;
}