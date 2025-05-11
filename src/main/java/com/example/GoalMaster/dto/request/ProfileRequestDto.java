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
    String email_phone;
    String password;
    String confirmPassword;
    @JsonFormat(pattern = "yyyy-MM-dd")
    String birth;
}

