import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 
 */

/**
 * @author Nicol�s David Espejo Bernal
 *
 * 10/08/2018
 */
public class Manejo_arrays {
	
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
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
	 * Imprime matriz.
	 * @param matrix
	 */
	private static void printMatrix (int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.print("\n");
		}
	}
	
	/**
	 * Llenar matriz.
	 * @param matrix
	 */
	private static void fillMatrix (int[][] matrix)
	{
		Random rd = new Random();

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[i][j] = rd.nextInt(120) + 1;
	}
	
	/**
	 * Calcula producci�n total de la semana y la imprime, junto con el n�mero de la vaca que dio m�s leche por d�a.
	 * @param matrix
	 */
	private static void prodTotal (int[][] matrix)
	{
		String [] days = {"Lunes", "Martes", "Mi�rcoles", "Jueves", "Viernes", "S�bado", "Domingo"};
		int aux = 0;
		for(int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
				aux += matrix[i][j];
			
			System.out.println("\nProducci�n total del " + days[i] + " : " + aux);
			aux = 0;
			greaterCow(matrix, i);
		}
	}
	
	/**
	 * Muestra la mayor cantidad de litros en la semana, con la cantidad y el n�mero de vaca.
	 * @param matrix
	 * @param week = fila
	 */
	private static void greaterCow (int[][] matrix, int week)
	{
		int greater = 0, greaterIndex = 0;
		
		for (int i = 0; i < matrix[0].length; i++)
			if (matrix[week][i] > greater)
			{
				greater = matrix[week][i];
				greaterIndex = i;
			}
		System.out.println("\tLa vaca con mayor producci�n fue la No. " + (greaterIndex + 1) + ", con " + greater + " Litros.");
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
	
	/**
	 * 
	 * @param n = n�mero de vacas
	 */
	public void punto3(int n)
	{
		try 
		{
			int[][] hato = new int [7][n];
			
			fillMatrix(hato);
			printMatrix(hato);
			prodTotal(hato);
		}
		catch(Exception ex){}
	}
}
