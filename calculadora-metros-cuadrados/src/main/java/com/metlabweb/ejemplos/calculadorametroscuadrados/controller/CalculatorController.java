package com.metlabweb.ejemplos.calculadorametroscuadrados.controller;

import com.metlabweb.ejemplos.calculadorametroscuadrados.calculator.SquareMetersCalculator;
import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.request.HouseDTO;
import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.response.ResponseEntityDTO;
import com.metlabweb.ejemplos.calculadorametroscuadrados.dto.response.ErrorDTO;
import com.metlabweb.ejemplos.calculadorametroscuadrados.service.ValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import java.util.Arrays;

@RestController
public class CalculatorController {

    ValidationService validationService=new ValidationService();

    @PostMapping
    @ResponseBody
    public ResponseEntity<ResponseEntityDTO> processHouse(@RequestBody HouseDTO houseDTO){
        try {
            validationService.validateInput(houseDTO);
            return new ResponseEntity<>(SquareMetersCalculator.caculate(houseDTO), HttpStatus.OK);
        } catch (BadAttributeValueExpException e) {
            return new ResponseEntity<>(ErrorDTO.builder().code(400001).reason("Los datos recibidos no se pueden procesar.").msg(e.toString()).build(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>( ErrorDTO.builder().code(999999).reason("Se produjo un problema.").msg(e.getMessage() +" --> "+ Arrays.toString(e.getStackTrace())).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
