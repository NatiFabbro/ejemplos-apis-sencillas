package com.metlabweb.ejemplos.calculadorametroscuadrados.utils;

import lombok.Getter;
import org.springframework.context.ApplicationContextException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Helper {

    private final String PROPERTIES_FILE_PATH="spring_2/calculadora-metros-cuadrados/src/main/resources/application.properties";

    @Getter
    private Properties properties;

    @Getter
    private double pricePerSqareMeter;

    public Helper() {
        try{
            properties = new Properties();
            properties.load(new FileInputStream(PROPERTIES_FILE_PATH));

            pricePerSqareMeter = Double.parseDouble(properties.getProperty("square-meter-price"));
        }catch (Exception e){
            throw new ApplicationContextException("No es posible obtener las configuraciones");
        }
    }
}
