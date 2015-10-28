package algo2.tateti;

import java.util.ArrayList;
import java.util.List;

import algo2.elementos.Ficha;
import algo2.elementos.Tablero;

public class TableroTateti extends Tablero
{

	public TableroTateti()
	{
		super(3, 3);
	}

	
	public List<Ficha> getPrimerDiagonal()
	{
		List<Ficha> diagonal = new ArrayList<Ficha>();
		
		diagonal.add(this.tablero[0][0]);
		diagonal.add(this.tablero[1][1]);
		diagonal.add(this.tablero[2][2]);
		
		return diagonal;
	}
	
	
	public List<Ficha> getSegundaDiagonal()
	{
		List<Ficha> diagonal = new ArrayList<Ficha>();
		
		diagonal.add(this.tablero[0][2]);
		diagonal.add(this.tablero[1][1]);
		diagonal.add(this.tablero[2][0]);
		
		return diagonal;
	}
	
	
	public boolean estaLleno()
	{
		return todasLasFichas().stream().allMatch(ficha -> ficha != null);
	}
}







