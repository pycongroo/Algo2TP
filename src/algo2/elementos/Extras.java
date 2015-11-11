package algo2.elementos;

import java.util.HashMap;

public class Extras {
	private static HashMap<String, String> colores = inicializarColores() ;
	
	private static HashMap<String, String> inicializarColores()
	{
		HashMap<String, String> colors = new HashMap<String, String>();
		colors.put("RESET", "\u001B[0m");
		colors.put("NEGRO", "\u001B[30m");
		colors.put("ROJO", "\u001B[31m");
		colors.put("VERDE", "\u001B[32m");
		colors.put("AMARILLO", "\u001B[33m");
		colors.put("AZUL", "\u001B[34m");
		colors.put("PURPURA", "\u001B[35m");
		colors.put("CIAN", "\u001B[36m");
		colors.put("BLANCO", "\u001B[37m");
		return colors;
	}
	
	public static void imprimirEnColor(String cadena, String color){
		System.out.print(colores.get(color)+cadena+colores.get("RESET"));
	}

	public static void imprimirEnColor(int cadena, String color){
		System.out.print(colores.get(color)+(cadena)+colores.get("RESET"));
	}
	
	//utilizados
	public static String getStringColored(String cadena, String color){
		return colores.get(color)+cadena+colores.get("RESET");
	}
		
	public static String getStringColored(int cadena, String color){
		return colores.get(color)+cadena+colores.get("RESET");
	}
	
/*	public static String adaptaElem(String cad, int maximo){
		String cad_max = Integer.toString(maximo);
		int len_max=cad_max.length();
		int len_cad=cad.length();
		String cad_aux="";
		for (int i = 0; i<(len_max-len_cad); i++ ){
			cad_aux+=" ";
		}
		cad_aux+=cad;
		return cad_aux;
	}
	
	public static String adaptaInt(int numero, int maximo){
		String cad_max = Integer.toString(maximo);
		String cad_num = Integer.toString(numero);
		int len_max=cad_max.length();
		int len_num=cad_num.length();
		String cad_aux="";
		for (int i = 0; i<(len_max-len_num); i++ ){
			cad_aux+="0";
		}
		cad_aux+=cad_num;
		return cad_aux;
	}
*/
	public static String adaptaInt(int numero, int maximo){
		String cad_num=Integer.toString(numero);
		String cad_max=Integer.toString(maximo);
		return completaCadena(cad_num, "0",cad_max.length()-cad_num.length());
	}
	
	public static String adaptaElem(String cadena, int maximo){
		String cad_max=Integer.toString(maximo);
		return completaCadena(cadena, " ",cad_max.length()-cadena.length());
	}
	
	public static String completaCadena(String cadenaBase, String caracterAgregar, int veces){
		String cad_aux="";
		for (int i=0; i<veces; i++){
			cad_aux+=caracterAgregar;
		}
		cad_aux+=cadenaBase;
		return cad_aux;
	}
}
