package com.example.GoalMaster.repository;

import com.example.GoalMaster.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}
