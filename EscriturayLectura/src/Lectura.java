/**
 * 
 */
import java.io.*;
import java.util.Scanner;
/**
 * @author Nicolás David Espejo Bernal
 *
 * 29/08/2018
 */
public class Lectura {

	/**
	 * @param args
	 */
	String renglones = ""; // Se tiene cada renglón separado con un guión.
	
	/**
	 * Se guarda cada renglón en una string. Los renglones se separan por un guión.
	 * @param line
	 * @param contador
	 */
	public void guardar (String line, int contador)
	{
		if(contador > 1)
			renglones += "-" + line;
		else
			renglones += line;
	}
	
	/**
	 * Llena la matriz, recibiendo el vector de renglones para cada fila.
	 * @param matriz
	 * @param renglones
	 */
	public void llenarMatriz(int [][] matriz, String [] renglones)
	{
		for (int i = 0; i < matriz.length; i++)	
			for(int j = 0; j < matriz[0].length; j++)
			{	
				matriz[i][j] = Integer.parseInt(renglones[i].split(" ")[j]);
			}
	}
	
	/**
	 * Return el valor de la suma de la primera fila.
	 * @param matriz
	 * @return
	 */
	public static int firstLine (int[][]matriz)
	{
		int num = 0;
		for(int i = 0; i < matriz[0].length; i++)
			num += matriz[0][i];
		return num;
	}
	
	/**
	 * Suma los números de cada fila.
	 * @param matriz
	 * @param fila
	 * @return
	 */
	public static boolean contarFilas(int [][] matriz, int firstLine)
	{
		int num = 0;
		for(int i = 0; i < matriz[0].length; i++)
		{
			for (int j = 0 ; j < matriz.length; j++)
				num += matriz[i][j];
			if(num != firstLine)
				return false;
			num = 0;
		}
		return true;
	}
	
	/**
	 * Verifica que la suma de la suma de cada número, de cada columna, corresponda a "firstLine".
	 * sino es así, no es un cuadrado mágico, retornará falso.
	 * @param matriz
	 * @param firstLine
	 * @return
	 */
	public static boolean contarColumnas(int[][]matriz, int firstLine)
	{
		int num = 0;
		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0 ; j < matriz[0].length; j++)
				num += matriz[i][j];
			if (num != firstLine)
				return false;
			num = 0;
		}
		return true;
	}
	
	/**
	 * Verifica si la suma de los números de las diagonales es igual a "firstLine".
	 * @param matriz
	 * @param firstLine
	 * @return
	 */
	public static boolean contarDiagonales(int[][] matriz, int firstLine)
	{
		int num = 0, aux = 0;
		for(int i = 0; i < matriz.length; i++)
			num += matriz[i][i];
		if(num != firstLine)
			return false;
		num = 0;
		for(int i = matriz.length - 1; i >= 0; i--)
		{
			num += matriz[i][aux];
			aux ++;
		}
		if(num != firstLine)
			return false;
		return true;
	}
	/**
	 * Verifica que sea un cuadrado mágico.
	 * @param matriz
	 * @return
	 */
	public boolean check (int [][] matriz)
	{
		int firstLine = firstLine(matriz);
			if(!contarColumnas(matriz, firstLine))
				return false;
			if(!contarFilas(matriz, firstLine))
				return false;
			if(!contarDiagonales(matriz, firstLine))
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lectura lc = new Lectura();
		try
		{
			File read = new File("magico.txt");
			Scanner sc = new Scanner(read);
		
			int contador = 0; // Cuenta los renglones.
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				contador ++;
				lc.guardar(line, contador); 
			} sc.close();
			
			String[] lines = lc.renglones.split("-");	// Se tiene cada renglón en un arreglo.
			int[][] matrix = new int[contador][lines[0].split(" ").length]; // Se crea la matriz.
			lc.llenarMatriz(matrix, lines);
			
			if(lc.check(matrix))
				System.out.println("El archivo es un cuadrado mágico.");
			else
				System.out.println("No.");
			
		} catch(Exception ex) {}
	}

}
