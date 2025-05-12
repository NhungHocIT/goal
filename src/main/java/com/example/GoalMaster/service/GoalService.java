package com.example.GoalMaster.service;
import com.example.GoalMaster.dto.request.GoalCreateUpdateRequestDTO;
import com.example.GoalMaster.dto.response.GoalResponseDTO;
import com.example.GoalMaster.entity.Goal;
import com.example.GoalMaster.entity.User;
import com.example.GoalMaster.exception.AppException;
import com.example.GoalMaster.repository.GoalRepository;
import com.example.GoalMaster.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;
    public GoalService(GoalRepository goalRepository, UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }
    public GoalResponseDTO createGoal(GoalCreateUpdateRequestDTO request) throws AppException {
        Long userId = request.getUserId();
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new AppException("User not found", HttpStatus.BAD_REQUEST.value());
        }
        Goal goal = Goal.builder()
                .title(request.getTitle())
                .describe(request.getDescribe())
                .createdAt(new Date())
                .status("Chưa hoan thành")
                .start_date(new Date())
                .end_date(new Date())
                .user(userOptional.get())
                .build();
        goalRepository.save(goal);
        return  GoalResponseDTO.builder()
                .id(goal.getIdGoals())
                .title(goal.getTitle())
                .describe(goal.getDescribe())
                .status(goal.getStatus())
                .start_date(goal.getStart_date())
                .end_date(goal.getEnd_date())
                .build();
    }
}

