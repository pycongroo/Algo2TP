package algo2.elementos;
import algo2.exceptions.MovimientoInvalidoException;


public abstract class Movimiento 
{	
	protected Ficha ficha;
	
	protected Tablero tablero;
	
	protected Posicion posicion;
	
	
	public abstract boolean esMovimientoFinal();
	
	public abstract boolean esMovimientoEmpate();

	protected abstract boolean esInvalido();
	
	
	public Movimiento(Ficha ficha, Tablero tablero, Posicion posicion)
	{
		this.ficha = ficha;
		this.tablero = tablero;
		this.posicion = posicion;
	}	


	public void ejecutate() 
	{		
		if( this.esInvalido() )
			throw new MovimientoInvalidoException("El movimiento no es válido!!");
		
		tablero.ponerFicha(ficha, posicion);
	}
}







