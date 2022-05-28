# MeTLab Web

## Ejemplo de API para obtener personajes de *Star Wars*

### Casos para probar en postman**

#### 1) GET http://localhost:8080/character/darth

response: 

        {
            "characters": [
                {
                    "name": "Darth Vader",
                    "height": "202",
                    "mass": "136",
                    "hair_color": "none",
                    "skin_color": "white",
                    "eye_color": "yellow",
                    "birth_year": "41.9BBY",
                    "gender": "male",
                    "homeworld": "Tatooine",
                    "species": "Human"
                },
                {
                    "name": "Darth Maul",
                    "height": "175",
                    "mass": "80",
                    "hair_color": "none",
                    "skin_color": "red",
                    "eye_color": "yellow",
                    "birth_year": "54BBY",
                    "gender": "male",
                    "homeworld": "Dathomir",
                    "species": "Zabrak"
                }
            ]
        }

#### 2) GET http://localhost:8080/character/DARth

response: 

        {
            "characters": [
                {
                    "name": "Darth Vader",
                    "height": "202",
                    "mass": "136",
                    "hair_color": "none",
                    "skin_color": "white",
                    "eye_color": "yellow",
                    "birth_year": "41.9BBY",
                    "gender": "male",
                    "homeworld": "Tatooine",
                    "species": "Human"
                },
                {
                    "name": "Darth Maul",
                    "height": "175",
                    "mass": "80",
                    "hair_color": "none",
                    "skin_color": "red",
                    "eye_color": "yellow",
                    "birth_year": "54BBY",
                    "gender": "male",
                    "homeworld": "Dathomir",
                    "species": "Zabrak"
                }
            ]
        }

#### 3) GET http://localhost:8080/character/*

response:

        {
            "error": {
                "code": 100001,
                "reason": "No se pudo encontrar el recurso solicitado",
                "msg": "No se encontraron personajes con la key *"
            }
        }