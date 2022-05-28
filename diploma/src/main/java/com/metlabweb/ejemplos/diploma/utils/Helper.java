package com.metlabweb.ejemplos.diploma.utils;

import lombok.Getter;
import org.springframework.context.ApplicationContextException;

import java.io.FileInputStream;
import java.util.Properties;

public class Helper {

    private final String PROPERTIES_FILE_PATH="spring_2/diploma/src/main/resources/application.properties";

    @Getter
    private Properties properties;

    @Getter
    private double minimumGradeToPass;
    @Getter
    private double minimumGradeToCongrat;
    @Getter
    private double minimumPossibleGrade;
    @Getter
    private double maximumPossibleGrade;
    @Getter
    private String congratsMessage;
    @Getter
    private String regularMessage;

    public Helper() {
        try{
            properties = new Properties();
            properties.load(new FileInputStream(PROPERTIES_FILE_PATH));

            minimumPossibleGrade = Double.parseDouble(properties.getProperty("min-possible-grade"));
            maximumPossibleGrade = Double.parseDouble(properties.getProperty("max-possible-grade"));
            minimumGradeToPass = Double.parseDouble(properties.getProperty("min-grade-to-pass"));
            minimumGradeToCongrat = Double.parseDouble(properties.getProperty("min-grade-to-congrat"));
            congratsMessage = properties.getProperty("congrats-message");
            regularMessage =  properties.getProperty("regular-message");

        }catch (Exception e){
            throw new ApplicationContextException("No es posible obtener las configuraciones");
        }
    }
}
