package com.example.GoalMaster.service;

import com.example.GoalMaster.dto.request.UserRequestRegisterDTO;
import com.example.GoalMaster.dto.response.ApiResponse;
import com.example.GoalMaster.dto.response.UserResponseRegisterDTO;
import com.example.GoalMaster.entity.User;
import com.example.GoalMaster.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }
//
//    // ✅ Đăng ký người dùng mới
    public ApiResponse<UserResponseRegisterDTO> registerUser(UserRequestRegisterDTO userDto) {
        Optional<User> existedUser = userRepository.existsByEmailPhone(userDto.getEmailPhone();
        if (existedUser.isPresent()){
           return ApiResponse.builder()
                   .statusCode(HttpStatus.BAD_REQUEST)
                   .status(false)
                   .message("User existed!")
                   .build();
        }

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        User newUser = new User(
                userDto.getEmailPhone(),
                encodedPassword,
                new Date()
        );

        userRepository.save(newUser);
        return true;
    }
//
//    // ✅ Kiểm tra đăng nhập và trả về user nếu hợp lệ
//    public User loginUser(String emailPhone, String rawPassword) {
//        return userRepository.findByEmailPhone(emailPhone)
//                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
//                .orElse(null);
//    }
}
