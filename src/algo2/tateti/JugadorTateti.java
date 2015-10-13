package algo2.tateti;

import algo2.elementos.Ficha;
import algo2.elementos.Jugador;

public class JugadorTateti extends Jugador
{
	private String simboloFicha;
	
	

	public JugadorTateti(String nombre) 
	{
		super(nombre);
	}
	

	@Override
	public Ficha dameFicha()
	{
		return new FichaTateti(simboloFicha, this);
	}
	
	
	public void setSimboloFicha(String simbolo)
	{
		this.simboloFicha = simbolo;
	}

}
