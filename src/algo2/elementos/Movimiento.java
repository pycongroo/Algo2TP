package algo2.elementos;
import algo2.exceptions.MovimientoInvalidoException;


public abstract class Movimiento 
{	
	protected Ficha ficha;
	
	protected Tablero tablero;
	
	protected int casillero;
	
	
	public abstract boolean esMovimientoFinal();

	protected abstract boolean esInvalido();
	
	
	public Movimiento(Ficha ficha, Tablero tablero, int casillero)
	{
		this.ficha = ficha;
		this.tablero = tablero;
		this.casillero = casillero;
	}	


	public void ejecutate() 
	{		
		if( this.esInvalido() )
			throw new MovimientoInvalidoException("El movimiento no es válido!!");
		
		tablero.ponerFicha(ficha, casillero);
	}
}







