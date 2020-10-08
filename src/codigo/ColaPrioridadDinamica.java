package codigo;

import Interfaces.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {
	class Nodo{
		int dato, prior;
		Nodo sig;
	}
	
	
	private Nodo inicio;
	
	@Override
	public void inicializarCola() {
		// TODO Auto-generated method stub
		inicio = null;
	}

	@Override
	public void acolarPrioridad(int x, int p) {
		// TODO Auto-generated method stub
		Nodo nuevo = new Nodo();
		nuevo.dato = x;
		nuevo.prior = p;
		if(inicio == null) {
			// Lista Vacia
			nuevo.sig = null;
			inicio = nuevo;
			return;
		}
		if(p > inicio.prior) {// inserto al inicio
			nuevo.sig = inicio;
			inicio = nuevo;
			return;
		}
		Nodo corriente = inicio;
		Nodo anterior = null;
		while(corriente != null && p<= corriente.prior) {
			anterior = corriente;
			corriente = corriente.sig;
		
		}
		if( corriente == null) {// agrego al final
			nuevo.sig = null;
			anterior.sig = nuevo;
			return;
		}
		nuevo.sig = corriente; // agrego entre nodo
		anterior.sig = nuevo;
	}

	@Override
	public void desacolar() {
		// TODO Auto-generated method stub
		inicio = inicio.sig;
	}

	@Override
	public int primero() {
		// TODO Auto-generated method stub
		return inicio.dato;
	}

	@Override
	public int prioridad() {
		// TODO Auto-generated method stub
		return inicio.prior;
	}

	@Override
	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return inicio == null;
	}

}
