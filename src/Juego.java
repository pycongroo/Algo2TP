import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class Juego 
{
	protected String nombre;	

	protected Tablero tablero;
	
	Jugador jugador1;
	Jugador jugador2;
	
	
	
	public abstract void crearJugador1(String nombreJugador);
	
	public abstract void crearJugador2(String nombreJugador);
	
	protected abstract Movimiento crearMovimiento(Ficha ficha, Tablero tablero, int casillero);
	
	public abstract void crearTablero();
	
	public abstract void gestionarFichas();

	
	
	
	public Movimiento gestionarMovimiento(Jugador jugador)
	{
		Scanner scanner = new Scanner(System.in);	
		
		Movimiento movimiento = null;
		
		System.out.println("Es el turno de "+jugador+"!\n");
		
		tablero.mostrar();
		
		System.out.println("Ingrese el número de casillero donde quiera depositar su ficha: ");
		
		boolean esMovimientoValido = false;
		
		while(!esMovimientoValido)
		{			
			int casillero = scanner.nextInt();
			
			Ficha ficha = jugador.dameFicha();
			
			movimiento = this.crearMovimiento(ficha, tablero, casillero);
			
			try
			{
				movimiento.ejecutate();
				esMovimientoValido = true;
			}
			catch(Exception ex)
			{
				System.out.println("Ese movimiento no es válido! Ingrese el casillero otra vez:");
			}
		}
		
		return movimiento;
	}





	public boolean estaFinalizado(Movimiento movimiento, Jugador jugador) 
	{
		if(movimiento.esMovimientoFinal())
		{
			tablero.mostrar();
			
			System.out.println("El jugador "+jugador+" es el ganador!!\n");
			
			return true;
		}
		
		return false;
	}
	
	
	

	public Jugador jugador1() 
	{
		return jugador1;
	}
	
	public Jugador jugador2() 
	{
		return jugador2;
	}
	
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString()
	{
		return nombre;
	}

}








