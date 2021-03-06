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
	protected Movimiento crearMovimiento(Ficha ficha, Tablero tablero, Posicion posicion) 
	{
		return new MovimientoTateti(ficha, tablero, posicion);
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
		
		jugador1.setFicha("x");
		jugador1.setColor("CIAN");
		jugador2.setFicha("o");
		jugador2.setColor("AMARILLO");
	}

}
