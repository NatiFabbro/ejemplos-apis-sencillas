package com.metlabweb.ejemplos.starwarscharacterfinder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CharacterDTO> characters;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorDTO error;
}
