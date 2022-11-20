package com.webtecnology.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.webtecnology.app.exceptions.ModelNotFoundException;

import com.webtecnology.app.dto.*;

public class ExceptionController {
    @ExceptionHandler({ModelNotFoundException.class})
	    public ResponseEntity<ErrorResponseDTO> notModelException(HttpServletRequest peticion, ModelNotFoundException ex){
	        
	        return construirResponse(peticion,HttpStatus.NOT_FOUND,ex.getMessage(),null);
	    }
	    
	    @ExceptionHandler({ConstraintViolationException.class})
	    public ResponseEntity<ErrorResponseDTO> invalidDataException(HttpServletRequest peticion,ConstraintViolationException ex){
	        List<ValidationErrorDTO> errores = new ArrayList<>();
	        
	        for(ConstraintViolation violation :ex.getConstraintViolations() ) {
	            ValidationErrorDTO err = new ValidationErrorDTO(violation.getPropertyPath().toString(),violation.getMessage());
	            errores.add(err);
	        }
	        return construirResponse(peticion,HttpStatus.BAD_REQUEST,"Error de validacion de datos",errores);
	    }
	    
	    ResponseEntity<ErrorResponseDTO> construirResponse(HttpServletRequest peticion,HttpStatus status, String mensaje,List<ValidationErrorDTO> errores ){
	        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
	        errorResponseDTO.setMensaje(mensaje);
	        errorResponseDTO.setCodigoEstado(status.value());
	        errorResponseDTO.setPath(peticion.getRequestURI());
	        errorResponseDTO.setErrores(errores);
	        return new ResponseEntity<>(errorResponseDTO,status);
	    }
}
