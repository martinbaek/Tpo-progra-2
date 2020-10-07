/*
 * @ martin baek
 */
package Interfaces;

public interface PilaTDA {
	/*
	 * inicializa pila
	 */
	void inicializarPila();
	/*
	 * pone un elemento en la parte superior
	 */
	void apilar(int x);
	/*
	 * saca un elemento de la parte superior
	 */
	void desapilar();
	/*
	 * muestra el tope
	 */
	int tope();
	/*
	 * muestra su una pila esta vacia
	 */
	boolean pilaVacia();
}
