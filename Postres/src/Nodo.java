/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 7/11/2018
 */
public class Nodo 
{
	private String dato;
	private Nodo siguiente;
	
	public Nodo()
	{
		this.siguiente = null;
	}
	
	public Nodo(String dato)
	{
		this.dato = dato;
	}
	
	public void enlazarSiguiente(Nodo n)
	{
		siguiente = n;
	}
	
	public Nodo getSiguiente()
	{
		return siguiente;
	}
	
	public String getDato()
	{
		return dato;
	}
}
