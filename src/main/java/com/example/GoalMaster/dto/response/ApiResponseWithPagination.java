package com.example.GoalMaster.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponseWithPagination<T> {
    String message;
    int statusCode;
    boolean status;
    int page;
    int size;
    int totalPages;
    int totalElements;
    T data;
    Object errors;
}