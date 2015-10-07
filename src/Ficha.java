
public class Ficha
{
	Jugador jugador;
	String simbolo;
	
	
	public Ficha(Jugador jugador, String simbolo)
	{
		this.jugador = jugador;
		this.simbolo = simbolo;
	}
	
	
	@Override
	public String toString()
	{
		return simbolo;
	}
}
