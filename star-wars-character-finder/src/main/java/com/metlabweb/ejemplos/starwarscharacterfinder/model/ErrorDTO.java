package com.metlabweb.ejemplos.starwarscharacterfinder.model;

import lombok.*;

@Getter @Setter
@Builder @ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private int code;
    private String reason;
    private String msg;
}
