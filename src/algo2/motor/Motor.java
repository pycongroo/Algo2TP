package algo2.motor;

import algo2.elementos.*;

public class Motor 
{

	public static void main(String[] args) 
	{
				
		Juego juego = JuegoFactory.getJuego();
		
		Jugador jugador1 = juego.jugador1();
		Jugador jugador2 = juego.jugador2();
		

		
		System.out.println("Comienza el juego "+juego+"! "+jugador1+" vs "+jugador2+"! \n");
		
		
		boolean juegoTerminado;
		Movimiento movimiento;
		
		do
		{		
			movimiento = juego.gestionarMovimiento(jugador1);
			
			juegoTerminado = juego.estaFinalizado(movimiento, jugador1);
			
			if(juegoTerminado)
				break;
			
			movimiento = juego.gestionarMovimiento(jugador2);
			
			juegoTerminado = juego.estaFinalizado(movimiento, jugador2);
			
		} while(!juegoTerminado);
	}

}
