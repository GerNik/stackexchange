package ru.gernik.stackexchange.service.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner implements Serializable {
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("user_id")
    private Integer userId;
    private String link;
    private Integer reputation;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("accept_rate")
    private Integer acceptRate;
}
