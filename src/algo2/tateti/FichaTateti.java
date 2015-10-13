package algo2.tateti;

import algo2.elementos.Ficha;
import algo2.elementos.Jugador;

public class FichaTateti extends Ficha
{
	private JugadorTateti jugador;
	

	public FichaTateti(String simbolo, JugadorTateti jugador)
	{
		super(simbolo);
		
		this.jugador = jugador;
	}
	
	
	public Jugador jugador()
	{
		return jugador;
	}

}
