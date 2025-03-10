package com.arqueobd.arqueobdrf.error.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

//clase que servirá como plantilla para mostrar errores/excepciones
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    //tipo de error que ocurre en la conexión
    private HttpStatus status;
    //mensaje personalizado del error
    private String message;
}
