package com.example.GoalMaster.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestRegisterDTO {
    @NotBlank(message = "❌ Vui lòng nhập tên người dùng.")
    @Size(max = 50, message = "Tên quá dài")
    String username;
    @NotNull
    String birth;
    @NotBlank(message = "❌ Vui lòng nhập email hoặc phone.")
    @Size(max = 255, message = "Email hoặc số điện thoại không hợp lệ")
    String emailPhone;
    @NotBlank(message = "❌ Mật khẩu không được để trống.")
    @Size(min=8, max = 50, message = "Mật khẩu không hợp lệ")
    String password;
    @NotBlank(message = "❌ Mật khẩu xác nhận không được để trống")
    @Size(min=8, max = 50, message = "Mật khẩu không hợp lệ")
    String confirmPassword;
}