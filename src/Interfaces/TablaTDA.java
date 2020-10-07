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
	 * @Tarea esta operación agrega un elemento nuevo a la tabla, donde el código corresponde a la cantidad
	 *	de elementos de la tabla antes de ingresar un nuevo nombre. El nombre no debe existir previamente en
	 *	la tabla. La tabla debe estar inicializada. Al no existir las operaciones eliminarElemento ni
	 *	actualizarElemento, los códigos serán únicos y consecutivos
	 */
	void agregar(String l);
	/*
	 *	@Pertenece: esta operación permite saber si un nombre ya fue ingresado a la tabla. La tabla debe estar
	 *	inicializada.
	 */
	boolean pertenece(String nombre);
	/*
	 * Codigo: indica cuál es el código de un nombre suministrado (no se elimina). El nombre debe existir
	 */
	int codigo(String nombre);
	/*
	 * Tabla: devuelve los elementos en una estructura cola, donde cada elemento de la cola corresponde a la
	 * concatenación del código y el nombre separado por el carácter “;”, según el orden en que se encuentren
	 * guardados. La tabla debe estar inicializada.
	 */
	ColaTDA tabla();
	/*
	 * OrdenarNombres: ordena los elementos de la tabla, alfabéticamente por los nombres. La tabla debe estar
	 * inicializada.
	 */
	void ordenarNombres();
	/*
	 * OrdenarCodigos: ordena los elementos de la tabla por los códigos, en forma ascendente. La tabla debe
	 * estar inicializada
	 */
	void ordenarCodigos();
	/*
	 * EstaVacia: informa si la tabla no tiene elementos. La tabla debe estar inicializada.
	 */
	boolean estaVacia();
}
