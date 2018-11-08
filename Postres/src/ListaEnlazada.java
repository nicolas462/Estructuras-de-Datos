/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 7/11/2018
 */
public class ListaEnlazada 
{
	private Nodo cabeza;
	public int size;
	
	public ListaEnlazada()
	{
		cabeza = null;
	}
	
	public boolean isEmpty()
	{
		return (cabeza == null) ? true : false;
	}
	
	public void addFirst(String dato)
	{
		if(cabeza == null)
			cabeza = new Nodo (dato); 
		else
		{
			Nodo nuevo = new Nodo(dato);
			nuevo.enlazarSiguiente(cabeza);
			cabeza = nuevo;
		}
		size ++;
	}
	
	public void insertAtEnd(String dato)
	{
		if(cabeza == null)
			cabeza = new Nodo (dato);
		else
		{
			Nodo nuevo = new Nodo(dato);
			Nodo temp = cabeza;
			while(cabeza != null)
			{
				if(cabeza.getSiguiente() == null)
				{
					cabeza.enlazarSiguiente(nuevo);
					break;
				}
				cabeza = cabeza.getSiguiente();
			}
			cabeza = temp;
		}
		size++;
	}
	
	public void deleteFirst()
	{
		cabeza = cabeza.getSiguiente();
		size--;
	}
	
	public void deleteIndex(int n)
	{
		Nodo temp = cabeza;
		int cont = 0;
		while(cont < n - 1)
		{
			temp = temp.getSiguiente();
			cont ++;
		}
		temp.enlazarSiguiente(temp.getSiguiente().getSiguiente());
		size--;
	}
	
	public void printList()
	{
		if(cabeza == null || cabeza.getSiguiente() == null)
		{
			System.out.println("Lista vacía");
			return;
		}
		Nodo temp = cabeza;
		int cont = 0;
		while(temp != null)
		{
			if(cont == 0)
				System.out.println("Ingredientes " + temp.getDato() + ":");
			else
				System.out.println("\t" + cont + ") " + temp.getDato());
			temp = temp.getSiguiente();
			cont++;
		}
	}
	
	public void clearList()
	{
		cabeza = null;
	}
	
	
}
