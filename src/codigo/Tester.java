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
	/*
	private static TablaTDA peliculas;
	private static TablaTDA proveedores;
	private static ColaNTDA movimientos;
	*/
	public static void main(String[] args) {
		TablaTDA peliculas;
		TablaTDA proveedores;
		ColaNTDA movimientos;
		// TODO Auto-generated method stub
		peliculas = new TablaDinamica();
		proveedores = new Tabla();
		movimientos = new ColaDinamica();
		movimientos.inicializarCola();
		proveedores.inicializarTabla();
		peliculas.inicializarTabla();
		cargarPeliculas("LISTADO DE PELICULAS.txt",peliculas);
		cargarProveedores("StreamCia.txt",proveedores);
		cargarMovimientos("Movimientos.txt", movimientos, proveedores, peliculas);
		peliculas.ordenarCodigos();
		/**
		*peliculas.ordenarNombres();
		*
		*ColaTDA mostrar = peliculas.tabla();
		*while(!mostrar.colaVacia()) {
		*	System.out.println(mostrar.primero());
		*	mostrar.desacolar();
		*}
		*while(!movimientos.colaVacia()) {
		*	System.out.println(movimientos.primero());
		*	movimientos.desacolar();
		*	}
		**/
		mostrarUltimosDiez(movimientos);
	}
	
	public static void cargarMovimientos(String archivo, ColaNTDA movimientos, TablaTDA proveedores, TablaTDA peliculas) {
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

	public static void cargarPeliculas(String archivo, TablaTDA peliculas) {
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
	
	public static void cargarProveedores(String archivo, TablaTDA proveedores) {
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
	
	public static ColaNTDA invertirCola(ColaNTDA dada) {
		ColaNTDA invertido;
		ColaNTDA resto;
		invertido = new ColaDinamica();
		resto  = new ColaDinamica();
		invertido.inicializarCola();
		resto.inicializarCola();
		int aux =0;
		while(!dada.colaVacia() || !resto.colaVacia()) {
			int a = 0;

			while(!dada.colaVacia()) {
				a = dada.primero();
				dada.desacolar();
				if(dada.colaVacia()) {
					aux = a;
				}else {
					resto.acolar(a);
				}
				
			}

			invertido.acolar(aux);
			while(!resto.colaVacia()) {
				a = resto.primero();
				resto.desacolar();
				if(resto.colaVacia()) {
					aux=a;
				}else {
					dada.acolar(a);
				}
			}
			invertido.acolar(aux);
			
		}
		/*
		System.out.println("Cola invertida:");
		while(!invertido.colaVacia()) {
			System.out.println(invertido.primero());
			invertido.desacolar();
		}
		*/
		return invertido;
	}

	public static void mostrarCola(ColaNTDA dada) {
		System.out.println();
		while(!dada.colaVacia()) {
			System.out.println(dada.primero());
			dada.desacolar();
		}
	}
	
	public static ColaNTDA Primeros10(ColaNTDA dada) {
		ColaNTDA primeros = new ColaDinamica();
		primeros.inicializarCola();
		for(int i =0; i<10;i++) {
			primeros.acolar(dada.primero());
			dada.desacolar();
		}
		return primeros;	
	}
	
	public static void mostrarUltimosDiez(ColaNTDA movimientos) {
		ColaNTDA invertido = invertirCola(movimientos);
		ColaNTDA primerosDiez = Primeros10(invertido);
		primerosDiez = invertirCola(primerosDiez);
		System.out.println("Los ultimos 10 movimientos ordenados de los mas recientes a los menos recientes:");
		mostrarCola(primerosDiez);
		/*System.out.println("Decodificado:");
		while( !primerosDiez.colaVacia()) {
			String peli = peliculas.((primerosDiez.primero())%10000);
		}*/
	}
	
	
	
	
	
	
	
	
}