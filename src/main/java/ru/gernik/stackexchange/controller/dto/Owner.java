package ru.gernik.stackexchange.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    private String profileImage;
    private String userType;
    private Integer userId;
    private String link;
    private Integer reputation;
    private String displayName;
    private Integer acceptRate;
}
