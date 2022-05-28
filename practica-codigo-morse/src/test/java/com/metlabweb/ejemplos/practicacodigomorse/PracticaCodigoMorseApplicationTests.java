package com.metlabweb.ejemplos.practicacodigomorse;

import com.metlabweb.ejemplos.practicacodigomorse.controller.MorseCodeController;
import com.metlabweb.ejemplos.practicacodigomorse.converter.ASCIIToMorseConverter;
import com.metlabweb.ejemplos.practicacodigomorse.converter.MorseToASCIIConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = PracticaCodigoMorseApplication.class)
class PracticaCodigoMorseApplicationTests {

	@Test
	public void contextLoads() {
		assertThat(new MorseCodeController()).isNotNull();
	}

	@Test
	void converter() {
		ASCIIToMorseConverter asciiToMorseConverter=new ASCIIToMorseConverter();
		MorseToASCIIConverter morseToASCIIConverter=new MorseToASCIIConverter();

		String cadena= "Hola Mundo";

		String convertidaAMorse= asciiToMorseConverter.convert(cadena);
		String reconvertidaAASCII=morseToASCIIConverter.convert(convertidaAMorse);

		assertThat(reconvertidaAASCII).isEqualTo(cadena.toUpperCase());
	}

}
