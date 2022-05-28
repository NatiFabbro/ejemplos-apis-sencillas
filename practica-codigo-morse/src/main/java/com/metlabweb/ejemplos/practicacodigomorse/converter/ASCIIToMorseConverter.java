package com.metlabweb.ejemplos.practicacodigomorse.converter;


import com.metlabweb.ejemplos.practicacodigomorse.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ASCIIToMorseConverter implements Iconverter {

    public String convert(String cadena){
        String result="";
        List<String> palabras=separarPalabras(cadena.toUpperCase());

        for (String palabra : palabras) {
            List<String> letras= separarLetras(palabra);

            for (String letra: letras) {
                result=result.concat(convertirLetra(letra));
                result=result.concat(" ");
            }
            result=result.stripTrailing();
            result=result.concat("   ");
        }
        return result.stripTrailing();
    }

    private List<String> separarPalabras(String cadena){
        List<String> palabras= Arrays.stream((cadena.split(" "))).collect(Collectors.toList());
        palabras.forEach(x->x=x.trim());
        return palabras;
    }

    private List<String> separarLetras(String palabra){
        return Arrays.stream((palabra.split(""))).collect(Collectors.toList());
    }

    private String convertirLetra(String morseCharacter){
        return Utils.morseEquivalent().get(morseCharacter);
    }
}
