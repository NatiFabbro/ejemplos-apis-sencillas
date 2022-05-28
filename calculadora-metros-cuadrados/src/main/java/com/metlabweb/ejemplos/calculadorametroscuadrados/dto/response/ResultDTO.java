package com.metlabweb.ejemplos.calculadorametroscuadrados.dto.response;

import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request.RoomDTO;
import lombok.*;

import java.util.List;


@Getter @Setter
@ToString @Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO extends ResponseEntityDTO {
    private String name;
    private double totalSqareMeters;
    private double houseTotalPrice;
    private RoomDTO biggestRoom;
    private List<RoomDTO> sqareMetersPerRoom;
}
