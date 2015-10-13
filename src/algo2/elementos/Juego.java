package algo2.elementos;


import java.util.Scanner;


public abstract class Juego 
{
	protected String nombre;	

	protected Tablero tablero;
	
	protected Jugador jugador1;
	protected Jugador jugador2;
	
	
	Scanner scanner = new Scanner(System.in);
	
	
	
	public abstract void crearJugador1(String nombreJugador);
	
	public abstract void crearJugador2(String nombreJugador);
	
	protected abstract Movimiento crearMovimiento(Ficha ficha, Tablero tablero, int casillero);
	
	public abstract void crearTablero();
	
	public abstract void gestionarFichas();

	
	
	
	public Movimiento gestionarMovimiento(Jugador jugador)
	{
		Movimiento movimiento = null;
		
		System.out.println("\n\n\n\t\tEs el turno de "+jugador+"!\n");
		
		tablero.mostrar();
		
		System.out.println("\n\t\tIngrese el número de casillero donde quiera depositar su ficha: ");
		
		boolean esMovimientoValido;
		
		//Scanner scanner = new Scanner(System.in);
		
		do
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
				System.out.println("\t\tEse movimiento no es válido! Ingrese el casillero otra vez:");
				esMovimientoValido = false;
			}
		
		} while(!esMovimientoValido);
		
		//scanner.close();
		
		return movimiento;
	}





	public boolean estaFinalizado(Movimiento movimiento, Jugador jugador) 
	{
		if(movimiento.esMovimientoFinal())
		{
			tablero.mostrar();
			
			System.out.println("\n\n\t\tEl jugador "+jugador+" es el ganador!!\n");
			
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








