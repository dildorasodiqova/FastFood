package uz.example.fastfood.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.example.fastfood.exception.BadRequestException;
import uz.example.fastfood.exception.DataAlreadyExistsException;
import uz.example.fastfood.exception.DataNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DataAlreadyExistsException.class)
    public ResponseEntity<String> dataAlreadyExists (DataAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());
    }


    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<String> dataNotFound (DataNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }


    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<String> badRequest(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }





}
