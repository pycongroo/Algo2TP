import java.util.ResourceBundle;


public class JuegoFactory 
{
	
	public static Juego getJuego()
	{
		Juego juego = cargarArchivoDePropiedades();
		
		juego.crearTablero();
		
		juego.gestionarFichas();
		
		return juego;
	}	
	
	
	
	
	

	private static Juego cargarArchivoDePropiedades()
	{
		try
		{		
			ResourceBundle rb = ResourceBundle.getBundle("juego");
			
			String claseJuego = rb.getString("JUEGO");
			
			Juego juego = (Juego) Class.forName(claseJuego).newInstance();
			
			juego.setNombre( rb.getString("NOMBRE") );
			
			juego.crearJugador1( rb.getString("JUGADOR1") );
			juego.crearJugador2( rb.getString("JUGADOR2") );
			
			return juego;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
