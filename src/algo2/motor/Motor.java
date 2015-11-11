package algo2.motor;


import algo2.elementos.*;

public class Motor 
{

	public static void main(String[] args) 
	{	
				
		Juego juego = JuegoFactory.getJuego();
		
		Jugador jugador1 = juego.jugador1();
		Jugador jugador2 = juego.jugador2();
		System.out.println(Extras.completaCadena("hola", "a", 3));
		System.out.println("Mensaje de prueba: "+Extras.adaptaInt(1, 1331));
		System.out.println("Mensaje de prueba: "+Extras.adaptaElem("asd", 1331));
		String cad_inicio = Extras.getStringColored("\n\tComienza el juego "+juego+"! ","PURPURA")+jugador1+" vs "
				+jugador2+Extras.getStringColored("!","PURPURA");
		System.out.println(cad_inicio);
		
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
