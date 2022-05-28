package com.metlabweb.ejemplos.starwarscharacterfinder.controller;

import com.metlabweb.ejemplos.starwarscharacterfinder.model.ErrorDTO;
import com.metlabweb.ejemplos.starwarscharacterfinder.model.ResponseDTO;
import com.metlabweb.ejemplos.starwarscharacterfinder.model.exception.ResourceNotFoundException;
import com.metlabweb.ejemplos.starwarscharacterfinder.service.ICharacterFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterFinderController {

    @Autowired
    ICharacterFinder characterFinderService;

    @GetMapping("/{key}")
    public ResponseEntity<ResponseDTO> findByKey(@PathVariable String key){
        try{
            return new ResponseEntity<>(ResponseDTO.builder()
                    .characters(characterFinderService.findCharactersByKey(key))
                    .build(), HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(ResponseDTO.builder()
                    .error(ErrorDTO.builder()
                            .code(e.getCode())
                            .reason(e.getReason())
                            .msg(e.getMessage()).build())
                    .build(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(ResponseDTO.builder()
                    .error(ErrorDTO.builder()
                            .code(999999)
                            .reason("Se produjo un error")
                            .msg(e.getMessage()).build())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
