package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import elementos.Coordenada;

class TestCoordenada {

	Coordenada coordenada1 = new Coordenada(1,1);
	Coordenada coordenada2 = new Coordenada(-1,-1);
	Coordenada coordenada3 = new Coordenada(1,-1);
	Coordenada coordenada4 = new Coordenada(-1,1);
	
	
	@Test
	void testCoordenadaBien() {
		Coordenada coordenada1 = new Coordenada(1,1);
		
		assertEquals(coordenada1.getX(), 1);
		assertEquals(coordenada1.getY(), 1);
		assertNotEquals(coordenada1.getX(), 5);
		assertNotEquals(coordenada1.getY(), 5);
	}
/**
 * Como son casos que se pasan del limite debería de asignar 0 como valor de la coordenada.
 */
	@Test
	void testCoordenadaMal() {
		Coordenada coordenada1 = new Coordenada(10000,10000);
		
		assertEquals(coordenada1.getX(), 0);
		assertEquals(coordenada1.getY(), 0);
		assertNotEquals(coordenada1.getX(), 5);
		assertNotEquals(coordenada1.getY(), 5);
	}
	/**
	 * Nos debe dejar, tenemos espacio de una casilla.
	 */
	@Test
	void testGoDownBien() {
		Coordenada coordenada1 = new Coordenada(1,8);
		assertEquals(coordenada1.goDown(), true);
		
	}
	/**
	 * No nos debe dejar por que estamos al final del tablero en la parte de abajo.
	 */
	@Test
	void testGoDownMal() {
		Coordenada coordenada1 = new Coordenada(1,9);
		assertEquals(coordenada1.goDown(), false);
		
	}
	/**
	 * Te deja subir por que hay espacio hasta el final del tablero.
	 */
	@Test
	void testGoUpBien() {
		Coordenada coordenada1 = new Coordenada(8,1);
		assertEquals(coordenada1.goUp(), true);
		
	}
	/**
	 * 
	 */
	@Test
	void testGoUpMal() {
		Coordenada coordenada1 = new Coordenada(1,0);
		assertEquals(coordenada1.goUp(), false);
		
	}
	@Test
	void testGoRightBien() {
		Coordenada coordenada1 = new Coordenada(1,0);
		assertEquals(coordenada1.goRight(), true);
		
	}
	/**
	 * No me debe de dejar al estar en el extremo derecho
	 */
	@Test
	void testGoRightMal() {
		Coordenada coordenada1 = new Coordenada(9,0);
		assertEquals(coordenada1.goRight(), false);
		
	}
	@Test
	void testGoLeftBien() {
		Coordenada coordenada1 = new Coordenada(9,0);
		assertEquals(coordenada1.goLeft(), true);
		
	}
	/**
	 * No me debe de dejar al estar en el extremo izquierdo.
	 */
	@Test
	void testGoLeftMal() {
		Coordenada coordenada1 = new Coordenada(0,9);
		assertEquals(coordenada1.goLeft(), false);
		
	}
}


