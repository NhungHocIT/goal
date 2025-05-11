package com.example.GoalMaster.repository;

import com.example.GoalMaster.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
