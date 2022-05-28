package com.metlabweb.ejemplos.diploma.service;

import com.metlabweb.ejemplos.diploma.dto.request.StudentDTO;
import com.metlabweb.ejemplos.diploma.dto.request.SubjectDTO;
import com.metlabweb.ejemplos.diploma.exception.BadRequestException;
import com.metlabweb.ejemplos.diploma.utils.Helper;

public class ValidationService {

    Helper helper=new Helper();

    public void validateInput (StudentDTO alumno) throws BadRequestException {
        if(alumno == null || (alumno.getName()==null && alumno.getSubjects()==null)){
            throw new BadRequestException("Debes enviar un alumno",5000001);
        }else if(alumno.getName()==null){
            throw new BadRequestException("El alumno debe tener nombre",5000002);
        } else if(alumno.getSubjects() == null || alumno.getSubjects().isEmpty()) {
            throw new BadRequestException("El alumno debe tener asignaturas",5000003);
        }else{
            boolean allWithinRange=true;
             boolean allPassed = true;
            boolean infoComplete = true;
            for (SubjectDTO asignatura :
                    alumno.getSubjects()) {
                if (asignatura.getGrade() == null) {
                    infoComplete = false;
                    break;
                } else if(asignatura.getGrade()<helper.getMinimumPossibleGrade() || asignatura.getGrade()> helper.getMaximumPossibleGrade()){
                    allWithinRange=false;
                    break;
            }else if(asignatura.getGrade()<helper.getMinimumGradeToPass()){
                    allPassed=false;
                    break;
                }
            }
            if(!infoComplete){
                throw new BadRequestException("Todas as asignaturas deben tener nota",5000004);
            }else if (!allWithinRange){
                throw new BadRequestException("Las notas ingresadas deben estar dentro del rango "+helper.getMinimumPossibleGrade() +" - "+helper.getMaximumPossibleGrade(),5000005);
            }else if (!allPassed){
                throw new BadRequestException("Para generar el diploma las notas de todas las materias deben ser mayor a "+helper.getMinimumGradeToPass(),5000006);
            }
        }
    }
}
