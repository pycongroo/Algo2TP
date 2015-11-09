package algo2.tateti;

import algo2.elementos.Ficha;
import algo2.elementos.Jugador;
import algo2.elementos.Extras;

public class JugadorTateti extends Jugador
{
	private String simboloFicha;
	private String colorFicha;
	
	

	public JugadorTateti(String nombre) 
	{
		super(nombre);
	}
	
	public String toString(){
		return Extras.getStringColored(super.toString(), this.colorFicha);
	}
	

	@Override
	public Ficha dameFicha()
	{
		return new FichaTateti(simboloFicha, colorFicha, this);
	}
	
	
	public void setFicha(String simbolo)
	{
		this.simboloFicha = simbolo;
	}
	
	public void setColor(String color)
	{
		this.colorFicha = color;
	}

}
