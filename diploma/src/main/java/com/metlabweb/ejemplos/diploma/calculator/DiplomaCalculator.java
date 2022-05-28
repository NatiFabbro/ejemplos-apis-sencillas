package com.metlabweb.ejemplos.diploma.calculator;

import com.metlabweb.ejemplos.diploma.dto.request.StudentDTO;
import com.metlabweb.ejemplos.diploma.dto.request.SubjectDTO;
import com.metlabweb.ejemplos.diploma.dto.response.ResultDTO;
import com.metlabweb.ejemplos.diploma.utils.Helper;

import java.util.List;

public class DiplomaCalculator {

    static Helper helper=new Helper();

    public static ResultDTO calculate(StudentDTO studentDTO){
        double average=getAverage(studentDTO.getSubjects());
        return ResultDTO.builder()
                .student(studentDTO.getName())
                .average(average)
                .message(getMessage(average))
                .build();
    }

    public static double getAverage(List<SubjectDTO> asignaturas){
        double[] totalNotas={0};
        asignaturas.forEach(asignatura-> totalNotas[0]+=asignatura.getGrade());
        return totalNotas[0]/asignaturas.size();
    }

    public static String getMessage(double average){
        if (average>=helper.getMinimumGradeToCongrat()){
            return helper.getCongratsMessage();
        }else{
            return helper.getRegularMessage();
        }
    }
}
