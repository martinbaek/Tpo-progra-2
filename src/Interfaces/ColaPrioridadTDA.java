package Interfaces;

public interface ColaPrioridadTDA {
	void inicializarCola();
	void acolarPrioridad(int x, int p);
	/*
	 * x valor
	 * p prioridad
	 */
	void desacolar();
	int primero();
	int prioridad();
	boolean colaVacia();
}
