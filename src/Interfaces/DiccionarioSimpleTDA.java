package Interfaces;
/*
 *Diccionario simple es una colección de pares asociados clave-valor, ambos números enteros. Las claves
 *son únicas. No puede existir clave sin valor asociado.
 */
public interface DiccionarioSimpleTDA {
	/*
	InicializarDiccionarioSimple: inicializa el diccionario.
	*/
	void inicializarDiccionarioSimple();
	
	/*
	 *Agregar: permite agregar una clave con un valor, ambos suministrados. El diccionario debe estar
	 *inicializado y la clave no debe existir.
	 */
	void agregar(int c, int x);
	
	/*
	 *Eliminar: permite eliminar una clave suministrada. La clave debe existir.
	 */
	void eliminar(int c);
	
	/*
	 *Obtener: devuelve el valor asociado a una clave suministrada. No elimina el valor. La clave debe existir.
	 */
	int obtener(int c);
	
	/*
	 *Claves: devuelve el conjunto de claves del diccionario. No elimina las claves. El diccionario debe estar
	 *inicializado
	 */
	ConjuntoTDA claves();
}
