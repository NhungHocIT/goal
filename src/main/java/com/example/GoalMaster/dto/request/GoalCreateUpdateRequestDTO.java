package com.example.GoalMaster.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoalCreateUpdateRequestDTO {
    @NotBlank(message = "Vui lòng nhập tên mục tiêu của bạn")
    @Size(max = 50, message = "Tên quá dài")
    String title;
    @NotBlank(message = "Vui lòng mô tả chi tiết mục tiêu  bạn muốn đạt được")
    String describe;
    @NotBlank(message = "Hãy chọn ngày bắt đầu mục tiêu")
    String start_date;
    @NotBlank(message = "Mục tiêu của bạn dự kiến kết thúc vào ngày nào")
    String end_date;
    @NotNull(message = "User Id không  được null")
    Long userId;
}