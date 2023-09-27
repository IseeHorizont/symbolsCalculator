package ru.t1.task.symbolscalculator.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.t1.task.symbolscalculator.web.response.ErrorResponse;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String LINE_VALIDATION_ERROR = "Ошибка валидации входных данных";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            @NonNull final ConstraintViolationException ex
    ) {
        log.error("Ошибка валидации входных данных: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.builder()
                .errorMessage(LINE_VALIDATION_ERROR)
                .moreInformation(ex.getMessage())
                .build());
    }
}
