package com.example.GoalMaster.controller.v1;

import com.example.GoalMaster.dto.request.UserRequestLoginDTO;
import com.example.GoalMaster.dto.request.UserRequestRegisterDTO;
import com.example.GoalMaster.dto.response.ApiResponse;
import com.example.GoalMaster.dto.response.UserResponseLoginDTO;
import com.example.GoalMaster.dto.response.UserResponseRegisterDTO;
import com.example.GoalMaster.exception.AppException;
import com.example.GoalMaster.repository.UserRepository;
import com.example.GoalMaster.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
    }

    // ✅ API Đăng ký người dùng mới | Register new user
    @PostMapping(value = "/register")
    public ResponseEntity<ApiResponse<UserResponseRegisterDTO>> register(@RequestBody @Valid UserRequestRegisterDTO userDto) throws AppException, ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<UserResponseRegisterDTO>builder()
                        .status(true)
                        .statusCode(HttpStatus.OK.value())
                        .message("✅ Đăng ký thành công!")
                        .data(authService.registerUser(userDto))
                        .build()
        );
    }

// ✅ API Đăng nhập người dùng | Login user
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseLoginDTO>> login(
            @RequestBody @Valid UserRequestLoginDTO userDto) throws AppException {

        // Gọi service để xác thực thông tin đăng nhập
        UserResponseLoginDTO userResponse = authService.loginUser(userDto);

        // Trả về phản hồi với thông tin người dùng
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<UserResponseLoginDTO>builder()
                        .status(true) // Trạng thái thành công
                        .statusCode(HttpStatus.OK.value()) // Mã HTTP 200
                        .message("✅ Đăng nhập thành công!") // Thông điệp phản hồi
                        .data(userResponse) // Dữ liệu trả về là thông tin người dùng
                        .build()
        );
    }

}
