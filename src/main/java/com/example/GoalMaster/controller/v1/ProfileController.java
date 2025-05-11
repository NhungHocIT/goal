package com.example.GoalMaster.controller.v1;

import com.example.GoalMaster.dto.request.ProfileRequestDto;
import com.example.GoalMaster.entity.Profile;
import com.example.GoalMaster.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

//    @Autowired
//    private ProfileRepository profileRepository;
//
//    // ✅ Lấy thông tin profile theo user ID
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getProfile(@PathVariable Long id) {
//        Optional<Profile> profile = profileRepository.findById(id);
//        return profile.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // ✅ Cập nhật thông tin cá nhân
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody ProfileRequestDto dto) {
//        Optional<Profile> optionalProfile = profileRepository.findById(id);
//        if (optionalProfile.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Profile profile = optionalProfile.get();
//        profile.setUsername(dto.getUsername());
//        profile.setAvata_url(dto.getAvatarUrl());
//        profile.setAnhbia(dto.getCoverImageUrl());
//        profile.setBio(dto.getBio());
//        profile.setBirth(dto.getBirth());
//
//        profileRepository.save(profile);
//        return ResponseEntity.ok("Cập nhật thành công!");
//    }
}
