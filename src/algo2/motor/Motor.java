package algo2.motor;


import algo2.elementos.*;

public class Motor 
{

	public static void main(String[] args) 
	{	
				
		Juego juego = JuegoFactory.getJuego();
		
		Jugador jugador1 = juego.jugador1();
		Jugador jugador2 = juego.jugador2();
		

		
		System.out.println("\n\tComienza el juego "+juego+"! "+jugador1+" vs "+jugador2+"! \n");
		
		
		Movimiento movimiento;
		
		do
		{		
			movimiento = juego.gestionarMovimiento(jugador1);
			
						
			if( juego.estaFinalizado(movimiento, jugador1) )
				break;
			
			movimiento = juego.gestionarMovimiento(jugador2);
			
			
		} while( !juego.estaFinalizado(movimiento, jugador2) );
	}

}
