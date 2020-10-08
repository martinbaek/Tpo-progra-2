package codigo;

import java.io.BufferedReader;
/*
 * @ Martin Baek
 */
import java.io.FileReader;

import Interfaces.ColaNTDA;
import Interfaces.ColaPrioridadTDA;
import Interfaces.ColaTDA;
import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioMultipleTDA;
import Interfaces.DiccionarioSimpleTDA;
import Interfaces.PilaTDA;
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
		movimientos = new ColaNDinamica();
		movimientos.inicializarCola();
		proveedores.inicializarTabla();
		peliculas.inicializarTabla();
		cargarPeliculas("LISTADO DE PELICULAS.txt",peliculas);
		cargarProveedores("StreamCia.txt",proveedores);
		cargarMovimientos("Movimientos.txt", movimientos, proveedores, peliculas);
		/**
		peliculas.ordenarCodigos();
		
		*peliculas.ordenarNombres();
		*
		ColaTDA mostrar = peliculas.tabla();
		while(!mostrar.colaVacia()) {
			System.out.println(mostrar.primero());
			mostrar.desacolar();
		}
		*
		while(!movimientos.colaVacia()) {
			System.out.println(movimientos.primero());
			movimientos.desacolar();
			}
		*
		if(movimientos.colaVacia())
			System.out.println("Movimientos vacio");
		*/
		//mostrarUltimosDiez(movimientos);
		//principalesClientes(movimientos);
		//rankinPeliculas(movimientos);
		cuatroPuntos(movimientos);

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
		invertido = new ColaNDinamica();
		resto  = new ColaNDinamica();
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

	public static void mostrarUltimosDiez(PilaTDA pilaMovi) {
		/*
		ColaNTDA invertido = invertirCola(colaMovi);
		ColaNTDA primerosDiez = Primeros10(invertido);
		
		primerosDiez = invertirCola(primerosDiez);
		*/
		System.out.println("Los ultimos 10 movimientos ordenados de los mas recientes a los menos recientes:\n");
		PilaTDA losDiez = new PilaDinamica();
		losDiez.inicializarPila();
		int i = 0;
		while(i<10) {
			losDiez.apilar(pilaMovi.tope());
			pilaMovi.desapilar();
			i++;
		}
		while(!losDiez.pilaVacia()) {
			int j = losDiez.tope();
			int pelicula = (j%10000) ;
			int cliente =j/1000000;
			int provee = (j/10000)%100;
			System.out.println("Cliente: "+cliente+" Pelicula: "+pelicula+" Proveedor: "+provee);
			losDiez.desapilar();
		}
		//mostrarCola(primerosDiez);
		/*System.out.println("Decodificado:");
		while( !primerosDiez.colaVacia()) {
			String peli = peliculas.((primerosDiez.primero())%10000);
		}*/
		System.out.println();
	}
	
	public static DiccionarioSimpleTDA diccionarioClientes(ColaNTDA listaMovi) {
		DiccionarioSimpleTDA dic = new DiccionarioSimpleDinamico();
		dic.inicializarDiccionarioSimple();
		while(!listaMovi.colaVacia()) {
			int cliente = listaMovi.primero()/1000000;
			if(dic.claves().pertenece(cliente)){
				int cantPelis = dic.obtener(cliente);
				cantPelis++;
				dic.eliminar(cliente);
				dic.agregar(cliente, cantPelis);
			}else {
				dic.agregar(cliente, 1);
			}
			listaMovi.desacolar();
		}
		return dic;
	}
	
	public static ColaPrioridadTDA colaRepetidos(DiccionarioSimpleTDA dic) {
		ColaPrioridadTDA colaPrioridad = new ColaPrioridadDinamica();
		colaPrioridad.inicializarCola();
		while(!dic.claves().conjuntoVacio()) {
			int x = dic.claves().elegir();
			int cant = dic.obtener(x);
			colaPrioridad.acolarPrioridad(x, cant);
			dic.eliminar(x);
		}
	return colaPrioridad;
	}
	
	public static void principalesClientes(ColaNTDA listaMovim) {
		ColaPrioridadTDA clientes = colaRepetidos(diccionarioClientes(listaMovim));
		ColaPrioridadTDA clientesMasVistos = new ColaPrioridadDinamica();
		clientesMasVistos.inicializarCola();
		int prior = clientes.prioridad();
		while(clientes.prioridad() == prior){
			int cliente = clientes.primero();
			clientesMasVistos.acolarPrioridad(prior, cliente);
			clientes.desacolar();
		}
		System.out.println("Los clientes que solicitaron la mayor cantidad de peliculas( "+prior+" ):\n");
		while(!clientesMasVistos.colaVacia()) {
			System.out.println(clientesMasVistos.prioridad());
			clientesMasVistos.desacolar();
		}
		System.out.println();
	}
	
	public static DiccionarioSimpleTDA diccionarioPeliculas(ColaNTDA listaMovi) {
		DiccionarioSimpleTDA dic = new DiccionarioSimpleDinamico();
		dic.inicializarDiccionarioSimple();
		while(!listaMovi.colaVacia()) {
			int peli = listaMovi.primero() % 10000;
			if(dic.claves().pertenece(peli)){
				int cantPelis = dic.obtener(peli);
				cantPelis++;
				dic.eliminar(peli);
				dic.agregar(peli, cantPelis);
			}else {
				dic.agregar(peli, 1);
			}
			listaMovi.desacolar();
		}
		return dic;
		
	}
	
	public static void rankinPeliculas(ColaNTDA listaMovim) {
		ColaPrioridadTDA pelis = colaRepetidos(diccionarioPeliculas(listaMovim));
		int i = 0;
		System.out.println("Peliculas mas reproducidas: \n");
		while(i<10) {
			System.out.println(pelis.primero()+":  "+pelis.prioridad());
			pelis.desacolar();
			i++;
		}
		System.out.println();
	}

	public static void rankinClientePelicula(ColaNTDA listaMovi) {
		DiccionarioMultipleTDA peliculaCliente = new DiccionarioMultipleDinamico();
		DiccionarioMultipleTDA peliculaProveedor = new DiccionarioMultipleDinamico();
		peliculaCliente.inicializarDiccionarioMultiple();
		peliculaProveedor.inicializarDiccionarioMultiple();
		ConjuntoTDA listado = new ConjuntoDinamico();
		listado.inicializarConjunto();
		while(!listaMovi.colaVacia()) {
			int i = listaMovi.primero();
			int pelicula = (i%10000) ;
			int cliente =i/1000000;
			int provee = (i/10000)%100;
			peliculaCliente.agregar(pelicula, cliente);
			peliculaProveedor.agregar(pelicula, provee);
			if(!listado.pertenece(pelicula))
				listado.agregar(pelicula);
			listaMovi.desacolar();
		}
		System.out.println("Listado de pelicuas con los clientes y proveedores:\n");
		while(!listado.conjuntoVacio()) {
			int pelicula = listado.elegir();
			ConjuntoTDA proveedores = peliculaProveedor.obtener(pelicula);
			ConjuntoTDA clientes = peliculaCliente.obtener(pelicula);
			System.out.print("La pelicula "+pelicula+" fue vista por los clientes: ");
			while(!clientes.conjuntoVacio()) {
				int cli = clientes.elegir();
				System.out.print(" "+cli);
				clientes.sacar(cli);
			}
			System.out.print(" Los proveedores: ");
			while(!proveedores.conjuntoVacio()) {
				int prov = proveedores.elegir();
				System.out.print(" "+prov);
				proveedores.sacar(prov);
			}
			System.out.println();
			listado.sacar(pelicula);
		}
		System.out.println();
	}
	
	public static void cuatroPuntos(ColaNTDA movimientos) {
		PilaTDA invertido = new PilaDinamica();
		ColaNTDA dicClientes = new ColaNDinamica();
		ColaNTDA dicPeliculas = new ColaNDinamica();
		ColaNTDA dicCliPeli = new ColaNDinamica();
		invertido.inicializarPila();
		dicClientes.inicializarCola();
		dicPeliculas.inicializarCola();
		dicCliPeli.inicializarCola();
		while(!movimientos.colaVacia()) {
			invertido.apilar(movimientos.primero());
			dicClientes.acolar(movimientos.primero());
			dicPeliculas.acolar(movimientos.primero());
			dicCliPeli.acolar(movimientos.primero());
			movimientos.desacolar();
		}
		mostrarUltimosDiez(invertido);
		principalesClientes(dicClientes);
		rankinPeliculas(dicPeliculas);
		rankinClientePelicula(dicCliPeli);

	}
	
	
}