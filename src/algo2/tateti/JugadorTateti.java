package algo2.tateti;

import algo2.elementos.Ficha;
import algo2.elementos.Jugador;

public class JugadorTateti extends Jugador
{
	private String simboloFicha;
	private String colorFicha;
	
	

	public JugadorTateti(String nombre) 
	{
		super(nombre);
	}
	

	@Override
	public Ficha dameFicha()
	{
		return new FichaTateti(simboloFicha, colorFicha, this);
	}
	
	
	public void setFicha(String simbolo, String color)
	{
		this.simboloFicha = simbolo;
		this.colorFicha = color;
	}

}
