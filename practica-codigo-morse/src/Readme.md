# MeTLab Web

## Ejemplo de API para convertir codigo morse a ASCII y viceversa

### Casos para probar

#### 1) http://localhost:8080/translator/ASCIItoMorseCode/{cadenaASCII}
Request
        
        http://localhost:8080/translator/ASCIItoMorseCode/METLABWEB

Response

        -- . - .-.. .- -... .-- . -...

#### 2) http://localhost:8080/translator/morseCodeToASCII/{cadenaMorse}

Request

        http://localhost:8080/translator/morseCodeToASCII/-- . - .-.. .- -... .-- . -...

Response
    
        METLABWEB