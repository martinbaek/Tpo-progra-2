package codigo;

import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	private class Elem{
		int cl, dato;
	}
	private Elem[] vector;
	private int cant;
	@Override
	public void inicializarDiccionarioSimple() {
		// TODO Auto-generated method stub
		vector = new Elem[1000];
		cant =0;
	}

	@Override
	public void agregar(int c, int x) {
		// TODO Auto-generated method stub
		Elem n = new Elem();
		n.cl = c;
		n.dato = x;
		ConjuntoTDA conj= claves();
		if(cant !=0) {
			if(conj.pertenece(c))
				return;
		}
		vector[cant] = n;
		cant++;
	}

	@Override
	public void eliminar(int c) {
		// TODO Auto-generated method stub
		int i = cant-1;
		while(c != vector[i].cl) {
			i--;
		}
		vector[i] = vector[cant-1];
		cant--;
	}

	@Override
	public int obtener(int c) {
		// TODO Auto-generated method stub
		if(cant != 0) {
			int i = cant-1;
			while(c != vector[i].cl && i>=0) {
				i--;
			}
			return vector[i].dato;
		}else {
			return 0;
		}
	}

	@Override
	public ConjuntoTDA claves() {
		// TODO Auto-generated method stub
			ConjuntoTDA conjun = new Conjunto();
			conjun.inicializarConjunto();
			if(cant != 0) {
				int i = cant-1;
				while(i>=0) {
					conjun.agregar(vector[i].cl);
					i--;
				}
			}
			return conjun;
	}
	

}
