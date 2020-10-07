package codigo;

import java.io.BufferedReader;
/*
 * @ Martin Baek
 */
import java.io.FileReader;

import Interfaces.ColaNTDA;
import Interfaces.ColaTDA;
import Interfaces.TablaTDA;

public class Tester {
	private static TablaTDA peliculas;
	private static TablaTDA proveedores;
	private static ColaNTDA movimientos;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		peliculas = new Tabla();
		proveedores = new Tabla();
		movimientos = new ColaDinamica();
		movimientos.inicializarCola();
		proveedores.inicializarTabla();
		peliculas.inicializarTabla();
		cargarPeliculas("LISTADO DE PELICULAS.txt");
		cargarProveedores("StreamCia.txt");
		cargarMovimientos("Movimientos.txt");
		ColaTDA mostrar = peliculas.tabla();
		/*while(!mostrar.colaVacia()) {
			System.out.println(mostrar.primero());
			mostrar.desacolar();
		}*/
		while(!movimientos.colaVacia()) {
			System.out.println(movimientos.primero());
			movimientos.desacolar();
		}
		
	}
	
	public static void cargarMovimientos(String archivo) {
		try {
			FileReader arch = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(arch);
			int dni, valor;
			
			String linea, nombreProveedor, nombrePelicula;
			//buffer.readLine();
			linea = buffer.readLine();
			while(linea != null) {
				String[] lista = linea.split(";");
				dni = Integer.valueOf(lista[0]);
				nombreProveedor = lista[2].trim();
				nombrePelicula = lista[1].trim();
				//System.out.println("*"+nombrePelicula+"*");
				valor = dni*1000000 + proveedores.codigo(nombreProveedor)*10000 + peliculas.codigo(nombrePelicula);
				movimientos.acolar(valor);
				linea = buffer.readLine();
			}
			arch.close();
		}
		catch(Exception e) {
			System.out.println("Error de lectura. Arch: "+archivo+": "+e);
		}
	}

	public static void cargarPeliculas(String archivo) {
		try {
			FileReader arch = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(arch);
			buffer.readLine();
			String linea;
			linea = buffer.readLine();
			while(linea != null) {
				peliculas.agregar(linea);
				linea = buffer.readLine();
			}
			arch.close();
		}
		catch(Exception e) {
			System.out.println("Error de lectura. Arch: "+archivo+": "+e);
		}
	}
	
	public static void cargarProveedores(String archivo) {
		try {
			FileReader arch = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(arch);
			buffer.readLine();
			String linea;
			linea= buffer.readLine();
			while(linea != null) {
				proveedores.agregar(linea);
				linea = buffer.readLine();
			}
			arch.close();
		}
		catch(Exception e) {
			System.out.println("Error de lectura. Arch: "+archivo+": "+e);
		}
	}
}