package Servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz{

	public int menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("//////");
		System.out.println("[0] - Cerrar Menú");
		System.out.println("[1] - Modificar una línea específica");
		System.out.println("[2] - Modificar una posición específica de una línea específica");
		System.out.println("//////");
		
		int numUsu = sc.nextInt();
		
		return numUsu;
			
		
	}
}
