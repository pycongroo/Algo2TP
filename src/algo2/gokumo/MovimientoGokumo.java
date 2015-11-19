package algo2.gokumo;

import java.util.ArrayList;
import java.util.List;

import algo2.elementos.Ficha;
import algo2.elementos.Movimiento;
import algo2.elementos.Posicion;
import algo2.elementos.Tablero;

public class MovimientoGokumo extends Movimiento {
	
	// definir listas de puntos de arranque!!!
	private ArrayList<Integer> listaHR = new ArrayList<Integer>();
	private ArrayList<Integer> listaHL = new ArrayList<Integer>();
	private ArrayList<Integer> listaVU = new ArrayList<Integer>();
	private ArrayList<Integer> listaVD = new ArrayList<Integer>();
	private ArrayList<Integer> listaDNE = new ArrayList<Integer>();
	private ArrayList<Integer> listaDSE = new ArrayList<Integer>();
	private ArrayList<Integer> listaDNO = new ArrayList<Integer>();
	private ArrayList<Integer> listaDSO = new ArrayList<Integer>();
	
	public MovimientoGokumo(Ficha ficha, Tablero tablero, Posicion posicion) 
	{
		super(ficha, tablero, posicion);
		inicializarlineas();
	}
	
	private void inicializarlineas(){
		int i,j;
		// inicializando Horizontal
		for (i=0;i<10;i++){
			// horizontal derecha
			for (j=0;j<=5;j++){
				this.listaHR.add(i*10+j);
			}
			// horizontal izquierda
			for (j=4;j<=9;j++){
				this.listaHL.add(i*10+j);
			}
		}
		// inicializando Vertical
		for (i=0;i<10;i++){
			// vertical abajo
			for (j=0;j<=5;j++){
				this.listaVD.add(j*10+i);
			}
			// vertical arriba
			for (j=4; j<=9; j++){
				this.listaVU.add(j*10+i);
			}
		}
		// inicializando diagonales Sur
		for (i=0;i<=5;i++){
			// diagonal Este
			for (j=0;j<=5;j++){
				this.listaDSE.add(i*10+j);
			}
			//diagonal Oeste
			for (j=4;j<=9;j++){
				this.listaDSO.add(i*10+j);
			}
		}
		// inicializando diagonales Norte
		for (i=4;i<=9;i++){
			// diagonal Este
			for (j=0;j<=5;j++){
				this.listaDNE.add(i*10+j);
			}
			//diagonal Oeste
			for (j=4;j<=9;j++){
				this.listaDNO.add(i*10+j);
			}
		}
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
	
//metodos antiguos
	private boolean algunoForma5(){
		//List<Integer> casillerosUtiles = (List<Integer>) todosLosCasilleros().stream().
		//		filter(unCasillero -> ((TableroGokumo) tablero).tieneFichaEn(unCasillero));
		//casillerosUtiles.add(this.posicion.fila()*10+this.posicion.columna());
		List<Integer> casillerosUtiles = (List<Integer>) todosLosCasilleros();
		return casillerosUtiles.stream().
				anyMatch(unCasillero -> this.forma5(unCasillero));
	}
	
	private boolean forma5(int casillero){
		FichaGokumo ficha_t = (FichaGokumo)tablero.getFicha(tablero.crearPosicion(casillero));
		if (ficha_t != null) {
			return this.formaDiagonal(casillero)||this.formaLineal(casillero);
		} else {
			return false;
		}
	}
	
	private List<Integer> todosLosCasilleros(){
		List<Integer> casilleros = new ArrayList<Integer>();
		for (int i=0;i<100;i++){
			casilleros.add(i);
		}
		return casilleros;
	}
	
	private boolean formaDiagonal(int casillero){
		return this.diagonalSO(casillero)||this.diagonalSE(casillero)||
				this.diagonalNO(casillero)||this.diagonalNE(casillero);
	}
	
	private boolean diagonalSO(int casillero){
		if (listaDSO.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<5;i++){
				casilleros.add(casillero+i*9);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}
	
	private boolean diagonalSE(int casillero){
		if (listaDSE.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<5;i++){
				casilleros.add(casillero+i*11);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}
	
	private boolean diagonalNO(int casillero){
		if (listaDNO.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<5;i++){
				casilleros.add(casillero-i*11);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}
	
	private boolean diagonalNE(int casillero){
		if (listaDNE.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<5;i++){
				casilleros.add(casillero-i*9);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}
	
	private boolean formaLineal(int casillero){
		return this.horizontalR(casillero)||this.horizontalL(casillero)||
				this.verticalD(casillero)||this.verticalU(casillero);
	}
	
	private boolean horizontalR(int casillero){
		if (listaHR.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<5;i++){
				casilleros.add(casillero+i);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}
	
	private boolean horizontalL(int casillero){
		if (listaHL.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<5;i++){
				casilleros.add(casillero-i);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}
	
	private boolean verticalD(int casillero){
		if (listaVD.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<=5;i++){
				casilleros.add(casillero+i*10);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}

	private boolean verticalU(int casillero){
		if (listaVU.contains(casillero)){
			ArrayList<Integer> casilleros = new ArrayList<>();
			for (int i=0;i<=5;i++){
				casilleros.add(casillero-i*10);
			}
			JugadorGokumo posibleGanador = ((FichaGokumo) this.ficha).getJugador();
			return mismoEquipo(posibleGanador, casilleros);
		} else {
			return false;
		}
	}
	
	private boolean mismoEquipo(JugadorGokumo unJugador, ArrayList<Integer> casilleros){
		return casilleros.stream().allMatch(unCasillero -> ((TableroGokumo) tablero).mismoJugador(unJugador, unCasillero));
	}

}
