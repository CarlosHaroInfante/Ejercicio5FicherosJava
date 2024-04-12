package Ejercicio5Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import Servicios.MenuImplementacion;
import Servicios.MenuInterfaz;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuInterfaz menu = new MenuImplementacion();
		String ruta = "C:\\Users\\Carlos\\Desktop\\ED\\Ejercicio4Ficheros\\src\\Ejercicio4Ficheros\\prueba.txt";

		Scanner sc = new Scanner(System.in);
		
		boolean cerrarMenu = false;
		
		while(!cerrarMenu) {
			
			int op = menu.menu();
			
			switch (op) {
			case 0: {
				
				System.out.println("Se cerrará el menú");
				cerrarMenu = true;
				break;
			}
			case 1: {
				System.out.println("Modificar una línea específica");
				
				System.out.println("Dame la línea que quieres editar");
				int numLinea = sc.nextInt();
				
				System.out.println("Dame el texto que quieres añadir");
				String texto = sc.next();
				
				try {
					BufferedReader leo = new BufferedReader(new FileReader(ruta));
					StringBuilder contenido = new StringBuilder();
					String linea;
					
					int cuenta = 0;
					int numPosi = 0;
					
					while((linea = leo.readLine()) != null) {
						cuenta++;
						
						if(cuenta == numLinea) {
							contenido.append(linea.substring(0, numPosi)).append(texto).append(linea.substring(numPosi));
						}
						else {
							contenido.append(linea);
						}
						contenido.append(System.lineSeparator());
					}
					
					leo.close();
					
					BufferedWriter escribe = new BufferedWriter(new FileWriter(ruta));
					
					escribe.write(contenido.toString());
					
					escribe.close();
					
					System.out.println("Se ha escrito correctamente");
					
					break;
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			case 2: {
				System.out.println("Se modificará una posición específica de una línea específica");
				
				System.out.println("Dame la línea que quieres editar");
				int numLinea = sc.nextInt();
				
				System.out.println("Dame la posición que quieres editar");
				int numPosi = sc.nextInt();
				
				System.out.println("Dame el texto que quieres añadir");
				String texto = sc.next();
				
				try {
					BufferedReader leer = new BufferedReader(new FileReader(ruta));
					
					StringBuilder contenido = new StringBuilder();
					
					String lineaActual;
					
					int cuenta = 0;
					
					while((lineaActual = leer.readLine()) != null) {
						cuenta++;
						if(cuenta == numLinea) {
							contenido.append(lineaActual.substring(0, numPosi)).append(texto).append(lineaActual.substring(numPosi));
						}
						else {
							contenido.append(lineaActual);
						}
						
						contenido.append(System.lineSeparator());
					}
					 
						
						leer.close();
						
						BufferedWriter escribe = new BufferedWriter(new FileWriter(ruta));
						
						escribe.write(contenido.toString());
						
						escribe.close();
						
						System.out.println("Se ha escrito correctamente");
					
			
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error tipo I/O " + e.getMessage());
				}
				break;
			}
			default:
				System.out.println("Ninguna opción válida, intentalo otra vez");
				break;
			}
		}
		
	}

}
