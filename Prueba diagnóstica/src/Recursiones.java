import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 12/08/2018
 */
public class Recursiones {
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Se toma el último de los números de cada cadena, convirtiéndolo en entero, luego se llama la función de nuevo.
	 * @param numero = número a sumar en String
	 * @return = Resultado de sumar cada uno de los digitos del número
	 */
	private static int sumarDigitos (String numero)
	{
		if (numero.length() == 1)
			return Integer.parseInt(numero);
		else
			return Integer.parseInt(numero.substring(numero.length() - 1)) + sumarDigitos (numero.substring(0, numero.length() - 1));
	}
	
	/**
	 * Algoritmo de Euclides
	 * @param a = número 1
	 * @param b = número 2
	 * @return = Máximo común divisor
	 */
	public static int euclides(int a, int b)
	{
		if (b==0)
			return a;
		else
			return euclides(b, a%b);
	}
	
	/**
	 * 
	 */
	public void punto1()
	{
		System.out.println("Ingrese número para sumar digitos: ");
		System.out.println(sumarDigitos(sc.nextLine()));
	}
	
	/**
	 * 
	 */
	public void punto2(int a, int b)
	{
		System.out.println(euclides(a, b));
	}
}
