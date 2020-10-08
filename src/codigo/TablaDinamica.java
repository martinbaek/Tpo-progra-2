package codigo;

import Interfaces.ColaTDA;
import Interfaces.TablaTDA;

public class TablaDinamica implements TablaTDA {
	private class Nodo{
		int codigo;
		String nombre;
		Nodo siguiente;
	}
	private Nodo inicio;
	private int cant;
	@Override
	public void inicializarTabla() {
		// TODO Auto-generated method stub
		inicio = null;
		cant =0;
	}

	@Override
	public void agregar(String l) {
		// TODO Auto-generated method stub
		Nodo n = new Nodo();
		if(estaVacia() || !pertenece(l)) {
			cant++;
			n.codigo = cant;
			n.nombre = l;
			n.siguiente = inicio;
			inicio = n;
			//System.out.println(inicio.codigo +" ; " +inicio.nombre+"");
		}
	}

	@Override
	public boolean pertenece(String nombre) {
		// TODO Auto-generated method stub
		Nodo aux = inicio;
		while(aux != null) {
			if(aux.nombre.equals(nombre)) {
				return true;
			}
			aux = aux.siguiente;
		}
		return false;
	}

	@Override
	public int codigo(String nombre) {
		// TODO Auto-generated method stub
		Nodo aux = inicio;
		while(aux != null) {
			if(nombre.compareTo(aux.nombre) == 0) {
				return aux.codigo;
			}
			aux = aux.siguiente;
		}
		return 55;
	}

	@Override
	public ColaTDA tabla() {
		// TODO Auto-generated method stub.
		Nodo aux = inicio;
		ColaTDA codificado = new Cola();
		codificado.inicializarCola();
		while(aux != null) {
			//System.out.println(inicio.codigo +" ; " +inicio.nombre+"");
			String provi = aux.codigo+" ; "+ aux.nombre;
			codificado.acolar(provi);
			aux = aux.siguiente;
		}
		return codificado;
	}

	@Override
	public void ordenarNombres() {
		// TODO Auto-generated method stub
		if(!estaVacia()) {
			Nodo nuevo = inicio;
			inicio = inicio.siguiente;
			nuevo.siguiente = null;
			Nodo auxiliar = nuevo;
			/*nuevo = inicio;
			inicio = inicio.siguiente;
			nuevo.siguiente=null;*/
			while(inicio !=null) {
				nuevo = inicio;
				inicio = inicio.siguiente;
				nuevo.siguiente=null;
				Nodo ant = null;
				Nodo act = auxiliar;
				if(nuevo.nombre.compareTo(auxiliar.nombre) > 0) {
					
					while(act != null && nuevo.nombre.compareTo(act.nombre) > 0 ) {
						// mientras actual no este vacio y nuevo sea mas grande que actual
						ant = act;
						act = act.siguiente;
					}
					if(act == null) {
						ant.siguiente = nuevo;
					}else {
						nuevo.siguiente=act;
						ant.siguiente=nuevo;
					}					
				}else {
					nuevo.siguiente= auxiliar;
					auxiliar = nuevo;
				}
			}
			inicio= auxiliar;
			
		}
	}

	@Override
	public void ordenarCodigos() {
		// TODO Auto-generated method stub
		if(!estaVacia()) {
			Nodo nuevo = inicio;
			inicio = inicio.siguiente;
			nuevo.siguiente = null;
			Nodo auxiliar = nuevo;
			/*nuevo = inicio;
			inicio = inicio.siguiente;
			nuevo.siguiente=null;*/
			while(inicio !=null) {
				nuevo = inicio;
				inicio = inicio.siguiente;
				nuevo.siguiente=null;
				Nodo ant = null;
				Nodo act = auxiliar;
				if(nuevo.codigo > (auxiliar.codigo) ) {
					
					while(act != null && nuevo.codigo > (act.codigo) ) {
						// mientras actual no este vacio y nuevo sea mas grande que actual
						ant = act;
						act = act.siguiente;
					}
					if(act == null) {
						ant.siguiente = nuevo;
					}else {
						nuevo.siguiente=act;
						ant.siguiente=nuevo;
					}					
				}else {
					nuevo.siguiente= auxiliar;
					auxiliar = nuevo;
				}
			}
			inicio= auxiliar;
			
		}
	}

	@Override
	public boolean estaVacia() {
		// TODO Auto-generated method stub
		return inicio==null;
	}

}
