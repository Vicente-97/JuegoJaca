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
	 * Constructor Que crea un tablero y añade los jugadores en base a la constante, llamando al metodo crearJugadores.
	 * @param personaje
	 */
	public Juego(PlayerType[] personaje) {
		super();
		tablero = new HashMap<>();
		coordenadaJugadores= new ArrayList<>();
		crearTablero();
		 Integer contador=0;
		while(contador<Constantes.NUM_JUGADORES) {
			if(crearJugador(personaje[contador])==true) {
				contador++;
			}		
			
		}
		
		//duda//
		/*for(int i =0; i<Constantes.NUM_JUGADORES; i++) {
			crearJugadores(personaje[i]);
		}*/
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
	 * Si la coordenada es nula, le añado la coordenada al tablero y el jugador.
	 * 
	 */
	
	private boolean crearJugador(PlayerType tipoDeJugador) {
		
			 boolean sePuedeCrear=false;
			
			Jugador jugador = new Jugador(tipoDeJugador);
			Coordenada coordenada = new Coordenada();
			
			while (coordenadaJugadores.contains(coordenada)) {
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
	 * Método que sirve para crear rocas, como limite tiene la constante NUM_ROCAS.
	 * Creamos una coordenada y un Elemento tipo Roca, comprobamos en el mapa (tablero)
	 * que el valor de la keyset es null, para así tener espacio para crear la roca.
	 * le insertamos al tablero, la coordenada y el elemento, que en este caso será roca y aumentamos el numero.
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
	 * método para eliminar un jugador, se le pasa una coordenada por parámetro y se elimina
	 * tanto de la lista CoordenadaJugadores como del tablero indicando la coordenada especificada
	 * por parámetro.
	 * @param coordenada
	 */
	private void eliminarJugador (Coordenada coordenada) {
		this.coordenadaJugadores.remove(coordenada);
		this.tablero.remove(coordenada);
	}
	/**
	 * método para saber cuando acaba el juego, el juego acabará cuando solo quede
	 * un jugador o un jugador tenga todo el dinero del juego.
	 * 
	 * @return
	 */
	public boolean isTerminado() {
		boolean termina = false;
		boolean tieneTodoElDinero=false;
		
		//contemplamos en el tableto los elementos que son jugadores//
		for(Element elemento : this.tablero.values()) {
			if( elemento instanceof Jugador) {
				//si el dinero del jugador es igual a nuestra constante que tiene un valor de 4, osea todo el dineri disponible.
				if(((Jugador) elemento).getDinero()==Constantes.DINERO) {
					tieneTodoElDinero=true;
				}
				//comprobamos que la cantidad de jugadores en el tablero es una, entonces acaba el juego.
			}if(this.coordenadaJugadores.size()==1) {
				termina=true;
			//comprobamos que si un jugador tiene todo el dinero, termina la partida.
			}if(tieneTodoElDinero=true) {
				termina=true;
			}
		}
		
		//contemplamos que quede un jugador sobre el tablero o que un jugador tenga todo el dinero
		
		return termina;
	}
	
	/**
	 * método que imprime el nombre de los jugadores en el tablero y devuelve
	 * una cadena con el nombre del jugador más el numero del 1 al 4 de que se trate.
	 * @return
	 */
	public String imprimeNombreJugadores() {
		StringBuilder nombreJugador= new StringBuilder();
		Integer contadorJugadores=1;
		for(Coordenada coordenada : this.coordenadaJugadores) {
			Jugador jugador =(Jugador) tablero.get(coordenada);
			nombreJugador.append(" El jugador "+ contadorJugadores+" se trata de un "+ jugador.getNombre()+"\n");
			contadorJugadores++;
		}
		
		return nombreJugador.toString();
	}
	
	public String imprimeValoreJugadores() {
		StringBuilder nombreJugador= new StringBuilder();
		Integer contadorJugadores=1;
		for(Coordenada coordenada : this.coordenadaJugadores) {
			Jugador jugador =(Jugador) tablero.get(coordenada);
			nombreJugador.append(" El jugador "+ contadorJugadores+" tiene "+ jugador.getDinero()+ " dinero y un total de "+ jugador.getGemas()+" gemas acumuladas y un total de  "+jugador.getPociones()+ " Pociones"+"\n");
			contadorJugadores++;
		}
		
		return nombreJugador.toString();
	}
	/**
	 * método para mover al jugador, recibe un caracter que será la direccion, Norte, Sur, Este o Oeste,
	 * comprobamos que sea un caracter valido.
	 * Utilizamos en switch para llamar a los métodos de coordenada.
	 */
	private Coordenada getNextPosition(char direction) throws Exception {
		Coordenada coordenada = this.coordenadaJugadores.get(jugadorJuega);
		if (direction != 'N' || direction != 'S' || direction != 'E' || direction != 'O') {
			throw new JuegoException("Error, no es una coordenada valida");
		} else {
			switch (direction) {
			case 'N': {
				coordenada.goUp();
				break;
			}
			case 'S': {
				coordenada.goDown();
				break;
			}
			case 'E': {
				
				coordenada.goRight();
				break;
			}
			case 'O': {
				coordenada.goLeft();
				break;
			}
			default:
				throw new Exception("Error");
			}
		}
		return coordenada;
	}
	
	/**
	 * método para cambiar la posicion de un Jugador, se le pasa una coordenada y se crea otra con el valor
	 * de la lista de jugadores, el atributo jugador juega. Se crea un jugador 2 que se le asigna la coordenada
	 * se inserta en tablero la coordenada y el nuevo jugador y se borra y actualiza en  la lista Jugadores.
	 * @param coordenada
	 */
	private void cambiaJugadorAPosicion(Coordenada coordenada) {
		Coordenada coord = this.coordenadaJugadores.get(jugadorJuega);
		
		Jugador Jugador2 = (Jugador) this.tablero.get(coord);
		tablero.put(coord, Jugador2);
		
		
		this.coordenadaJugadores.remove(coord);
		this.coordenadaJugadores.add(jugadorJuega, coord);
		
		
	}
	
	public void proximoJugador() {
		if (this.jugadorJuega == Constantes.NUM_JUGADORES - 1) {
			this.jugadorJuega = 0;
			
		} else {
			jugadorJuega++;
		}
	}
	
	public String getGanador() {
		
		StringBuilder St = new StringBuilder();
		if (this.coordenadaJugadores.size() == 1) {
			
			Jugador jugador2 = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
			St.append(jugador2.toString());
			
		} else {
			
			for (Element siguiente : tablero.values()) {
				
				if (siguiente instanceof Jugador) {
					
					Jugador jugador2 = ((Jugador) siguiente);
					if (jugador2.getDinero() == Constantes.NUM_DINERO) {
						St.append(jugador2);
					}
				}
			}
		}
		return St.toString();
	}
	
	
	public String getNombreJuegadorQueJuega() {
		
		StringBuilder St = new StringBuilder();
		
		
		Coordenada coordenada = this.coordenadaJugadores.get(jugadorJuega);
		
		Jugador jugador2 = (Jugador) this.tablero.get(coordenada);
		
		St.append(jugador2.getNombre());
		
		return St.toString();
	}
	
	
	
	public Element obtenerElementoTablero(Coordenada coord) {
		return this.tablero.get(coord);
	}
	
	public Coordenada obtenerCoordenadaJugadorJuega() {
		return this.coordenadaJugadores.get(jugadorJuega);
	}
	
	
	
	/**
	 * Escribe el tablero en formato no grÃ¡fico. Devuelve el string con la
	 * informaciÃ³n
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
	 * @throws Exception 
	 */
	public String movePlayer(char direction) throws Exception {
		// Si no es una direcciÃ³n vÃ¡lida, mando un exception
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
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pÃ³cima al enemigo";
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
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pÃ³cima al jugador";
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
				// DespuÃ©s de la lucha los jugadores no se mueven
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
