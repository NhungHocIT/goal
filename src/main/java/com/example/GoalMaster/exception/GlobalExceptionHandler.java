package com.example.GoalMaster.exception;

import com.example.GoalMaster.dto.response.ApiResponse;
import lombok.Setter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = RuntimeException.class)
//    public ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                ApiResponse.builder()
//                        .status(false)
//                        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                        .message("Có lỗi xảy ra ở phía server.")
//                        .build()
//        );
//    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<Object>> handleAppException(AppException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse.builder()
                        .status(false)
                        .statusCode(ex.getStatusCode())
                        .message(ex.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(ValidationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse.builder()
                        .status(false)
                        .statusCode(ex.getStatusCode())
                        .message(ex.getMessage())
                        .errors(ex.getErrors())
                        .build()
        );
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(
                ApiResponse.builder()
                        .status(false)
                        .statusCode(HttpStatus.METHOD_NOT_ALLOWED.value())
                        .message("Request với method không được hỗ trợ.")
                        .build()
        );
    }
//    @ExceptionHandler(value = MultipartException.class)
//    public ResponseEntity<ApiResponse<Object>> handleMultipartException(MultipartException ex) {
//        ErrorCode errorCode = ErrorCode.MULTIPART_FILE_NULL;
//        return ResponseEntity.badRequest().body(
//                ApiResponse.builder()
//                        .status(false)
//                        .statusCode(errorCode.getCode())
//                        .message(errorCode.getMessage())
//                        .build()
//        );
//    }

//    @ExceptionHandler(value = AccessDeniedException.class)
//    public ResponseEntity<ApiResponse<Object>> handleAccessDeniedException(AccessDeniedException ex) {
//        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
//                ApiResponse.builder()
//                        .status(false)
//                        .statusCode(errorCode.getCode())
//                        .message(errorCode.getMessage())
//                        .build()
//        );
//    }

    //Exception dau vao cua request mà client gui len server invalid
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Duyệt qua các lỗi và thêm vào Map
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField(); // Lấy tên field bị lỗi
            String errorMessage = error.getDefaultMessage();   // Lấy message lỗi
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .status(false)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .errors(errors)
                        .build()
        );
    }
}
