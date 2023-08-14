package com.allan.helpdesk.resources.exceptions;

import com.allan.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.allan.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Entity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ResourceExceptionHandler {

    private LocalDateTime agora = LocalDateTime.now();
    private DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
    private String horaFormatada = formatterHora.format(agora);


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objctnotFoundException(ObjectNotFoundException ex,
                                                                HttpServletRequest request){

        StandardError error = new StandardError(horaFormatada, HttpStatus.NOT_FOUND.value(),"Object not found",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                HttpServletRequest request){

        StandardError error = new StandardError(horaFormatada, HttpStatus.BAD_REQUEST.value(),"Violação de Dados",
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
}
