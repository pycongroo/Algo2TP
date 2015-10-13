package algo2.tateti;

import algo2.elementos.Ficha;
import algo2.elementos.Movimiento;
import algo2.elementos.Tablero;

public class MovimientoTateti extends Movimiento
{

	public MovimientoTateti(Ficha ficha, Tablero tablero, int casillero) 
	{
		super(ficha, tablero, casillero);
	}

	@Override
	public boolean esMovimientoFinal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean esInvalido() {
		// TODO Auto-generated method stub
		return false;
	}

}
