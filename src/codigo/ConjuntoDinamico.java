package codigo;

import Interfaces.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA {
	class Nodo{
		int x;
		Nodo sig;
	}
	private Nodo prim;
	@Override
	public void inicializarConjunto() {
		// TODO Auto-generated method stub
		prim = null;
	}

	@Override
	public void agregar(int x) {
		// TODO Auto-generated method stub
		Nodo n = new Nodo();
		n.x = x;
		n.sig = prim;
		prim = n;
	}

	@Override
	public void sacar(int x) {
		// TODO Auto-generated method stub
		if(prim.x == x) {
			prim = prim.sig;
			return;
		}
		Nodo ant = null, act = prim;
		while(act.x != x) {
			ant = act;
			act = act.sig;
		}
		ant.sig = act.sig;
	}

	@Override
	public int elegir() {
		// TODO Auto-generated method stub
		return prim.x;
	}

	@Override
	public boolean conjuntoVacio() {
		// TODO Auto-generated method stub
		return prim == null;
	}

	@Override
	public boolean pertenece(int x) {
		// TODO Auto-generated method stub
		Nodo aux = prim;
		while(aux != null) {
			if(x == aux.x)
				return true;
			aux = aux.sig;
		}
		return false;
	}

}
