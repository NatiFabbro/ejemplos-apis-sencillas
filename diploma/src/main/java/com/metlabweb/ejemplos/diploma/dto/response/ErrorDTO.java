package com.metlabweb.ejemplos.diploma.dto.response;

import lombok.*;

@Getter @Setter
@Builder @ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO extends ResponseEntityDTO {
    private int code;
    private String reason;
    private String msg;
}
