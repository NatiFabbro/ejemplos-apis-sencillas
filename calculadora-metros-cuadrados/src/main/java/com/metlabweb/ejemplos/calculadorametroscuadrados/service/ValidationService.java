package com.metlabweb.ejemplos.calculadorametroscuadrados.service;

import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request.HouseDTO;
import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request.RoomDTO;

import javax.management.BadAttributeValueExpException;

public class ValidationService {

    public void validateInput (HouseDTO houseDTO) throws BadAttributeValueExpException {
        if(houseDTO == null || (houseDTO.getName()==null && houseDTO.getAddress()==null && houseDTO.getRooms()==null)){
            throw new BadAttributeValueExpException("Debes enviar una casa");
        }else if(houseDTO.getName()==null){
            throw new BadAttributeValueExpException("La casa debe tener nombre");
        } else if(houseDTO.getRooms() == null || houseDTO.getRooms().isEmpty()) {
            throw new BadAttributeValueExpException("La casa debe tener habitaciones");
        }else{
             boolean validRooms = true;
            for (RoomDTO room :
                    houseDTO.getRooms()) {
                if(room.getWidth()==null || room.getLength()==null){
                    validRooms=false;
                    break;
                }
            }
            if(validRooms){
                houseDTO.getRooms().forEach(roomDTO -> roomDTO.setArea(roomDTO.getWidth()* roomDTO.getLength()));
            }else{
                throw new BadAttributeValueExpException("Todas as habitaciones de la casa deben tener medidas");
            }
        }
    }
}
