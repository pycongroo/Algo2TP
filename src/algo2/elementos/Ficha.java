package algo2.elementos;

public class Ficha
{
	protected String simbolo;
	
	
	public Ficha(String simbolo)
	{
		this.simbolo = simbolo;
	}
	
	
	@Override
	public String toString()
	{
		return simbolo;
	}
}
