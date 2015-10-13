package algo2.tateti;

import algo2.elementos.*;

public class MovimientoTateti extends Movimiento
{

	public MovimientoTateti(Ficha ficha, Tablero tablero, int casillero) 
	{
		super(ficha, tablero, casillero);
	}
	
	
	@Override
	protected boolean esInvalido() 
	{
		return tablero.getFicha(casillero) != null;
	}
	

	@Override
	public boolean esMovimientoFinal() 
	{
		return this.formaDiagonal() ||
			   this.formaVertical() ||
			   this.formaHorizontal();
	}
	
	
	private boolean formaHorizontal()
	{
		int columna = casillero % 3;
		int fila = (casillero - columna) / 3;
		
		Jugador posibleGanador = ((FichaTateti) this.ficha).jugador();
		
		boolean formaHorizontal = true;
		
		for(int nroColumna = 0; nroColumna < 3; nroColumna++)
		{
			FichaTateti ficha = (FichaTateti) tablero.getFichaPorPosicion(fila, nroColumna);
			
			if(ficha == null)
				return false;
			
			formaHorizontal = formaHorizontal && ficha.jugador() == posibleGanador;
		}
		
		return formaHorizontal;
	}
	
	private boolean formaVertical()
	{
		int columna = casillero % 3;
		
		Jugador posibleGanador = ((FichaTateti) this.ficha).jugador();
		
		boolean formaVertical = true;
		
		for(int nroFila = 0; nroFila < 3; nroFila++)
		{
			FichaTateti ficha = (FichaTateti) tablero.getFichaPorPosicion(nroFila, columna);
			
			if(ficha == null)
				return false;
			
			formaVertical = formaVertical && ficha.jugador() == posibleGanador;
		}
		
		return formaVertical;
	}
	
	
	private boolean formaDiagonal()
	{
		Jugador posibleGanador = ((FichaTateti) this.ficha).jugador();
		
		boolean formaPrimerDiagonal = true;
		
		for(int casillero = 0; casillero <= 8; casillero += 4)
		{
			FichaTateti ficha = (FichaTateti) tablero.getFicha(casillero);
			
			if(ficha == null)
				formaPrimerDiagonal = false;
			
			formaPrimerDiagonal = formaPrimerDiagonal && ficha.jugador() == posibleGanador;
		}
		
		boolean formaSegundaDiagonal = true;
		
		for(int casillero = 2; casillero <= 6; casillero += 2)
		{
			FichaTateti ficha = (FichaTateti) tablero.getFicha(casillero);
			
			if(ficha == null)
				formaSegundaDiagonal = false;
			
			formaSegundaDiagonal = formaSegundaDiagonal && ficha.jugador() == posibleGanador;
		}
		
		return formaPrimerDiagonal || formaSegundaDiagonal;
	}
}
