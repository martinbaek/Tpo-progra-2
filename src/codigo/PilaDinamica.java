package codigo;

import Interfaces.PilaTDA;

public class PilaDinamica implements PilaTDA {
	class Nodo{
		int d;
		Nodo sig;
	}
	private Nodo inicio;
	@Override
	public void inicializarPila() {
		// TODO Auto-generated method stub
		inicio = null;
	}

	@Override
	public void apilar(int x) {
		// TODO Auto-generated method stub
		Nodo n = new Nodo();
		n.d = x;
		n.sig = inicio;
		inicio = n;
	}

	@Override
	public void desapilar() {
		// TODO Auto-generated method stub
		inicio = inicio.sig;
	}

	@Override
	public int tope() {
		// TODO Auto-generated method stub
		return inicio.d;
	}

	@Override
	public boolean pilaVacia() {
		// TODO Auto-generated method stub
		return inicio == null;
	}

}
