/**
 * CalebSoft

 * @author Carlos E. A. Torres
 * @email ceatencio@ucsp.edu.pe

 * Copyright 2016.
 */

/**
 * @author carlos
 *
 */
public abstract class Robot {

	public static enum Direccion {
		NORTE, SUR, ESTE, OESTE, 
		NORESTE, NOROESTE, SURESTE, SUROESTE 
	}

	protected int posF;
	protected int posC;
	protected Direccion direccion;
	private boolean disparo;
	private int estamina;
	public int danio=10;
	public boolean valor; //necesito un valor de retorno para objetivoEnMira
	public int fuerza=0; //fuerza del ataque

	private final Tablero tablero = Tablero.getInstance();

	/**
	 * Constructor vacio.
	 */
	public Robot() {
	}

	/**
	 * 
	 * Constructor que recibe todos los datos por parámetros.
	 * 
	 * @param nombre
	 * @param posF
	 * @param posC
	 * @param sexo
	 * @param direccion
	 * @param tablero
	 */
	public Robot(int posF, int posC, Direccion direccion) {
		super();
		this.posF = posF;
		this.posC = posC;
		this.direccion = direccion;
	}
	
	public void irNorte() {
		if (estamina > 0 && tablero.esValido(posF - 1)) {
			posF--;
		}
		estamina--;
	}
	
	public void irSur() {
		if (estamina > 0 && tablero.esValido(posF + 1)) {
			posF++;
		}
		estamina--;
	}
	
	public void irEste() {
		if (estamina > 0 && tablero.esValido(posC + 1)) {
			posC++;
		}
		estamina--;
	}

	public void irOeste() {
		if (estamina > 0 && tablero.esValido(posC - 1)) {
			posC--;
		}
		estamina--;
	}
	
	public void irNorEste() { // Gasta 1 de estamina, no 2.
		if(estamina > 0 && tablero.esValido(posF - 1)
				&& tablero.esValido(posC + 1)) {
			posF--;
			posC++;
		}
		estamina--;
	}
	
	public void irNorOeste() {
		if(estamina > 0 && tablero.esValido(posF - 1)
				&& tablero.esValido(posC - 1)) {
			posF--;
			posC--;
		}
		estamina--;
	}

	public void irSurEste() {
		if(estamina > 0 && tablero.esValido(posF + 1)
				&& tablero.esValido(posC + 1)) {
			posF++;
			posC++;
		}
		estamina--;
	}

	public void irSurOeste() {
		if(estamina > 0 && tablero.esValido(posF + 1)
				&& tablero.esValido(posC - 1)) {
			posF++;
			posC--;
		}
		estamina--;
	}

	public void girarIzquierda() {
		switch (direccion) {
		case NORTE:
			direccion = Direccion.NOROESTE;
			break;
		case SUR:
			direccion = Direccion.SURESTE;
			break;
		case ESTE:
			direccion = Direccion.NORESTE;
			break;
		case OESTE:
			direccion = Direccion.SUROESTE;
			break;
		case NORESTE:
			direccion = Direccion.NORTE;
			break;
		case NOROESTE:
			direccion = Direccion.OESTE;
			break;
		case SURESTE:
		        direccion = Direccion.ESTE;
			break;
		case SUROESTE:
			direccion = Direccion.SUR;	
			break;
		}
		estamina--;
	}

	public void girarDerecha() {
		switch (direccion) {
		case NORTE:
			direccion = Direccion.NORESTE;
			break;
		case SUR:
			direccion = Direccion.SUROESTE;
			break;
		case ESTE:
			direccion = Direccion.SURESTE;
			break;
		case OESTE:
			direccion = Direccion.NOROESTE;
			break;
		case NORESTE:
			direccion = Direccion.ESTE;
			break;
		case NOROESTE:
			direccion = Direccion.NORTE;
			break;
		case SURESTE:
		        direccion = Direccion.SUR;
			break;
		case SUROESTE:
			direccion = Direccion.OESTE;	
			break;
		}
		estamina--;
	}

	/**
	 * 
	 * @return verdadero si el objetivo está a no más de 3 pasos en frente tuyo.
	 */

	public Robot objetivoEnMira() {
		switch (direccion) {
		case NORTE:
			return objetivoEnMira(posF, posC, -1, 0);
		case SUR:
			return objetivoEnMira(posF, posC, 1, 0);
		case ESTE:
			return objetivoEnMira(posF, posC, 0, 1);
		case OESTE:
			return objetivoEnMira(posF, posC, 0, -1);
		case NORESTE:
			return objetivoEnMira(posF, posC, -1, 1);
		case NOROESTE:
			return objetivoEnMira(posF, posC, -1, -1);
		case SURESTE:
			return objetivoEnMira(posF, posC, 1, 1);
		case SUROESTE:
			return objetivoEnMira(posF, posC, 1, -1);

		default:
			break;
		}
		valor=false;
		return this;
	}


	private Robot objetivoEnMira(int fila, int columna, int despFila, int despColumna) {
		int k = 10; // va a disparar a una distancia menor a  10
		Robot oponente = null;
		if (tablero.getJugador1() == this) {
			oponente = tablero.getJugador2();
		} else {
			oponente = tablero.getJugador1();
		}

		while (k > 0 && tablero.esValido(fila + despFila) && tablero.esValido(columna + despColumna)) {
			fila += despFila;
			columna += despColumna;

			if (oponente.getPosF() == fila && oponente.getPosC() == columna) {
				this.fuerza=k;
				oponente.valor=true;
				return oponente;
			}

			k--;
		}
		oponente.valor=false;
		return oponente;
	}
	
	public void ataque(Robot oponente) {
		oponente. danio=oponente.danio-this.fuerza; //daño
		
	}


	public void dispara(Robot oponente) {
		oponente.danio = oponente.danio-(fuerza);		
		this.disparo = true;
	}

	public void recarga() {
		this.disparo = false;
	}

	public boolean disparoEnSuTurno() {
		return disparo;
	}

	public boolean tieneEstamina() {
		return estamina > 0;
	}

	public boolean detectarParada(){
		int filaRobot=getPosF();
		int columnaRobot=getPosC();
		return (filaRobot==Tablero.paradaFila && columnaRobot==Tablero.paradaColumna);
	}

	public void recibeEstamina(int estamina) {
		this.estamina = estamina;
	}

	/**
	 * Retorna el rostro del jugador. Debe ser de 2x2. 
     * Por ejemplo: ************
	 * @@ 
       ^^ ***** oO ***** && ********** Xx ****************************
	 * v  ***** @ ****** # ****** p *********** " ****************************
	 * 
	 * 
	 * @return
	 */
	public abstract Character[][] getFace();

	/**
	 * Estrategia del jugador.
	 */
	public abstract void estrategia();

	/**
	 * @return Una breve descripcion del robot (maximo 50 caracteres).
	 */
	public abstract String getDescripcion();

	/**
	 * @return posF - la posicion fila
	 */
	public int getPosF() {
		return posF;
	}

	/**
	 * Cambia la posición fila.
	 * @param posF, No usar en juego, sera considerado trampa, en cambio use los metodos irADireccion(). 
	 */

	public void setPosF(int posF) {
		this.posF = posF;
	}

	/**
	 * @return posC - la posicion columna
	 */
	public int getPosC() {
		return posC;
	}

	/**
	 * Cambia la posicion columna
	 * @param posC, No usar en juego, sera considerado trampa, en cambio use los metodos irA...(). 
	 */
	public void setPosC(int posC) {
		this.posC = posC;
	}

	/***
	 * @return direccion - NORTE/SUR/ESTE/OESTE
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * Cambia la direccion.
	 * @param direccion, No usar en juego, sera considerado trampa, en cambio use los metodos girar...(). 
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " :" + getDescripcion();
	}

	/**
	 * @return la representacion del rostro, en forma de 2 líneas.
	 */
	public String[] toString2() {
		String[] respuesta = new String[2];
		Character[][] face = getFace();

		switch (direccion) {
		case SUR:
			respuesta[0] = "" + face[0][0] + face[0][1];
			respuesta[1] = "" + face[1][0] + face[1][1];
			break;
		case NORTE:
			respuesta[0] = "" + face[1][1] + face[1][0];
			respuesta[1] = "" + face[0][0] + face[0][1];
			break;
		case ESTE:
			respuesta[0] = "" + face[0][1] + face[1][1];
			respuesta[1] = "" + face[0][0] + face[1][0];
			break;
		case OESTE:
			respuesta[0] = "" + face[1][0] + face[0][0];
			respuesta[1] = "" + face[1][1] + face[0][1];
			break;

		case NORESTE: // Mismo que Norte
			respuesta[0] = "" + face[1][1] + face[1][0];
			respuesta[1] = "" + face[0][0] + face[0][1];
			break;
		case NOROESTE: // Mismo que Norte
			respuesta[0] = "" + face[1][1] + face[1][0];
			respuesta[1] = "" + face[0][0] + face[0][1];
			break;
		case SURESTE: // Mismo que Sur
			respuesta[0] = "" + face[0][0] + face[0][1];
			respuesta[1] = "" + face[1][0] + face[1][1];
			break;
		case SUROESTE: // Mismo que Sur
			respuesta[0] = "" + face[0][0] + face[0][1];
			respuesta[1] = "" + face[1][0] + face[1][1];
			break;
		}
		return respuesta;
	}

}
