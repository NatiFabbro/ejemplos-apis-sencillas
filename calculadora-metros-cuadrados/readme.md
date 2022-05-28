# MeTLab Web

## Ejemplo de API para calcular metros cuadrados

### Casos para probar desde postman:

#### 1) OK POST http://localhost:8080

   request:

      {
         "name":"Malfoy Manor",
         "address":"Information not available for muggles",
         "rooms":[
            {
               "name":"Dining Room",
               "width":7.5,
               "length":15
            },
            {
               "name":"Kitchen",
               "width":3.5,
               "length":10
            },        
            {
               "name":"Dungeon",
               "width":7,
               "length":5.5
            },        
            {
               "name":"Lucius and Narcisa's Bedroom",
               "width":5,
               "length":7
            },        
            {
               "name":"Draco's Bedroom",
               "width":4,
               "length":6
            }
         ]
      }
   
Response:

      {
         "name": "Malfoy Manor",
         "totalSqareMeters": 245.0,
         "houseTotalPrice": 196000.0,
         "biggestRoom": {
            "name": "Dining Room",
            "width": 7.5,
            "length": 15.0,
            "area": 112.5
         },
         "sqareMetersPerRoom": [
            {
               "name": "Dining Room",
               "width": 7.5,
               "length": 15.0,
               "area": 112.5
            },
            {
               "name": "Kitchen",
               "width": 3.5,
               "length": 10.0,
               "area": 35.0
            },
            {
               "name": "Dungeon",
               "width": 7.0,
               "length": 5.5,
               "area": 38.5
            },
            {
               "name": "Lucius and Narcisa's Bedroom",
               "width": 5.0,
               "length": 7.0,
               "area": 35.0
            },
            {
                  "name": "Draco's Bedroom",
                  "width": 4.0,
                  "length": 6.0,
                  "area": 24.0
            }
         ]
      }

#### 2) Casa sin habitaciones POST http://localhost:8080

request:

      {
         "name":"Malfoy Manor",
         "address":"Information not available for muggles",
         "rooms":[
         ]
      }

response:

      {
         "code": 400001,
         "reason": "Los datos recibidos no se pueden procesar.",
         "msg": "BadAttributeValueException: La casa debe tener habitaciones"
      }

#### 3) Casa sin nombre POST http://localhost:8080

request:

      {
         "address":"Information not available for muggles",
         "rooms":[
            {
               "name":"Kitchen",
               "width":3.5,
               "length":10
            },        
            {
               "name":"Dungeon",
               "width":7,
               "length":5.5
            }
         ]
      }

response:

      {
         "code": 400001,
         "reason": "Los datos recibidos no se pueden procesar.",
         "msg": "BadAttributeValueException: La casa debe tener nombre"
      }

#### 4) No es una casa POST http://localhost:8080

request: 

      {
         "id":1,
         "value":"test"
      }

response: 

      {
         "code": 400001,
         "reason": "Los datos recibidos no se pueden procesar.",
         "msg": "BadAttributeValueException: Debes enviar una casa"
      }

#### 5) Faltan medidas en alguna habitacíón POST http://localhost:8080
   
request:

      {
         "name":"Malfoy Manor",
         "address":"Information not available for muggles",
         "rooms":[       
            {
               "name":"Dungeon",
               "length":5.5
            }
         ]
      }

response:

      {
         "code": 400001,
         "reason": "Los datos recibidos no se pueden procesar.",
         "msg": "BadAttributeValueException: Todas as habitaciones de la casa deben tener medidas"
      }