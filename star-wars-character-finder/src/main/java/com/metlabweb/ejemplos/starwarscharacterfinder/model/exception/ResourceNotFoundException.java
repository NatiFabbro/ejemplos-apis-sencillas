package com.metlabweb.ejemplos.starwarscharacterfinder.model.exception;

import lombok.Getter;
import lombok.Setter;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 3105272988000493123L;
    @Getter @Setter
    private int code;
    @Getter @Setter
    private String reason="No se pudo encontrar el recurso solicitado";

    public ResourceNotFoundException(String message, int code) {
        super(message);
        this.code=code;
    }
    public ResourceNotFoundException(int code) {
        super();
        this.code=code;
    }
}
