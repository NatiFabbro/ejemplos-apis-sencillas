package com.metlabweb.ejemplos.practicacodigomorse.converter;

import com.metlabweb.ejemplos.practicacodigomorse.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MorseToASCIIConverter implements  Iconverter{

    public String convert(String cadena){
        String result="";
        List<String> palabras=separarPalabras(cadena);

        for (String palabra : palabras) {
            List<String> letras= separarLetras(palabra);

            for (String letra: letras) {
                result=result.concat(convertirLetra(letra));
            }
            result=result.concat(" ");
        }
        return result.stripTrailing();
    }

    private List<String> separarPalabras(String cadena){
        return Arrays.stream((cadena.split(" {3}"))).collect(Collectors.toList());
    }

    private  List<String> separarLetras(String palabra){
         return Arrays.stream((palabra.split(" "))).collect(Collectors.toList());
    }

    private String convertirLetra(String morseCharacter){
        return Utils.ASCIIEquivalent().get(morseCharacter);
    }
}
