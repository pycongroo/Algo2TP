
public abstract class Movimiento 
{	
	private Jugador jugador;
	
	private Tablero tablero;
	
	private int casillero;
	
	public Movimiento(Jugador jugador, Tablero tablero, int casillero)
	{
		this.jugador = jugador;
		this.tablero = tablero;
		this.casillero = casillero;
	}
	
	public abstract boolean esMovimientoFinal();

	public abstract boolean esValido();
}
