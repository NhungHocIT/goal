package com.example.GoalMaster.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProfileRequestDto {
    String username;
    String avatar_url;
    String background_image;
    String bio;
    @JsonFormat(pattern = "yyyy-MM-dd")
    String birth;
}

