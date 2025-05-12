package com.example.GoalMaster.service;

import com.example.GoalMaster.dto.request.UserRequestLoginDTO;
import com.example.GoalMaster.dto.request.UserRequestRegisterDTO;
import com.example.GoalMaster.dto.response.ProfileResponseDTO;
import com.example.GoalMaster.dto.response.UserResponseLoginDTO;
import com.example.GoalMaster.dto.response.UserResponseRegisterDTO;
import com.example.GoalMaster.entity.Profile;
import com.example.GoalMaster.entity.User;
import com.example.GoalMaster.exception.AppException;
import com.example.GoalMaster.repository.ProfileRepository;
import com.example.GoalMaster.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {
    PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public AuthService(UserRepository userRepository, ProfileRepository profileRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ Đăng ký người dùng mới
    @Transactional
    public UserResponseRegisterDTO registerUser(UserRequestRegisterDTO userDto) throws AppException, ParseException {
        Optional<User> existedUser = userRepository.findByEmailPhone(userDto.getEmailPhone());
        if (existedUser.isPresent()) {
            throw new AppException("⚠️ Email hoặc số điện thoại đã được sử dụng.", HttpStatus.BAD_REQUEST.value());
        }
        String password = userDto.getPassword();
        String confirmPassword = userDto.getConfirmPassword();
        if (password != null && confirmPassword != null && !password.equals(confirmPassword)) {
            throw new AppException("Mật khẩu và mật khẩu xác nhận không khớp", HttpStatus.BAD_REQUEST.value());
        }

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = formatter.parse(userDto.getBirth());
        User newUser = User.builder()
                .password(encodedPassword)
                .emailPhone(userDto.getEmailPhone())
                .createdAt(new Date())
                .build();
        Profile profile = Profile.builder()
                .username(userDto.getUsername())
                .birth(dateOfBirth)
                .user(newUser)
                .build();
        userRepository.save(newUser);
        profileRepository.save(profile);
        ProfileResponseDTO profileResponse = ProfileResponseDTO.builder()
                .id(profile.getIdUser())
                .username(userDto.getUsername())
                .birth(profile.getBirth())
                .build();
        return UserResponseRegisterDTO.builder()
                .id(newUser.getId())
                .emailPhone(newUser.getEmailPhone())
                .createdAt(newUser.getCreatedAt())
                .profile(profileResponse)
                .build();
    }

// ✅ Đăng nhập người dùng
public UserResponseLoginDTO loginUser(UserRequestLoginDTO userDto) throws AppException {
    // 🔍 Tìm người dùng theo email hoặc số điện thoại
    Optional<User> existedUser = userRepository.findByEmailPhone(userDto.getEmailPhone());

    if (existedUser.isEmpty()) {
        throw new AppException("Email hoặc số điện thoại không tồn tại.", HttpStatus.BAD_REQUEST.value());
    }
    User user = existedUser.get();

    if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
        throw new AppException("Mật khẩu không đúng", HttpStatus.BAD_REQUEST.value());
    }

    Profile profile = profileRepository.findByUser(user).orElse(null);

    ProfileResponseDTO profileResponse = null;
    if (profile != null) {
        profileResponse = ProfileResponseDTO.builder()
                .id(profile.getIdUser())
                .username(profile.getUsername())
                .birth(profile.getBirth())
                .build();
    }


    return UserResponseLoginDTO.builder()
            .id(user.getId())
            .emailPhone(user.getEmailPhone())
            .profile(profileResponse)
            .build();
}

}
