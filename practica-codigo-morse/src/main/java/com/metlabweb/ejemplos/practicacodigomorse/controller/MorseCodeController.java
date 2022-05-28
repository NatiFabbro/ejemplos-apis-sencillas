package com.metlabweb.ejemplos.practicacodigomorse.controller;

import com.metlabweb.ejemplos.practicacodigomorse.converter.ASCIIToMorseConverter;
import com.metlabweb.ejemplos.practicacodigomorse.converter.Iconverter;
import com.metlabweb.ejemplos.practicacodigomorse.converter.MorseToASCIIConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/translator")
public class MorseCodeController {

    Iconverter converter;

    @GetMapping(path = "/ASCIItoMorseCode/{cadena}")
    public String ASCIIoMorseCode(@PathVariable String cadena){
        try{
            converter= new ASCIIToMorseConverter();
            return converter.convert(cadena);
        }catch (Exception e){
            return "La cadena "+cadena+" no pudo ser convertida";
        }
    }

    @GetMapping(path = "/morseCodeToASCII/{cadena}")
    public String morseCodetoASCII(@PathVariable String cadena){
        try{
            converter= new MorseToASCIIConverter();
            return converter.convert(cadena);
        }catch (Exception e){
            return "La cadena "+cadena+" no pudo ser convertida";
        }
    }
}
