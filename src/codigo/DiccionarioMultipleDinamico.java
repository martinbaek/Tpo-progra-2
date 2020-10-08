package codigo;

import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA {
	class Nodo{
		int clave;
		NodoValor primer;
		Nodo sig;
	}
	class NodoValor{
		int valor;
		NodoValor sigValor;
	}
	private Nodo inicio;
	@Override
	public void inicializarDiccionarioMultiple() {
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
			n.primer = null;
			n.sig = inicio;
			inicio = n;
			actualClave = inicio;
		}
		NodoValor nuevoValor = new NodoValor();
		nuevoValor.valor = x;
		nuevoValor.sigValor = actualClave.primer;
		actualClave.primer = nuevoValor;
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
	public void eliminarValor(int c, int x) {
		// TODO Auto-generated method stub
		Nodo actualClave = inicio;
		while(actualClave != null && actualClave.clave != c)
			actualClave = actualClave.sig;
		NodoValor actual = actualClave.primer, ant = null;
		while(actual.valor != x) {
			ant = actual;
			actual = actual.sigValor;
		}
		if(ant == null)
			actualClave.primer = actualClave.primer.sigValor;
		else
			ant.sigValor= actual.sigValor;
		if(actualClave.primer ==null)
			eliminar(actualClave.clave);
	}

	@Override
	public ConjuntoTDA obtener(int c) {
		// TODO Auto-generated method stub
		ConjuntoTDA resultado = new Conjunto();
		resultado.inicializarConjunto();
		Nodo actualClave = inicio;
		while(actualClave != null && actualClave.clave != c)
			actualClave = actualClave.sig;
		NodoValor actual = actualClave.primer;
		while( actual != null) {
			resultado.agregar(actual.valor);
			actual = actual.sigValor;
		}
		return resultado;
	}

	@Override
	public ConjuntoTDA claves() {
		// TODO Auto-generated method stub
		ConjuntoTDA resultado = new Conjunto();
		resultado.inicializarConjunto();
		Nodo actual = inicio;
		while(actual != null) {
			resultado.agregar(actual.clave);
			actual = actual.sig;
		}
		return resultado;
	}

}
