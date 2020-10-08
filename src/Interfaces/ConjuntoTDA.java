package Interfaces;

public interface ConjuntoTDA {

	public void inicializarConjunto();
	public void agregar(int x);
	public void sacar(int x);
	public int elegir();
	boolean conjuntoVacio();
	boolean pertenece(int x);
}
