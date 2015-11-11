package algo2.gokumo;

import java.util.ArrayList;
import java.util.List;

import algo2.elementos.Ficha;
import algo2.elementos.Movimiento;
import algo2.elementos.Posicion;
import algo2.elementos.Tablero;

public class MovimientoGokumo extends Movimiento {
	
	public MovimientoGokumo(Ficha ficha, Tablero tablero, Posicion posicion) 
	{
		super(ficha, tablero, posicion);
	}
	
	
	@Override
	protected boolean esInvalido() 
	{
		return tablero.getFicha(posicion) != null;
	}
	
	
	@Override
	public boolean esMovimientoEmpate() 
	{
		return !esMovimientoFinal() && ((TableroGokumo) tablero).estaLleno();
	}


	@Override
	public boolean esMovimientoFinal() {
		System.out.println("entre a movfinal");
		return this.algunoForma5();
	}
	//cambiar posiciones por casilleros
	public boolean algunoForma5(){
		//List<Integer> casillerosUtiles = (List<Integer>) todosLosCasilleros().stream().
		//		filter(unCasillero -> ((TableroGokumo) tablero).tieneFichaEn(unCasillero));
		//casillerosUtiles.add(this.posicion.fila()*10+this.posicion.columna());
		List<Integer> casillerosUtiles = (List<Integer>) todosLosCasilleros();
		return casillerosUtiles.stream().
				anyMatch(unCasillero -> this.formaDiagonal(unCasillero)||this.formaLineal(unCasillero));
	}
	
	private List<Integer> todosLosCasilleros(){
		List<Integer> casilleros = new ArrayList<Integer>();
		for (int i=0;i<100;i++){
			casilleros.add(i);
		}
		return casilleros;
	}
	
	private boolean formaDiagonal(int casillero){
		return this.diagonal1(casillero)||this.diagonal2(casillero)||
				this.diagonal3(casillero)||this.diagonal4(casillero);
	}
	
	private boolean diagonal1(int casillero){
		return formaLinea5(casillero, -9);
	}
	
	private boolean diagonal2(int casillero){
		return formaLinea5(casillero, 11);
	}
	
	private boolean diagonal3(int casillero){
		return formaLinea5(casillero, 9);
	}
	
	private boolean diagonal4(int casillero){
		return formaLinea5(casillero, -11);
	}
	//////
	private boolean formaLineal(int casillero){
		return this.horizontal1(casillero)||this.horizontal2(casillero)||
				this.vertical1(casillero)||this.vertical2(casillero);
	}
	
	private boolean horizontal1(int casillero){
		return formaLinea5(casillero, 1);
	}
	
	private boolean horizontal2(int casillero){
		return formaLinea5(casillero, 10);
	}
	
	private boolean vertical1(int casillero){
		return formaLinea5(casillero,-1);
	}
	
	private boolean vertical2(int casillero){
		return formaLinea5(casillero, -10);
	}
	
	private boolean formaLinea5(int casillero, int tipo){
		int x = this.posicion.columna();
		int y = this.posicion.fila();
		int c = tablero.getCColumna();
		int f = tablero.getCFila();
		if (cumplePrecondicion(x, y, tipo)){
			return tiene5fichasEnLinea(casillero, tipo);
		} else {
			return false;
		}
	}
	
	private boolean tiene5fichasEnLinea(int casillero,int tipo){
		JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador(); 
		List<FichaGokumo> fichas = new ArrayList<FichaGokumo>();
		int c_actual = casillero+tipo;
		fichas.add((FichaGokumo)tablero.getFicha(tablero.crearPosicion(casillero)));
		while ((c_actual<100 && c_actual>=0) &&
				((TableroGokumo) tablero).mismoJugador(posibleGanador, c_actual)){
			System.out.println("aceptado "+ c_actual);
			fichas.add((FichaGokumo) tablero.getFicha(tablero.crearPosicion(c_actual)));
			System.out.println("cantidad de fichas en linea: "+(c_actual-tipo)+ " " + fichas.size()+
					",tipo :"+tipo);
			c_actual+=tipo;
		}
		//System.out.println("cantidad de fichas en linea: "+(c_actual-tipo)+ " " + fichas.size()+
		//",tipo :"+tipo);
		return fichas.size()==5;
	}
	
	private boolean cumplePrecondicion(int x, int y,int tipo){
		int c = tablero.getCColumna();
		int f = tablero.getCFila();
		switch (tipo) {
		case -9:
			return (x>=0 && x<=c-5) && (y>=5 && y<=f);
		case 11:
			return (x>=0 && x<=c-5) && (y>=0 && y<=f-5);
		case 9:
			return (x>=5 && x<=c) && (y>=0 && y<=f-5);
		case -11:
			return (x>=5 && x<=c) && (y>=5 && y<=f);
		case 1:
			return (x>=0 && x<=c-5);
		case 10:
			return (y>=0 && y<=f-5);
		case -1:
			return (x>=5 && x<=c);
		case -10:
			return (y>=5 && y<=f);

		default:
			return false;
		}
	}
	

}
