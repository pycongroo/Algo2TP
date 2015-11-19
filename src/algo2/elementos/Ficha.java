package algo2.elementos;

public class Ficha
{
	protected String simbolo;
	protected String color;
	
	
	public Ficha(String simbolo, String color)
	{
		this.simbolo = simbolo;
		this.color = color;
	}
	
	
	public String color()
	{
		return this.color;
	}
	
	public String simbolo(){
		return this.simbolo;
	}
	
	
	public String toString()
	{
		return simbolo;
	}
}
