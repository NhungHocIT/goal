package com.example.GoalMaster.controller.v1;

import com.example.GoalMaster.dto.request.UserRequestRegisterDTO;
import com.example.GoalMaster.entity.User;
import com.example.GoalMaster.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ API Đăng ký người dùng mới | Register new user
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRequestRegisterDTO userDto) {
        // Tiến hành đăng ký | Process registration
        boolean isRegistered = authService.registerUser(userDto);
//        if (isRegistered) {
//            response.put("message", "✅ Đăng ký thành công.");
//            response.put("status", "success");
//            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
//        } else {
//            response.put("message", "⚠️ Email hoặc số điện thoại đã được sử dụng.");
//            response.put("status", "fail");
//            return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(response);
//        }
        return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body(null);
    }

    // ✅ API Đăng nhập | Login user
//    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
//        Map<String, Object> response = new HashMap<>();
//
//        String emailPhone = loginRequest.get("emailPhone");
//        String password = loginRequest.get("password");
//
//        // Kiểm tra dữ liệu đầu vào | Validate input
//        if (emailPhone == null || password == null) {
//            response.put("message", "❌ Thiếu thông tin đăng nhập.");
//            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
//        }
//
//        // Xác thực người dùng | Authenticate user
//        User user = authService.loginUser(emailPhone, password);
//        if (user != null) {
////            String token = jwtUtil.generateToken(user.getEmailPhone());
//
//            response.put("message", "✅ Đăng nhập thành công!");
//            response.put("token", token);
//            response.put("user", user.getUsername());
//            response.put("status", "success");
//            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
//        } else {
//            response.put("message", "❌ Sai email/điện thoại hoặc mật khẩu.");
//            response.put("status", "fail");
//            return ResponseEntity.status(401).contentType(MediaType.APPLICATION_JSON).body(response);
//        }
//    }
}
