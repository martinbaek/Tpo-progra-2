package Interfaces;
/*
 * Diccionario múltiple es una colección de elementos asociados clave-valores. La clave y los valores son
 *números enteros. Las claves son únicas. No puede existir clave sin valor asociado. Los valores son únicos
 *para una misma clave.
 */
public interface DiccionarioMultipleTDA {
	/*
	 *InicializarDiccionarioMultiple: inicializa el diccionario.
	 */
	void inicializarDiccionarioMultiple();
	
	/*
	 *Agregar: agrega un valor a una clave, ambos datos suministrados. El diccionario debe estar inicializado y
	 *el valor no debe existir para esa clave. Si no existe la clave, se agrega.
	 */
	void agregar(int c, int x);
	
	/*
	 *Eliminar: elimina una clave suministrada junto con los valores asociados. La clave debe existir.
	 */
	void eliminar(int c);
	
	/*
	 *EliminarValor: elimina un valor asociado a una clave, ambos datos suministrados. Ambos deben existir.
	 */
	void eliminarValor(int c, int x);
	
	/*
	 *Obtener: devuelve el conjunto de valores asociados a una clave suministrada. No elimina los valores. La
	 *clave debe existir.
	 */
	ConjuntoTDA obtener(int c);
	
	/*
	 *Claves: devuelve el conjunto de claves del diccionario. No elimina las claves. El diccionario debe estar
	 *inicializado.
	 */
	ConjuntoTDA claves();
	
}
