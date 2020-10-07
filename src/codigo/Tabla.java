/*
 * @ Martin Baek
 */
package codigo;

import Interfaces.ColaTDA;
import Interfaces.TablaTDA;

public class Tabla implements TablaTDA {
	private class linea {
		int codigo;
		String nombre;
	}
	private linea[] tablita;
	private int cant;
	@Override
	public void inicializarTabla() {
		// TODO Auto-generated method stub
		tablita = new linea[1100];
		cant = 0;
	}

	@Override
	public void agregar(String l) {
		// TODO Auto-generated method stub
		linea aux = new linea();
		if(cant == 0 || !pertenece(l)) {
			tablita[cant] = aux;
			cant ++;
			aux.codigo = cant;
			aux.nombre = l;
		}
	}

	@Override
	public boolean pertenece(String nombre) {
		// TODO Auto-generated method stub
		linea[] provi = tablita;
		int nprovi = cant;
		nprovi--;
		while(nprovi != 0) {
			if(!provi[nprovi].nombre.equals(nombre)) {
				nprovi--;
			}else {
				return true;
			}
		}
		return false;
	}

	@Override
	public int codigo(String nombre) {
		// TODO Auto-generated method stub
		int aux = cant;
		aux--;
		while(aux!=0) {
			if(nombre.compareTo(tablita[aux].nombre) == 0)
				return tablita[aux].codigo;
			aux--;
		}
		
		return aux+1;
	}

	@Override
	public ColaTDA tabla() {
		// TODO Auto-generated method stub
		if(cant!=0) {
			ColaTDA codificado = new Cola();
			codificado.inicializarCola();
			int aux = 0;
			while(aux != cant) {
				String provi = (aux+1)+" ; "+tablita[aux].nombre;
				codificado.acolar(provi);
				aux++;
			}
			return codificado;
		}
		return null;
	}

	@Override
	public void ordenarNombres() {
		// TODO Auto-generated method stub
		if(cant!=0) {
			int aux =cant;
			aux--;
			while(aux != 0) {
				int p =0;
				while(p != aux) {
					if(((tablita[p].nombre).compareTo(tablita[p+1].nombre))>0){
						String instancia = tablita[p].nombre;
						int instan = tablita[p].codigo;
						tablita[p].nombre = tablita[p+1].nombre;
						tablita[p].codigo = tablita[p+1].codigo;
						tablita[p+1].nombre = instancia;
						tablita[p+1].codigo = instan;
					}
					p++;
				}
				aux--;
			}
		}
	}

	@Override
	public void ordenarCodigos() {
		// TODO Auto-generated method stub
		if(cant!=0) {
			int aux =cant;
			aux--;
			while(aux != 0) {
				int p =0;
				while(p != aux) {
					if((tablita[p].codigo)>(tablita[p+1].codigo)){
						String instancia = tablita[p].nombre;
						int instan = tablita[p].codigo;
						tablita[p].nombre = tablita[p+1].nombre;
						tablita[p].codigo = tablita[p+1].codigo;
						tablita[p+1].nombre = instancia;
						tablita[p+1].codigo = instan;
					}
					p++;
				}
				aux--;
			}
		}
	}

	@Override
	public boolean estaVacia() {
		// TODO Auto-generated method stub
		return cant==0;
	}

}
