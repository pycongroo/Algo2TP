package algo2.elementos;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public void ponerFicha(Ficha ficha, Posicion posicion)
	{
		if( esPosicionFueraDeLimites(posicion) )
			throw new ExcedeLimiteTableroException("El casillero está fuera de los límites del tablero!!");
		
		
		tablero[posicion.fila()][posicion.columna()] = ficha;
	}
	
	
	public Ficha getFicha(Posicion posicion)
	{
		return tablero[posicion.fila()][posicion.columna()];
	}
	

	private boolean esPosicionFueraDeLimites(Posicion posicion) 
	{
		return posicion.fila() < 0 || posicion.fila() >= this.cantidadFilas ||
			   posicion.columna() < 0 || posicion.columna() >= this.cantidadColumnas;
	}


	public Posicion crearPosicion(int casillero) 
	{
		int columna = casillero % cantidadColumnas;
		int fila = (casillero - columna) / cantidadColumnas;
		
		return new Posicion(fila, columna);
	}


	public List<Ficha> getFila(int nroFila) 
	{
		List<Ficha> fila = new ArrayList<Ficha>();
		
		for(int nroColumna = 0; nroColumna < this.cantidadColumnas; nroColumna++)
		{
			fila.add( tablero[nroFila][nroColumna] );
		}
		
		return fila;
	}	
	
	
	public List<Ficha> getColumna(int nroColumna) 
	{
		List<Ficha> columna = new ArrayList<Ficha>();
		
		for(int nroFila = 0; nroFila < this.cantidadFilas; nroFila++)
		{
			columna.add( tablero[nroFila][nroColumna] );
		}
		
		return columna;
	}	
}





