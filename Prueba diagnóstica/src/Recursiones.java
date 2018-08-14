import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nicol�s David Espejo Bernal
 *
 * 12/08/2018
 */
public class Recursiones {
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Se toma el �ltimo de los n�meros de cada cadena, convirti�ndolo en entero, luego se llama la funci�n de nuevo.
	 * @param numero = n�mero a sumar en String
	 * @return = Resultado de sumar cada uno de los digitos del n�mero
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
	 * @param a = n�mero 1
	 * @param b = n�mero 2
	 * @return = M�ximo com�n divisor
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
		System.out.println("Ingrese n�mero para sumar digitos: ");
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
