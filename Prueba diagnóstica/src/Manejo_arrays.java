import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Nicol�s David Espejo Bernal
 *
 * 10/08/2018
 */
public class Manejo_arrays {
	
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	/**
	 * Convierte un String en un arreglo de enteros.
	 * @param line = String con enteros separados con espacio.
	 * @return = Arreglo de enteros.
	 */
	private static int[] convertir(String line)
	{
		String[] array = line.split(" ");
		int[] arrayInt = new int[array.length];
		
		for (int i = 0; i < array.length; i++)
			arrayInt[i] = Integer.parseInt(array[i]);
		
		return arrayInt;
	}
	
	/**
	 * Imprime arreglo.
	 * @param array
	 */
	private static void print (int [] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
	
	/**
	 * Bubblesort
	 * @param array = Arreglo de enteros desordenado.
	 */
	public static void bubbleSort (int [] array) 
	{
		boolean swapped; //Se crea un booleano que dir� si hubo "swap" o no.
		int swap; //Se crea una variable auxiliar para realizar el cambio dentro del vector.
		for (int i =0; i< array.length -1; i++) 
		{
			swapped = false; //Antes de que comience el ciclo, el booleano quedar� en Falso.
			for (int j= 0; j< array.length-1; j++) 
				if (array[j] > array[j+1]) 
				{ //Si se cumple la condici�n se hace "swap".
					swap = array [j];
					array [j] = array [j+1];
					array [j+1] = swap;
					swapped = true; //Si no se entra en esta condici�n, el booleano quedar� con el valor de antes (F).
				}
			if (!swapped) //Si el booleano sigue en falso, se rompe el ciclo.
				break;	
		}
	}
	
	/**
	 * 
	 */
	public void punto1()
	{
		try
		{
			System.out.println("Inserte l�nea de n�mero enteros separados con espacio.");
			String line = br.readLine();
			int[] arreglo = convertir(line);
			
			System.out.println("Ingrese n�mero a buscar:");
			int x = Integer.parseInt(br.readLine());
			
			for(int i = 0; i< arreglo.length; i++)
				if(arreglo[i] == x)						//Si el n�mero ingresado antes es igual, se imprime su �ndice.
					System.out.print(i + " ");		
		}
		catch (Exception ex) {}
	}
	
	/**
	 * 
	 */
	public void punto2()
	{
		try
		{
			System.out.println("Ingrese la primera serie de n�meros separados por espacio: ");
			String line1 = br.readLine();
			System.out.println("Ingrese la segunda serie de n�meros: ");
			String line2 = br.readLine();
			int [] array = convertir(line1 + " " + line2);
			bubbleSort(array);
			print(array);
		}
		catch (Exception ex) {}
	}
}
