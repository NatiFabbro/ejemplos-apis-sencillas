package com.metlabweb.ejemplos.diploma.dto.response;

import lombok.*;


@Getter @Setter
@ToString @Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO extends ResponseEntityDTO {
    private String message;
    private String student;
    private double average;

}
