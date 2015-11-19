package algo2.gokumo;

import algo2.elementos.Ficha;
import algo2.elementos.Juego;
import algo2.elementos.Movimiento;
import algo2.elementos.Posicion;
import algo2.elementos.Tablero;
import algo2.gokumo.JugadorGokumo;
import algo2.gokumo.MovimientoGokumo;
import algo2.gokumo.TableroGokumo;

public class Gokumo extends Juego {
	
	@Override
	public void crearJugador1(String nombreJugador) 
	{
		this.jugador1 = new JugadorGokumo(nombreJugador);
	}

	@Override
	public void crearJugador2(String nombreJugador) 
	{
		this.jugador2 = new JugadorGokumo(nombreJugador);
	}

	@Override
	protected Movimiento crearMovimiento(Ficha ficha, Tablero tablero, Posicion posicion) 
	{
		return new MovimientoGokumo(ficha, tablero, posicion);
	}

	@Override
	public void crearTablero()
	{
		this.tablero = new TableroGokumo();
	}

	@Override
	public void gestionarFichas() 
	{
		JugadorGokumo jugador1 = (JugadorGokumo) this.jugador1;
		JugadorGokumo jugador2 = (JugadorGokumo) this.jugador2;
		
		jugador1.setFicha("x");
		jugador1.setColor("ROJO");
		jugador2.setFicha("*");
		jugador2.setColor("VERDE");
	}
}
