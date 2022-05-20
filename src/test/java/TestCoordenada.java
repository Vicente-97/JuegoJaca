package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class TestCoordenada {
	
	@Test
	void testCoordenada() {
		Coordenada expected=new Coordenada(1,1);
		assertEquals(expected, true);
	}

}
