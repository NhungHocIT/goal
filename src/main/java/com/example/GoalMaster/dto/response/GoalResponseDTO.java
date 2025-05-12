package com.example.GoalMaster.dto.response;

import com.example.GoalMaster.entity.Goal_progress;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoalResponseDTO {
    long id;
    String title;
    String status;
    String describe;
    Date start_date;
    Date end_date;
    List<Goal_progress> goalProgressList;
}
