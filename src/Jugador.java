
public abstract class Jugador 
{
	protected String nombre;
	
	
	public abstract Ficha dameFicha();
	
	public Jugador(String nombre)
	{
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString()
	{
		return nombre;
	}
}
