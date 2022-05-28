package com.metlabweb.ejemplos.diploma.dto.request;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private String name;
    private List<SubjectDTO> subjects;
}
