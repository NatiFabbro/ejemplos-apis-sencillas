# MeTLab Web

## Ejemplo de API para generar diplomas para alumnos

### Casos para probar en Postman:

#### 1) http://localhost:8080/generateDiploma 
Aprobado

request:

      {
         "name":"Harry Potter",
         "subjects":[
            {
               "name":"Defensa contra las artes oscuras",
               "grade":7.5
            },{
               "name":"Pociones",
               "grade":10
            }
         ]
      }

response:

      {
         "message": "Aprobado.",
         "student": "Harry Potter",
         "average": 8.75
      }

#### 2) http://localhost:8080/generateDiploma
   Aprobado con felicitaciones
   
request:

      {
         "name":"Hermione Granger",
         "subjects":[
            {
               "name":"Defensa contra las artes oscuras",
               "grade":10
            },{
               "name":"Pociones",
               "grade":9
            }
         ]
      }

response:

      {
         "name":"Hermione Granger",
         "subjects":[
            {
               "name":"Defensa contra las artes oscuras",
               "grade":10
            },{
               "name":"Pociones",
               "grade":9
            }
         ]
      }

#### 3) http://localhost:8080/generateDiploma
   No Aprobado

request:

      {
         "name":"Ronald Weasley",
         "subjects":[
            {
               "name":"Defensa contra las artes oscuras",
               "grade":5
            },{
               "name":"Pociones",
               "grade":4
            }
         ]
      }

response:

      {
         "code": 5000006,
         "reason": "Los datos recibidos no se pueden procesar",
         "msg": "Para generar el diploma las notas de todas las materias deben ser mayor a 6.0"
      }

#### 4) http://localhost:8080/generateDiploma
   Faltan datos

request:

      {
         "subjects":[
            {
               "name":"Defensa contra las artes oscuras",
               "grade":5
            },{
               "name":"Pociones",
               "grade":4
            }
         ]
      }

response:

      {
         "code": 5000002,
         "reason": "Los datos recibidos no se pueden procesar",
         "msg": "El alumno debe tener nombre"
      }
