package com.metlabweb.ejemplos.diploma.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private String name;
    private Double grade;
}
