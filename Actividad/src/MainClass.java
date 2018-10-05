import java.util.LinkedList;
import java.util.Random;

/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 4/10/2018
 */
public class MainClass 
{
	/**
	 * Genera los clientes ingresados más una cantidad de tiempo aleatoria de 1 - 10 para cada cliente.
	 * @param n = Cantidad de clientes
	 * @return = Cola con los clientes
	 */
	public static LinkedList <Integer> clientes(int n)
	{
		Random rd = new Random();
		LinkedList <Integer> colaClientes = new LinkedList <Integer>();
		int tiempo = 0, aux;
		for(int i = 0 ; i < n ; i++)
		{
			aux = rd.nextInt(9) + 1;
			colaClientes.addFirst(aux);
			tiempo += aux;			
		}
		System.out.println("¡Fila llena! \nCantidad de tiempo en llenar fila: " + tiempo + " minutos.");
		return colaClientes;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		LinkedList <Integer> cola = new LinkedList <Integer> ();
		Random rd = new Random();
		
		cola = clientes(6);
		//System.out.println(cola);
		
		boolean caja1 = false, caja2 = false;
		// Tiempo = controla el for; var1 = Tiempo atendiendo caja1; var2 = Tiempo atendiendo caja2
		int tiempo = 1, var1 = 0, var2 = 0; 
		
		
		while(!cola.isEmpty()) 
		{
			// El for es la cantidad de minutos que se usarán.
			for (int i = 0 ; i < tiempo ; i++)
			{
				if (!caja1)
				{
					if(cola.isEmpty())
						break;
					System.out.println("Caja 1 atiende cliente " + cola.size() + " minuto " + i);
					cola.removeLast(); // Quita de la cola al cliente
					var1 = rd.nextInt(15) + 5; // Tiempo en que tardará la caja en atender. De 5 a 20.
					System.out.println("\t por " + var1 + " minutos");
					tiempo += var1; // Se aumenta la cantidad de tiempo.
					caja1 = true; // Caja ocupada
				}
				// Si la caja está llenar (true) y el minuto es igual al que tardaba en atender, cambia de estado la caja.
				if(caja1 && i==var1)
					caja1 = false;
				
				if (!caja2)
				{
					if(cola.isEmpty())
						break;
					System.out.println("Caja 2 atiende cliente " + cola.size() + " minuto " + i);
					cola.removeLast(); // Quita de la cola al cliente
					var2 = rd.nextInt(15) + 5; // Tiempo en que tardará la caja en atender. De 5 a 20.
					System.out.println("\t por " + var2 + " minutos");
					tiempo += var2; // Se aumenta la cantidad de tiempo.
					caja2 = true; // Caja ocupada
				}
				// Si la caja está llenar (true) y el minuto es igual al que tardaba en atender, cambia de estado la caja.
				if(caja2 && i==var2)
					caja2 = false;
			}
		}
		System.out.println("Tiempo tardado en atender: " + (tiempo - 1));
	}

}
