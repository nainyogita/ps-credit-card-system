package com.publicissapient.creditcardsystem.exception;

import com.publicissapient.creditcardsystem.web.rs.AccountResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.ZonedDateTime;

/**
 * Global custom application Exception Handler
 */
@ControllerAdvice
public class CustomExceptionHandler {

    Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * Custom exception handler for Bad Requests
     *
     * @param e1 RequestValidationException
     * @return ResponseEntity with 400 BadRequest status
     */
    @ExceptionHandler(value = {RequestValidationException.class, ConstraintViolationException.class})
    public ResponseEntity<Object> handleValidationException(RequestValidationException e1) {
        logger.error("Exception Thrown :: \n Type-> " + e1.getClass().getName() + " \n Message -> " + e1.getMessage());
        CustomException apiException = new CustomException(
                e1.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    /**
     * Custom exception handler for Entity Not Found
     *
     * @param e2 EntityNotFoundException
     * @return ResponseEntity with 404 NOT_FOUND status
     */
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e2) {
        logger.error("Exception Thrown :: \n Type -> " + e2.getClass().getName() + " \n Message -> " + e2.getMessage());
        CustomException apiException = new CustomException(
                e2.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    /**
     * Custom Default Exception handler
     *
     * @param e Exception
     * @return Response Entity with 500 Internal Server Error
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleDefaultException(Exception e) {
        logger.error("Exception Thrown :: \n Type -> " + e.getClass().getName() + "\n Message -> " + e.getMessage());
        //String errMessage = "Oops! Something went wrong.";
        CustomException apiException = new CustomException(
                e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
