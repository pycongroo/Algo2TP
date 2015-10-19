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

	@Override
	public void mostrar() 
	{
		for(int nroFila = 0; nroFila < this.cantidadFilas; nroFila++)
		{
			this.mostrarFila(nroFila);
		}
	}
	
	
	
	private void mostrarFila(int nroFila)
	{
		System.out.print("\t\t");
		
		for(int nroColumna = 0; nroColumna < this.cantidadColumnas; nroColumna++)
		{
			System.out.print("---");
		}
		
		System.out.print("\n\t\t");
		
		for(int nroColumna = 0; nroColumna < this.cantidadColumnas; nroColumna++)
		{
			this.mostrarCasillero(nroFila, nroColumna);
		}
		
		System.out.println();
	}
	
	
	private void mostrarCasillero(int nroFila, int nroColumna)
	{
		FichaTateti ficha = (FichaTateti) this.tablero[nroFila][nroColumna];
		
		System.out.print("|");
		
		if(ficha == null)
			System.out.print(nroFila*cantidadColumnas + nroColumna);
		else
			System.out.print(ficha);
		
		System.out.print("|");
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
}







