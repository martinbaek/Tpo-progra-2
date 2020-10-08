package codigo;

import Interfaces.ColaTDA;

public class ColaDinamica implements ColaTDA {
	class Nodo{
		String d;
		Nodo sig;
	}
	private Nodo inicio, fin;
	@Override
	public void acolar(String c) {
		// TODO Auto-generated method stub
		Nodo n = new Nodo();
		n.d = c;
		n.sig = null;
		if(inicio == null)
			inicio = fin = n;
		else {
			fin.sig = n;
			fin = n;
		}
	}

	@Override
	public String primero() {
		// TODO Auto-generated method stub
		return inicio.d;
	}

	@Override
	public void desacolar() {
		// TODO Auto-generated method stub
		inicio = inicio.sig;
		if(inicio == null)
			fin = null;
	}

	@Override
	public void inicializarCola() {
		// TODO Auto-generated method stub
		inicio = fin = null;
	}

	@Override
	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return inicio == null;
	}

}
