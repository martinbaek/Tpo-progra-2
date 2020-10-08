package codigo;

import java.util.Random;

import Interfaces.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	int[] v;
	int cant;
	final int posINF =0;
	Random posAzar;
	@Override
	public void inicializarConjunto() {
		// TODO Auto-generated method stub
		v=new int[100];
		cant = 0;
		posAzar = new Random(System.currentTimeMillis());
	}

	@Override
	public void agregar(int x) {
		// TODO Auto-generated method stub
		v[cant] = x;
		cant++;
	}

	@Override
	public void sacar(int x) {
		// TODO Auto-generated method stub
		int i = cant-1;
		while(v[i] != x) {
			i--;
		}
		v[i] = v[cant - 1];
		cant--;
	}

	@Override
	public int elegir() {
		// TODO Auto-generated method stub
		if(cant==0) { //para saber cuando esta vacia
			return -1;
		}
		int i = posAzar.nextInt(cant - 1 - posINF + 1) + posINF;
		return v[i];
	}

	@Override
	public boolean conjuntoVacio() {
		// TODO Auto-generated method stub
		return cant ==0;
	}

	@Override
	public boolean pertenece(int x) {
		// TODO Auto-generated method stub
		int i = cant-1;
		while(v[i] != x && i >= 0) {
			i--;
		}
		if(i<0)
			return false;
		return true;
	}

}
