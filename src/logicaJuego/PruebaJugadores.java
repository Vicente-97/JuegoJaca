package logicaJuego;

import elementos.Jugador;
import elementos.PlayerType;

public class PruebaJugadores {
	public static void main(String[] args) {
	
	//Jugador jugador1 = new Jugador(Constantes.ELFO);
	Juego juego1 = new Juego(PlayerType.values());
	//prueba para saber si se crean los jugadores
	System.out.println(juego1.imprimeNombreJugadores());
	System.out.println(juego1.imprimeValoresJugadores());
	
}
}
