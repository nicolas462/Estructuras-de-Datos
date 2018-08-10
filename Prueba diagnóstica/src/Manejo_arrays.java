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
}
