package algo2.elementos;
import java.util.ArrayList;
import java.util.List;

import algo2.exceptions.ExcedeLimiteTableroException;

import algo2.elementos.Extras;


public abstract class Tablero 
{	
	protected int cantidadFilas;
	protected int cantidadColumnas;
	protected Ficha[][] tablero;
	private int casillero_max;
	
	
	public Tablero(int cantidadFilas, int cantidadColumnas)
	{
		this.cantidadFilas = cantidadFilas;
		this.cantidadColumnas = cantidadColumnas;
		tablero = new Ficha[cantidadFilas][cantidadColumnas];
		casillero_max = cantidadColumnas*cantidadFilas-1;
		
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
	
	
	public List<Ficha> todasLasFichas()
	{
		List<Ficha> fichas = new ArrayList<Ficha>();
		
		for(int nroFila = 0; nroFila < this.cantidadFilas; nroFila++)
		{
			fichas.addAll( getFila(nroFila) );
		}
		
		return fichas;
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
		
		this.printarDesface();
		
		for(int nroColumna = 0; nroColumna < this.cantidadColumnas; nroColumna++)
		{
			this.mostrarCasillero(nroFila, nroColumna);
		}
		
		//System.out.println();
		
		this.mostrarHorizontal();
		
		//System.out.println();
	}
	

	private void mostrarHorizontal() 
	{
		this.printarDesface();
		
		for(int nroColumna = 0; nroColumna < this.cantidadColumnas; nroColumna++)
		{
			//Extras.imprimirEnColor("--", "BLANCO");
			//String cad_max = Integer.toString(cantidadColumnas*cantidadFilas-1);
			Extras.imprimirEnColor("-"+Extras.completaCadena("", "-", Integer.toString(casillero_max).length() )+"-", "BLANCO");
		}
	}
	
	
	private void mostrarCasillero(int nroFila, int nroColumna)
	{
		Ficha ficha = this.tablero[nroFila][nroColumna];
		
		System.out.print(Extras.getStringColored("|", "BLANCO"));
		
		if(ficha == null)
			System.out.print(Extras.getStringColored(Extras.adaptaInt(nroFila*cantidadColumnas + nroColumna,casillero_max), "BLANCO"));
		else
			System.out.print(Extras.getStringColored(Extras.adaptaElem(ficha.simbolo(),casillero_max), ficha.color()));
		
		System.out.print(Extras.getStringColored("|", "BLANCO"));
	}
	
	private void printarDesface(){
		System.out.print("\n\t\t");
	}
	
	public int getCColumna(){
		return this.cantidadColumnas;
	}
	
	public int getCFila(){
		return this.cantidadFilas;
	}
}





