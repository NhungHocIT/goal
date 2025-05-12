package com.example.GoalMaster.controller.v1;

import com.example.GoalMaster.dto.request.GoalCreateUpdateRequestDTO;
import com.example.GoalMaster.dto.response.ApiResponse;
import com.example.GoalMaster.dto.response.GoalResponseDTO;
import com.example.GoalMaster.dto.response.UserResponseRegisterDTO;
import com.example.GoalMaster.entity.Goal;
import com.example.GoalMaster.exception.AppException;
import com.example.GoalMaster.service.GoalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller quản lý các API liên quan đến mục tiêu (Goals)
 * Controller that manages APIs related to goals
 */
@RestController
@RequestMapping("/api/v1/goals")
public class GoalController {

    private final GoalService goalService;

    // Constructor injection
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<GoalResponseDTO>> createGoal(@Valid @RequestBody GoalCreateUpdateRequestDTO goalRequest) throws AppException {
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<GoalResponseDTO>builder()
                        .status(true)
                        .statusCode(HttpStatus.OK.value())
                        .message("✅ Them moi thanh cong!")
                        .data(goalService.createGoal(goalRequest))
                        .build()
        );
    }
}
