package com.metlabweb.ejemplos.diploma.exception;

import lombok.Getter;
import lombok.Setter;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = 3105272988000493123L;
    @Getter @Setter
    private int code;
    @Getter @Setter
    private String reason="Los datos recibidos no se pueden procesar";

    public BadRequestException(String message, int code) {
        super(message);
        this.code=code;
    }
    public BadRequestException(int code) {
        super();
        this.code=code;
    }
}
