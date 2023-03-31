package dev.vitorvidal.udemykafkaproducer.udemykafka.controller

import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.stream.Collectors

@Slf4j
@ControllerAdvice
class LibraryEventControllerAdvice {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleRequestBody(ex: MethodArgumentNotValidException): ResponseEntity<String> {
        val errorList = ex.bindingResult.fieldErrors
        val errorMessage = errorList.stream()
            .map { fieldError -> fieldError.field + " - " + fieldError.defaultMessage }
            .sorted()
            .collect(Collectors.joining(","))
        log.info("Error message: {}", errorMessage)
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}