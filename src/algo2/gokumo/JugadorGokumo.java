package algo2.gokumo;

import algo2.elementos.Extras;
import algo2.elementos.Ficha;
import algo2.elementos.Jugador;
import algo2.tateti.FichaTateti;

public class JugadorGokumo extends Jugador {
	private String simboloFicha;
	private String colorFicha;	

	public JugadorGokumo(String nombre) 
	{
		super(nombre);
	}
	
	public String toString(){
		return Extras.getStringColored(super.toString(), this.colorFicha);
	}
	

	@Override
	public Ficha dameFicha()
	{
		return new FichaGokumo(simboloFicha, colorFicha, this);
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
