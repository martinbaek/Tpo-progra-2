package codigo;

import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioSimpleTDA;
import codigo.DiccionarioMultipleDinamico.Nodo;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
	class Nodo{
		int clave, x;
		Nodo sig;
	}
	private Nodo inicio;
	@Override
	public void inicializarDiccionarioSimple() {
		// TODO Auto-generated method stub
		inicio = null;
	}

	@Override
	public void agregar(int c, int x) {
		// TODO Auto-generated method stub
		Nodo actualClave = inicio;
		while(actualClave != null && actualClave.clave != c)
			actualClave = actualClave.sig;
		if(actualClave == null) {
			Nodo n = new Nodo();
			n.clave = c;
			n.x = x;
			n.sig = inicio;
			inicio = n;
			actualClave = inicio;
		}
	}

	@Override
	public void eliminar(int c) {
		// TODO Auto-generated method stub
		Nodo actual = inicio, ant = null;
		while(actual.clave != c) {
			ant=actual;
			actual = actual.sig;
		}
		if(ant == null)
			inicio = inicio.sig;
		else
			ant.sig=actual.sig;
	}

	@Override
	public int obtener(int c) {
		// TODO Auto-generated method stub
		Nodo actualClave = inicio;
		while(actualClave != null && actualClave.clave != c)
			actualClave = actualClave.sig;
		return actualClave.x;
	}

	@Override
	public ConjuntoTDA claves() {
		// TODO Auto-generated method stub
		ConjuntoTDA resultado = new ConjuntoDinamico();
		resultado.inicializarConjunto();
		Nodo actual = inicio;
		while(actual != null) {
			resultado.agregar(actual.clave);
			actual = actual.sig;
		}
		return resultado;
	}

}
