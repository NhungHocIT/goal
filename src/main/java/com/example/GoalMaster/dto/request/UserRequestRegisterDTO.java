package com.example.GoalMaster.dto.request;

import jakarta.validation.constraints.NotBlank;
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
    private String username;
    @NotBlank(message = "❌ Vui lòng nhập email hoặc phone.")
    @Size(max = 255, message = "Email hoặc số điện thoại không hợp lệ")
    private String emailPhone;
    @NotBlank(message = "❌ Mật khẩu không được để trống.")
    @Size(min=8, max = 50, message = "Mật khẩu không hợp lệ")
    private String password;
    @NotBlank(message = "❌ Mật khẩu xác nhận không được để trống")
    @Size(min=8, max = 50, message = "Mật khẩu không hợp lệ")
    private String confirmPassword;
}