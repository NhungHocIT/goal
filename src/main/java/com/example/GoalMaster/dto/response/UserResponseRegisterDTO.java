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

public class UserResponseRegisterDTO {
    Long id;
    String emailPhone;
    Date createdAt;
    ProfileResponseDTO profile;
}
