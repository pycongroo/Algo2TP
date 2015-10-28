package algo2.tateti;

import java.util.List;

import algo2.elementos.*;

public class MovimientoTateti extends Movimiento
{

	public MovimientoTateti(Ficha ficha, Tablero tablero, Posicion posicion) 
	{
		super(ficha, tablero, posicion);
	}
	
	
	@Override
	protected boolean esInvalido() 
	{
		return tablero.getFicha(posicion) != null;
	}
	
	
	@Override
	public boolean esMovimientoEmpate() 
	{
		return !esMovimientoFinal() && ((TableroTateti) tablero).estaLleno();
	}
	

	@Override
	public boolean esMovimientoFinal() 
	{
		return this.formaDiagonal() ||
			   this.formaVertical() ||
			   this.formaHorizontal();
	}
	
	
	private boolean formaHorizontal()
	{
		List<Ficha> fila = tablero.getFila(posicion.fila());
		
		Jugador posibleGanador = ((FichaTateti) this.ficha).jugador();
		
		try
		{		
			return fila.stream().allMatch( ficha -> ((FichaTateti) ficha).jugador() == posibleGanador );	
		}	
		catch(NullPointerException ex)
		{
			return false;
		}
	}
	
	
	private boolean formaVertical()
	{
		List<Ficha> columna = tablero.getColumna(posicion.columna());
		
		Jugador posibleGanador = ((FichaTateti) this.ficha).jugador();
		
		try
		{
			return columna.stream().allMatch( ficha -> ((FichaTateti) ficha).jugador() == posibleGanador );
		}
		catch(NullPointerException ex)
		{
			return false;
		}
	}
	
	
	private boolean formaDiagonal()
	{
		Jugador posibleGanador = ((FichaTateti) this.ficha).jugador();
		
		TableroTateti tablero = (TableroTateti) this.tablero;
		
		List<Ficha> primerDiagonal = tablero.getPrimerDiagonal();
		
		List<Ficha> segundaDiagonal = tablero.getSegundaDiagonal();
		
		try
		{
			return primerDiagonal.stream().allMatch(  ficha -> ((FichaTateti) ficha).jugador() == posibleGanador ) ||
				   segundaDiagonal.stream().allMatch( ficha -> ((FichaTateti) ficha).jugador() == posibleGanador );
		}
		catch(NullPointerException ex)
		{
			return false;
		}
	}
}






