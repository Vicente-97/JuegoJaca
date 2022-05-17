package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import elementos.*;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega.
	private int numeroRocas;
	private int numeroGemas;
	private int numeroPociones;
	private int numeroDinero;
	
	/**
	 * Constructor Que crea un tablero y a�ade los jugadores en base a la constante, llamando al metodo crearJugadores.
	 * @param personaje
	 */
	public Juego(PlayerType[] personaje) {
		super();
		tablero = new HashMap<>();
		coordenadaJugadores= new ArrayList<>();
		crearTablero();
		for(int i =0; i<Constantes.NUM_JUGADORES; i++) {
			crearJugadores(personaje[i]);
		}
	}
	/**
	 * Creo el tablero con los metodos creardinero, creargemas, crearpociones, crearrocas.
	 * Todos los elementos menos los jugadores
	 */
	private void crearTablero() {
		crearDinero();
		crearGemas();
		crearPociones();
		crearRocas();
	}
	
	/**
	 * metodo para crear jugadores, devuelve un boolean y crea un jugador y una coordenada,
	 * Si la coordenada es nula, le a�ado la coordenada al tablero y el jugador.
	 * 
	 */
	
	private boolean crearJugadores(PlayerType tipoDeJugador) {
		
			 boolean sePuedeCrear=false;
			
			Jugador jugador = new Jugador(tipoDeJugador);
			Coordenada coordenada = new Coordenada();
			
			
			while(coordenadaJugadores.contains(coordenada)) {
				coordenada = new Coordenada();		
									
				}								
			if(this.tablero.get(coordenada)==null) {
				coordenadaJugadores.add(coordenada);
				tablero.put(coordenada, jugador);
								
				sePuedeCrear=true;
			}
				
		return sePuedeCrear;
		
		}
	
	/**
	 * M�todo que sirve para crear rocas, como limite tiene la constante NUM_ROCAS.
	 * Creamos una coordenada y un Elemento tipo Roca, comprobamos en el mapa (tablero)
	 * que el valor de la keyset es null, para as� tener espacio para crear la roca.
	 * le insertamos al tablero, la coordenada y el elemento, que en este caso ser� roca y aumentamos el numero.
	 */
	private void crearRocas() {	
		
		while (numeroRocas < Constantes.NUM_ROCAS) {
			
			Coordenada coordenada = new Coordenada();
			
			Element elemento = new Element(ElementType.ROCA);
			
			if (tablero.get(coordenada) == null) {
				
				this.tablero.put(coordenada, elemento);
				
				numeroRocas++;
			}

		}
	}
	
	/**
	 * Metodo que sirve para crear gemas con el limite de la constante NUM GEMA.
	 * crea tipos de elemento GEMA, se crea una coordenada generada aleatoria, y se comprueba que el valor de esa
	 * coordenada en el tablero esta vacia, osea es null, si es null pues en dicha casilla le inserta el elemento.
	 */
	private void crearGemas () {
		
		
		while (numeroGemas< Constantes.NUM_GEMAS) {
			Coordenada coordenada  = new Coordenada();
			Element elemento = new Element(ElementType.GEMA);
			
			if( tablero.get(coordenada) == null ) {
				this.tablero.put(coordenada, elemento);
				numeroGemas ++;
			}
		}
	}
	/**
	 * Metodo que sirve para crear Pociones con el limite de la constante NUM POCIONES.
	 * crea tipos de elemento POCION, se crea una coordenada generada aleatoria, y se comprueba que el valor de esa
	 * coordenada en el tablero esta vacia, osea es null, si es null pues en dicha casilla le inserta el elemento.
	 */
	private void crearPociones () {
	
		
		
		while (numeroPociones< Constantes.NUM_POCIONES) {
			Coordenada coordenada  = new Coordenada();
			Element elemento = new Element(ElementType.POCION);
			
			if( tablero.get(coordenada) == null ) {
				this.tablero.put(coordenada, elemento);
				numeroPociones ++;
			}
		}
	}
	/**
	 * Metodo que sirve para crear gemas con el limite de la constante NUM DINERO.
	 * crea tipos de elemento DINERO, se crea una coordenada generada aleatoria, y se comprueba que el valor de esa
	 * coordenada en el tablero esta vacia, osea es null, si es null pues en dicha casilla le inserta el elemento.
	 */
	
	private void crearDinero () {
				
		
		while (numeroDinero< Constantes.NUM_DINERO) {
			Coordenada coordenada  = new Coordenada();
			Element elemento = new Element(ElementType.DINERO);
			
			if( tablero.get(coordenada) == null ) {
				this.tablero.put(coordenada, elemento);
				numeroDinero ++;
			}
		}
	}
	
	
	
	/**
	 * Escribe el tablero en formato no gráfico. Devuelve el string con la
	 * información
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}


	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}


	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una dirección válida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pócima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pócima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// Después de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}

	
	
}
