import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * 
 */

/**
 * @author BOG-A408-E-018
 *
 */
public class MainClass {

	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static Operaciones op = new Operaciones();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String renglones = ""; // Se tiene cada renglón separado con un guión.
		try
		{
			File f = new File("hospital");
			Scanner sc = new Scanner(f);
			int contador = 0;
			
			// Se lee el archivo de texto
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				contador ++; 		// Cantidad de renglones, se usará para crear la matriz (filas).
				if(contador > 1)	// Se divide cada línea con un "/" para operar con split.
					renglones += line + "/";
			} sc.close();
			
			String [] arrayString = renglones.split("/"); // Se divide cada renglón.
			// Se crea la matriz que guardará los datos, se le resta uno al contador para no contar la primera fila
			// en la parte de las columnas, se le resta uno porque después del telefono existe doble tabulación.
			String [][] matrizString = new String [contador - 1][arrayString[0].split("\t").length - 1]; 
			op.llenarMatriz(arrayString, matrizString);
			
			Pacientes [] d1 = new Pacientes[arrayString.length];	// Se crea un registro para ingresar los valores de la matriz.
			op.llenarRegistro(d1, matrizString);
			
			System.out.println("Ingrese la cantidad de pacientes que desea ingresar:");
			int n = Integer.parseInt(br.readLine());
			Pacientes [] d2 = new Pacientes[n];
			op.llenarDatos(d2);
			
			menu(d1, d2);
		} catch(Exception ex) {}
	}
	
	/**
	 * Imprime los nombres de los pacientes
	 * @param d1
	 */
	static void nombresPacientes(Pacientes [] d1)
	{
		for(int i = 0; i < d1.length ; i++)
			System.out.println(d1[i].getNombre());
	}
	
	/**
	 * Menú para operar.
	 * @param d1
	 * @param d2
	 */
	static void menu(Pacientes [] d1, Pacientes [] d2)
	{
		try
		{
			int opc = 0;
			do
			{
				System.out.println("\n\n1. Mostrar los nombres de los pacientes hospitalizados.");
				System.out.println("2. Obtener porcentaje de personas hospitalizads.");
				System.out.println("3. Obtener porcentaje de mujeres y hombres hospitalizados.");
				System.out.println("4. Calcular el porcentaje de pacientes con seguro médico.");
				System.out.println("5. Salir.");
				System.out.println("Ingrese la opción a realizar: ");
				opc = Integer.parseInt(br.readLine());
				switch (opc)
				{
				case 1:
					nombresPacientes(d1);
					nombresPacientes(d2);
					break;
				case 2:
					op.porcentajeHospitalizados(d1, d2);
					break;
				case 3:
					op.porcentajeSexo(d1, d2);
					break;
				case 4:
					op.porcentajeSeguro(d1, d2);
					break;
				case 5:
					break;
				default:
						break;
				}
			} while(opc != 5);
			
		} catch(Exception ex) {}
	}
	
}
