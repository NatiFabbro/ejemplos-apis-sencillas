package com.metlabweb.ejemplos.calculadorametroscuadrados.calculator;

import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.response.ResultDTO;
import com.metlabweb.ejemplos.calculadorametroscuadrados.utils.Helper;
import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request.HouseDTO;
import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request.RoomDTO;

import java.util.*;

public class SquareMetersCalculator {

    public static Helper helper=new Helper();

    public static ResultDTO caculate (HouseDTO houseDTO){
        double totalSquareMeters= getTotalSqareMeters(houseDTO);

        return ResultDTO.builder()
                .name(houseDTO.getName())
                .totalSqareMeters(totalSquareMeters)
                .sqareMetersPerRoom(houseDTO.getRooms())
                .houseTotalPrice(getPrice(totalSquareMeters))
                .biggestRoom(getBiggestRoom(houseDTO.getRooms()))
                .build();
    }

    public static double getTotalSqareMeters(HouseDTO houseDTO){
        final double[] totalSquareMeters = {0};
        houseDTO.getRooms().forEach((room)-> totalSquareMeters[0] +=room.getArea());
        return totalSquareMeters[0];
    }

    public static double getPrice(double totalSquareMeters){
        double pricePerSqareMeter=helper.getPricePerSqareMeter();
        return pricePerSqareMeter*totalSquareMeters;
    }

    public static RoomDTO getBiggestRoom(List<RoomDTO> rooms){
        return rooms.stream().max(Comparator.comparingDouble(RoomDTO::getArea)).get();
    }

}
