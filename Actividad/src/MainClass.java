import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Nicolás David Espejo Bernal
 * @author Cristían Mora
 * @author Manuel Pinilla
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
		System.out.println("¡Fila llena! \nCantidad de tiempo en llenar fila: " + tiempo + " minutos." +"\n");
		return colaClientes;
	}

	/**
	 * Recibe un número y verifica que sea superior a cero.
	 * @return = entero.
	 */
	public static int checkInt ()
	{
		Scanner sc = new Scanner (System.in);
		int n = 0;
		while (n <= 0) 
		{
			n = sc.nextInt();
			if(n <= 0)
				System.out.println("Número no válido. Digítelo nuevamente.");
		}
		sc.close();
		return n;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		LinkedList <Integer> cola = new LinkedList <Integer> ();
		Random rd = new Random();
		
		System.out.println("Ingrese la cantidad de clientes que desea atender:");
		int n = checkInt();
		cola = clientes(n);
		
		boolean caja1 = false, caja2 = false;
		// Tiempo = controla el for; var1 = Tiempo atendiendo caja1; var2 = Tiempo atendiendo caja2
		int tiempo = 0, var1 = 0, var2 = 0, aux1 = 0, aux2 = 0 ; 
		
		while(!cola.isEmpty())
		{
			if (!caja1)
			{
				if(cola.isEmpty())
					break;
				System.out.println("Caja 1 atiende cliente " + cola.size() + " minuto " + tiempo);
				cola.removeLast(); // Quita de la cola al cliente
				var1 = rd.nextInt(15) + 5; // Tiempo en que tardará la caja en atender. De 5 a 20.
				aux1 = tiempo;  // Se guarda el tiempo del momento en que entra en la variable.
				System.out.println("\t por " + var1  + " minutos");
				caja1 = true; // Caja ocupada
			}
			// Si la caja está llenar (true) y el minuto es igual al que tardaba en atender, cambia de estado la caja.
			if(caja1 && tiempo == (var1 + aux1))
				caja1 = false;
			
			if (!caja2)
			{
				if(cola.isEmpty())
					break;
				System.out.println("Caja 2 atiende cliente " + cola.size() + " minuto " + tiempo);
				cola.removeLast(); // Quita de la cola al cliente
				var2 = rd.nextInt(15) + 5; // Tiempo en que tardará la caja en atender. De 5 a 20.
				aux2 = tiempo; // Se guarda el tiempo del momento en que entra en la variable.
				System.out.println("\t por " + var2  + " minutos");
				caja2 = true; // Caja ocupada
			}
			// Si la caja está llenar (true) y el minuto es igual al que tardaba en atender, cambia de estado la caja.
			if(caja2 && tiempo == (var2 + aux2))
				caja2 = false;
			tiempo ++;	
		}
		System.out.println("Tiempo tardado en atender: " + (tiempo - 1) + " minutos.");
	}

}
