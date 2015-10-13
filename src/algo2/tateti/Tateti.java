package algo2.tateti;

import algo2.elementos.*;

public class Tateti extends Juego
{

	@Override
	public void crearJugador1(String nombreJugador) 
	{
		this.jugador1 = new JugadorTateti(nombreJugador);
	}

	@Override
	public void crearJugador2(String nombreJugador) 
	{
		this.jugador2 = new JugadorTateti(nombreJugador);
	}

	@Override
	protected Movimiento crearMovimiento(Ficha ficha, Tablero tablero, int casillero) 
	{
		return new MovimientoTateti(ficha, tablero, casillero);
	}

	@Override
	public void crearTablero()
	{
		this.tablero = new TableroTateti();
	}

	@Override
	public void gestionarFichas() 
	{
		JugadorTateti jugador1 = (JugadorTateti) this.jugador1;
		JugadorTateti jugador2 = (JugadorTateti) this.jugador2;
		
		jugador1.setSimboloFicha("x");
		jugador2.setSimboloFicha("o");
	}

}
