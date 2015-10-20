package algo2.elementos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import algo2.exceptions.ExcedeLimiteTableroException;



public abstract class Tablero 
{	
	protected int cantidadFilas;
	protected int cantidadColumnas;
	protected Ficha[][] tablero;
	
	private HashMap<String, String> colores = new HashMap<String, String>();
	
	
	
	
	public Tablero(int cantidadFilas, int cantidadColumnas)
	{
		this.cantidadFilas = cantidadFilas;
		this.cantidadColumnas = cantidadColumnas;
		tablero = new Ficha[cantidadFilas][cantidadColumnas];
		
		this.inicializarColores();
	}
	
	
	
	public void ponerFicha(Ficha ficha, Posicion posicion)
	{
		tablero[posicion.fila()][posicion.columna()] = ficha;
	}
	
	
	public Ficha getFicha(Posicion posicion)
	{
		return tablero[posicion.fila()][posicion.columna()];
	}
	

	private boolean esCasilleroFueraDeLimites(int casillero) 
	{
		return casillero < 0 || casillero >= cantidadFilas*cantidadColumnas;
	}


	public Posicion crearPosicion(int casillero) 
	{
		if( esCasilleroFueraDeLimites(casillero) )
			throw new ExcedeLimiteTableroException("El casillero está fuera de los límites del tablero!!");
		
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
	
	
	
	public void mostrar() 
	{
		for(int nroFila = 0; nroFila < this.cantidadFilas; nroFila++)
		{
			this.mostrarFila(nroFila);
		}
	}
	
	
	private void mostrarFila(int nroFila)
	{
		this.mostrarHorizontal();
		
		System.out.print("\n\t\t");
		
		for(int nroColumna = 0; nroColumna < this.cantidadColumnas; nroColumna++)
		{
			this.mostrarCasillero(nroFila, nroColumna);
		}
		
		System.out.println();
		
		this.mostrarHorizontal();
		
		System.out.println();
	}


	private void mostrarHorizontal() 
	{
		System.out.print("\t\t");
		
		for(int nroColumna = 0; nroColumna < this.cantidadColumnas; nroColumna++)
		{
			System.out.print( colores.get("BLANCO")+"---"+colores.get("RESET") );
		}
	}
	
	
	private void mostrarCasillero(int nroFila, int nroColumna)
	{
		Ficha ficha = this.tablero[nroFila][nroColumna];
		
		System.out.print( colores.get("BLANCO")+"|"+colores.get("RESET") );
		
		if(ficha == null)
			System.out.print( colores.get("BLANCO")+(nroFila*cantidadColumnas + nroColumna)+colores.get("RESET") );
		else
			System.out.print( colores.get(ficha.color())+ficha+colores.get("RESET") );
		
		System.out.print( colores.get("BLANCO")+"|"+colores.get("RESET") );
	}
	
	
	private void inicializarColores()
	{
		colores.put("RESET", "\u001B[0m");
		colores.put("NEGRO", "\u001B[30m");
		colores.put("ROJO", "\u001B[31m");
		colores.put("VERDE", "\u001B[32m");
		colores.put("AMARILLO", "\u001B[33m");
		colores.put("AZUL", "\u001B[34m");
		colores.put("PURPURA", "\u001B[35m");
		colores.put("CIAN", "\u001B[36m");
		colores.put("BLANCO", "\u001B[37m");
	}
}





