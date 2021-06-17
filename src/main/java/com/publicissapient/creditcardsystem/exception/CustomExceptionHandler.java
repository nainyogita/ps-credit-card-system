package com.publicissapient.creditcardsystem.exception;

import com.publicissapient.creditcardsystem.web.rs.AccountResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.time.ZonedDateTime;

/**
 * Global custom application Exception Handler
 */
@ControllerAdvice
public class CustomExceptionHandler {

    Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * Custom exception handler for Validation Exception
     *
     * @param e RequestValidationException
     * @return ResponseEntity with 400 BadRequest status
     */
    @ExceptionHandler(value = {ValidationException.class})
    public ResponseEntity<Object> handleValidationException(ValidationException e) {

        logger.error("Exception Thrown :: \n Type-> " + e.getClass().getName() + " \n Message -> " + e.getMessage());

        CustomException apiException = new CustomException(
                ContractErrorCodes.INVALID_REQUEST_PARAM.getErrorCode(),
                ContractErrorCodes.INVALID_REQUEST_PARAM.getDescription(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    /**
     * Custom exception handler for Card Validation Exception
     *
     * @param e CardValidationException
     * @return ResponseEntity with 400 BadRequest status
     */
    @ExceptionHandler(value = {CardValidationException.class})
    public ResponseEntity<Object> handleCardValidationException(CardValidationException e) {

        logger.error("Exception Thrown :: \n Type-> " + e.getClass().getName());

        CustomException apiException = new CustomException(
                ContractErrorCodes.INVALID_CREDIT_CARD_NUMBER.getErrorCode(),
                ContractErrorCodes.INVALID_CREDIT_CARD_NUMBER.getDescription(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    /**
     * Custom exception handler for Entity Not Found
     *
     * @param e EntityNotFoundException
     * @return ResponseEntity with 404 NOT_FOUND status
     */
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {

        logger.error("Exception Thrown :: \n Type -> " + e.getClass().getName());

        CustomException apiException = new CustomException(
                ContractErrorCodes.ENTITY_NOT_FOUND.getErrorCode(),
                ContractErrorCodes.ENTITY_NOT_FOUND.getDescription(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }


    /**
     * Custom Exception handler for other Exceptions
     *
     * @param e IllegalStateException, Exception
     * @return Response Entity with 500 Internal Server Error
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleDefaultException(Exception e) {
        logger.error("Exception Thrown :: \n Type -> " + e.getClass().getName() + "\n Message -> " + e.getMessage());

        CustomException apiException = new CustomException(
                UnexpectedErrorCodes.UNEXPECTED_TECHNICAL_ERROR.getErrorCode(),
                UnexpectedErrorCodes.UNEXPECTED_TECHNICAL_ERROR.getDescription(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
