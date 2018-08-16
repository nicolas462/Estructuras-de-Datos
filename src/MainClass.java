import java.util.Scanner;

/**
 * 
 */

/**
 * @author BOG-A408-E-003
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	
	
	static void mostrarMatriz(int matrix [][])
	{
		for(int i =  0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println("\n");
		}
	}
	
	static boolean filled (int matrix[][], int fila, int columna)
	{
		if(matrix[fila][columna] != 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int matrix [][] = new int [3][3];
		
		int menu = 0, fila = 0, columna = 0;
		do
		{
			System.out.println("1. Mostrar estado actual del tablero.");
			System.out.println("2. Realizar jugada.");
			System.out.println("Digite la opción a realizar.");
			menu = sc.nextInt();
			switch(menu)
			{
				case 1:
					mostrarMatriz(matrix);
					break;
				case 2:
					boolean check = false;
					System.out.println("Turno jugador A(1). Digite coordenadas de cero a tres (fila, columna).");
					do
					{
						fila = sc.nextInt();
						while(!(fila >= 0 && fila < 3))
						{
							System.out.println("Valor de fila inválido. Digítelo de nuevo.");
							fila = sc.nextInt();
						}
						
						columna = sc.nextInt();
						while(!(columna >= 0 && columna < 3))
						{
							 System.out.println("Valor de columna inválido. Digítelo de nuevo.");
							columna = sc.nextInt();
						}
						check = filled(matrix, fila, columna);
						
						if (check)
							System.out.println("Casilla llena. Ingrese fila y columna nuevamente.");
						matrix[fila][columna] = 1;
					} while(check);
					break;
				default:
					System.out.println("Valor inválido. Digite 1 para volver al menú, 0 para salir.");
					menu = sc.nextInt();
					break;
			}
		} while (menu == 1 || menu == 2);
		
	}

}
