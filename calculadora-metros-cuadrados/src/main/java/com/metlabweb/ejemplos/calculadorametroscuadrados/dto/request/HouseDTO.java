package com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request;

import lombok.*;
import java.util.List;

@Getter @Setter
@ToString @Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    private String name;
    private String address;
    private List<RoomDTO> rooms;
}
