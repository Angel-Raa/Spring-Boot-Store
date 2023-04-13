package con.caja.ideal.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BadRequestExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationError(MethodArgumentNotValidException error) {
        Map<String, String> errorMessage = new HashMap<>();
        error.getBindingResult().getFieldErrors().forEach(
                err -> {
                    errorMessage.put(err.getField(), "Campo no valido ");
                }
        );
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleMessage(HttpMessageNotReadableException e){
        return new ResponseEntity<>("Field cannot is empty ", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> notFound(ResourceNotFoundException e){
        Map<String, String> errors = new HashMap<>();
        errors.put(e.message, "not valid ");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Object> expired(ExpiredJwtException e){
        Map<String, String> errors = new HashMap<>();
        errors.put(e.getMessage(), "JWT expired ");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<Object> incorrectResultSize(IncorrectResultSizeDataAccessException e){
        Map<String, String> errors = new HashMap<>();
        errors.put(e.getLocalizedMessage(), "Error ");
        return ResponseEntity.badRequest().body(errors);
    }

}
