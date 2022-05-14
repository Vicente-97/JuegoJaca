package elementos;

import java.util.Random;

import logicaJuego.Constantes;

public class Jugador extends Element {
	
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType jugadores;
	Random random = new Random();

	public Jugador(PlayerType jugadores) {
		super(ElementType.valueOf(jugadores.name()));
		this.jugadores = jugadores;
		this.dinero = 0;
		this.gemas = 0;
		this.pociones = 0;
	}

	
	public String getNombre() {
		return jugadores.name();
	}

	private int getFuerza() {
		return jugadores.getFuerza();
	}

	public int getFuerzaParaLuchar() {
		return random.nextInt(getFuerza());
	}

	private int getMagia() {
		return jugadores.getMagia();
	}

	public int getMagiaParaLuchar() {
		return random.nextInt(getMagia());
	}

	private int getVelocidad() {
		return jugadores.getVelocidad();
	}

	public int getVelocidadParaLuchar() {
		return random.nextInt(getVelocidad());
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) throws JugadorException {
		
		if (dinero < 0) {
			
			throw new JugadorException("Error de juego, el dinero no puede ser menor que 0");
			
		} else {
			this.dinero = dinero;
		}
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) throws JugadorException {
		
		if (pociones < 0) {
			
			throw new JugadorException("Error del juego, Las pociones no pueden ser negativas");
			
		} else {
			this.pociones = pociones;
		}
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) throws JugadorException {
		
		if (gemas < 0) {
			
			throw new JugadorException("Error, Las gemas no pueden ser negativas");
			
		} else {
			this.gemas = gemas;
		}

	}

	public String resumen() {
		
		return "Nombre: " + this.getNombre() 
		+ " Gemas: " + this.getGemas() 
		+ " Dinero: " + this.getDinero()
		+ "Pociones: " + this.getPociones();
	}

	
	public PlayerType getPlayer() {
		return jugadores;
	}
	//encuentra dinero al moverse//
	public void encuentraDinero() {
		this.dinero++;
	}
	//encuentra pocion //
	public void encuentraPocion() {
		this.pociones++;
	}
	//encuetra gemas//
	public void encuentraGema() {
		this.gemas++;
	}
	
	
}