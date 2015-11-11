package algo2.gokumo;

import algo2.elementos.Tablero;

public class TableroGokumo extends Tablero {
	
	public TableroGokumo(){
		super(10, 10);
	}
	
	public boolean estaLleno()
	{
		return todasLasFichas().stream().allMatch(ficha -> ficha != null);
	}
	
	protected void printarDesface(){
		System.out.println("\n\t");
	}
	
	public String getSimboloEn(int casillero){
		return getFicha(crearPosicion(casillero)).simbolo();
	}
	
	public boolean mismoJugador(JugadorGokumo unJugador, int unCasillero){
		System.out.println("jug1 :"+ unJugador.toString());
		FichaGokumo unaFicha = ((FichaGokumo) getFicha(crearPosicion(unCasillero)));
		if (unaFicha==null){
			return false;
		}
		System.out.println("jug2 :"+ unaFicha.getJugador().toString());
		return unJugador==unaFicha.getJugador();
	}
	
	public boolean tieneFichaEn(int unCasillero){
		return getFicha(crearPosicion(unCasillero))!=null;
	}
	
}
