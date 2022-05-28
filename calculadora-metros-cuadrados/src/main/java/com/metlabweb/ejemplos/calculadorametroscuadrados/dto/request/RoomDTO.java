package com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request;

import lombok.*;

@Getter @Setter
@ToString @Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String name;
    private Double width;
    private Double length;
    private Double area;

}
