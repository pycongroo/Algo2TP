package algo2.elementos;
import algo2.exceptions.ExcedeLimiteTableroException;


public abstract class Tablero 
{
	
	protected int cantidadFilas;
	protected int cantidadColumnas;
	protected Ficha[][] tablero;
	
	
	public abstract void mostrar();
	
	
	public Tablero(int cantidadFilas, int cantidadColumnas)
	{
		this.cantidadFilas = cantidadFilas;
		this.cantidadColumnas = cantidadColumnas;
		tablero = new Ficha[cantidadFilas][cantidadColumnas];
	}
	
	
	
	public void ponerFicha(Ficha ficha, int casillero)
	{
		if( esCasilleroFueraDeLimites(casillero) )
			throw new ExcedeLimiteTableroException("El casillero está fuera de los límites del tablero!!");
		
		int columna = casillero % cantidadColumnas;
		int fila = (casillero - columna) / cantidadColumnas;
		
		tablero[fila][columna] = ficha;
	}

	private boolean esCasilleroFueraDeLimites(int casillero) 
	{
		return casillero < 0 || casillero >= (cantidadFilas*cantidadColumnas);
	}
}
