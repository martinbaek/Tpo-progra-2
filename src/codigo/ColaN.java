package codigo;

import Interfaces.ColaNTDA;

public class ColaN implements ColaNTDA {
	int[] vector;
	int poner, sacar;
	@Override
	public void acolar(int c) {
		// TODO Auto-generated method stub
		vector[poner] = c;
		poner += 1;
		if(poner == 1101)
			poner =0;
	}

	@Override
	public int primero() {
		// TODO Auto-generated method stub
		return vector[sacar];
	}

	@Override
	public void desacolar() {
		// TODO Auto-generated method stub
		sacar+=1;
		if(sacar == 1101)
			sacar =0;
	}

	@Override
	public void inicializarCola() {
		// TODO Auto-generated method stub
		vector = new int[1101];
		poner = sacar = 0;
	}

	@Override
	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return sacar==poner;
	}

}
