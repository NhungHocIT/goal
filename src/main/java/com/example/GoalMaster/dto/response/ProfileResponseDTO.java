package com.example.GoalMaster.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProfileResponseDTO {
    Long id;
    String avatar_url;
    String background_image;
    String bio;
    Date birth;
    String username;
}

