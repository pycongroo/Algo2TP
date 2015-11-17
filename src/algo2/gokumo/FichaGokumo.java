package algo2.gokumo;

import algo2.elementos.Ficha;

public class FichaGokumo extends Ficha 
{
	private JugadorGokumo jugador;
	

	public FichaGokumo(String simbolo, String color, JugadorGokumo jugador)
	{
		super(simbolo, color);
		this.jugador = jugador;
	}
	
	public JugadorGokumo getJugador()
	{
		return this.jugador;
	}
}
