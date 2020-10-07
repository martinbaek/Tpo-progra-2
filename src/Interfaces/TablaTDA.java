/*
 * @Martin Baek
 */
package Interfaces;

public interface TablaTDA {
	/*
	 * @Tarea Inicializa tabla
	 */
	void inicializarTabla();
	/*
	 * @Tarea esta operaci�n agrega un elemento nuevo a la tabla, donde el c�digo corresponde a la cantidad
	 *	de elementos de la tabla antes de ingresar un nuevo nombre. El nombre no debe existir previamente en
	 *	la tabla. La tabla debe estar inicializada. Al no existir las operaciones eliminarElemento ni
	 *	actualizarElemento, los c�digos ser�n �nicos y consecutivos
	 */
	void agregar(String l);
	/*
	 *	@Pertenece: esta operaci�n permite saber si un nombre ya fue ingresado a la tabla. La tabla debe estar
	 *	inicializada.
	 */
	boolean pertenece(String nombre);
	/*
	 * Codigo: indica cu�l es el c�digo de un nombre suministrado (no se elimina). El nombre debe existir
	 */
	int codigo(String nombre);
	/*
	 * Tabla: devuelve los elementos en una estructura cola, donde cada elemento de la cola corresponde a la
	 * concatenaci�n del c�digo y el nombre separado por el car�cter �;�, seg�n el orden en que se encuentren
	 * guardados. La tabla debe estar inicializada.
	 */
	ColaTDA tabla();
	/*
	 * OrdenarNombres: ordena los elementos de la tabla, alfab�ticamente por los nombres. La tabla debe estar
	 * inicializada.
	 */
	void ordenarNombres();
	/*
	 * OrdenarCodigos: ordena los elementos de la tabla por los c�digos, en forma ascendente. La tabla debe
	 * estar inicializada
	 */
	void ordenarCodigos();
	/*
	 * EstaVacia: informa si la tabla no tiene elementos. La tabla debe estar inicializada.
	 */
	boolean estaVacia();
}
