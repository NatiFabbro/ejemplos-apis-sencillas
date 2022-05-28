package com.metlabweb.ejemplos.diploma.controller;

import com.metlabweb.ejemplos.diploma.calculator.DiplomaCalculator;
import com.metlabweb.ejemplos.diploma.dto.request.StudentDTO;
import com.metlabweb.ejemplos.diploma.dto.response.ErrorDTO;
import com.metlabweb.ejemplos.diploma.dto.response.ResponseEntityDTO;
import com.metlabweb.ejemplos.diploma.exception.BadRequestException;
import com.metlabweb.ejemplos.diploma.service.ValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class DiplomaController {

    ValidationService validationService=new ValidationService();

    @PostMapping("/generateDiploma")
    @ResponseBody
    public ResponseEntity<ResponseEntityDTO> generateDiploma(@RequestBody StudentDTO student){
        try {
            validationService.validateInput(student);
            return new ResponseEntity<>(DiplomaCalculator.calculate(student), HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(ErrorDTO.builder().code(e.getCode()).reason(e.getReason()).msg(e.getMessage()).build(),HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>( ErrorDTO.builder().code(999999).reason("Se produjo un problema.").msg(e.getMessage() +" --> "+ Arrays.toString(e.getStackTrace())).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
