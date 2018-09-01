import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author BOG-A408-E-018
 *
 */
public class Operaciones {

	static BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	
	/**
	 * Obtiene e imprime el porcentaje de ni�os, j�venes y adultos de los registrados.
	 * @param d1 = Registro
	 * @param d2 = Registro
	 */
	public void porcentajeHospitalizados(Pacientes [] d1, Pacientes [] d2)
	{
		int ninos = 0, jovenes = 0, adultos = 0;
		for(int i = 0; i < d1.length; i++)
		{
			if(d1[i].getEdad() <= 13)
				ninos ++;
			if(d1[i].getEdad() > 13 && d1[i].getEdad() < 30)
				jovenes ++;
			if(d1[i].getEdad() >= 30)
				adultos ++;
		}
		
		for(int i = 0; i < d2.length; i++)
		{
			if(d2[i].getEdad() <= 13)
				ninos ++;
			if(d2[i].getEdad() > 13 && d2[i].getEdad() < 30)
				jovenes ++;
			if(d2[i].getEdad() >= 30)
				adultos ++;
		}
		double ninos_hospitalizados = (ninos * 100) / (d1.length + d2.length);
		double jovenes_hospitalizados = (jovenes * 100) / (d1.length + d2.length);
		double adultos_hospitalizados = (adultos * 100) / (d1.length + d2.length);
		System.out.println("El porcentaje de ni�os hospitalizados (hasta 13 a�os) es: " + ninos_hospitalizados + "% con " + ninos + " ni�os.");
		System.out.println("El porcentaje de j�venes hospitalizados (mayores de 13 a�os hasta 30) es : " + jovenes_hospitalizados + "% con " + jovenes + " ni�os.");
		System.out.println("El porcentaje de adultos hospitalizados (de 30 a�os en adelante) es: " + adultos_hospitalizados + "% con " + adultos + " ni�os.");
	}
	
	/**
	 * Obtiene e imprime el porcentaje de mujeres y hombres registrados.
	 * @param d1
	 * @param d2
	 */
	public void porcentajeSexo(Pacientes [] d1, Pacientes [] d2)
	{
		int mujeres = 0, hombres = 0;
		for(int i = 0; i < d1.length; i++)
		{
			if(d1[i].getSexo() == 'F')
				mujeres ++;
			if(d1[i].getSexo() == 'M')
				hombres ++;		
		}
		for(int i = 0; i < d2.length; i++)
		{
			if(d2[i].getSexo() == 'F')
				mujeres ++;
			if(d2[i].getSexo() == 'M')
				hombres ++;		
		}
		int porcentaje_mujeres = (mujeres * 100) / (d1.length + d2.length);
		int porcentaje_hombres = (hombres * 100) / (d1.length + d2.length);
		System.out.println("El porcentaje de mujeres es : " + porcentaje_mujeres + "% con " + mujeres +" mujeres.");
		System.out.println("El porcentaje de hombres es : " + porcentaje_hombres + "% con " + hombres +" hombres.");
	}
	
	/**
	 * Calculua e imprime el porcenje de pacientes con seguro m�dico.
	 * @param d1
	 * @param d2
	 */
	public void porcentajeSeguro(Pacientes [] d1, Pacientes [] d2)
	{
		int seguro = 0;
		for(int i = 0; i < d1.length; i++)
			if(d1[i].isSeguro())
				seguro ++;	
		for(int i = 0; i < d2.length; i++)
			if(d2[i].isSeguro())
				seguro ++;		
		int porcentaje_seguro = (seguro * 100) / (d1.length + d2.length);
		System.out.println("El porcentaje de pacientes con seguro es : " + porcentaje_seguro + "% con " + seguro +" pacientes.");
	}
	
	/**
	 * Divide cada l�nea del vector para ingresarlos en cada posici�n de la matriz.
	 * @param arrayString = vecotr con l�neas para dividir por tabulaciones ("\t").
	 * @param matriz = Matriz a llenar.
	 */
	public void llenarMatriz(String [] arrayString, String[][] matriz)
	{
		for(int i = 0; i < matriz.length; i++)
		{
			String [] vector = arrayString[i].split("\t");
			for(int j = 0; j < matriz[0].length; j++)
			{
				// Para no tener problemas con el doble salto despu�s del telefono.
				if(j == 5)
				{
					matriz[i][j] = vector[6];
					break;
				}
				matriz[i][j] = vector[j];
			}
		}
	}
	
	/**
	 * Con base en la matriz de String, se obtienen los par�metros del registro.
	 * @param vector = Registro.
	 * @param matriz = matriz con los par�metros en String.
	 */
	public void llenarRegistro (Pacientes [] vector, String [][] matriz)
	{
		boolean seguro = false;
		for(int i = 0; i < vector.length; i++)
		{
			if (matriz[i][5].equals("SI"))
				seguro = true;
			else
				seguro = false;
			//(String nombre, int edad, char sexo, String direccion, String telefono, boolean seguro) 
			vector[i] = new Pacientes(matriz[i][0], Integer.parseInt(matriz[i][1]), matriz[i][2].toUpperCase().charAt(0), matriz[i][3],
					matriz[i][4], seguro);
		} 
	}
	
	/**
	 * Pide los datos para llenar el registro.
	 * @param vector
	 * @throws IOException
	 */
	public void llenarDatos(Pacientes [] vector) throws IOException
	{
		//(String nombre, String sexo, String direccion, String telefono, int edad, boolean seguro)
		for(int i = 0; i < vector.length; i++)
		{
			String sexo;
			int seg;
			boolean seguro = false;
			
			System.out.println("Ingrese datos paciente " + (i+1) + ". \nIngrese nombre:");
			String nombre = br.readLine();
			do 
			{
				System.out.println("Ingrese sexo:");
				sexo = br.readLine().toUpperCase();
			} while(!checkSexo(sexo));
			
			System.out.println("Ingrese direcci�n:");
			String direccion = br.readLine();
			
			System.out.println("Ingrese tel�fono:");
			String telefono = br.readLine();
			
			System.out.println("Ingrese edad:");
			int edad = Integer.parseInt(br.readLine());
			
			do 
			{
				System.out.println("Ingrese 1 si tiene seguro, 0 si no tiene:");
				seg = Integer.parseInt(br.readLine());
			} while(!checkSeguro(seg));
			
			if(seg == 1)
				seguro = true;
			vector[i] = new Pacientes(nombre, edad, sexo.charAt(0), direccion,  telefono, seguro);
		}	
	}
	
	
	/**
	 * Verifica que la entrada sea 0 � 1.
	 * @param num
	 * @return
	 */
	private static boolean checkSeguro(int num)
	{
		if(num == 1 || num == 0)
			return true;
		System.out.println("Entreada no v�lida, ingrese de nuevo.");
		return false;
	}
	
	/**
	 * Si la string ingresada tiene una 'm' � 'f', es v�lida la entrada.
	 * @param sexo
	 * @return
	 */
	private static boolean checkSexo(String sexo)
	{
		if(sexo.substring(0, 1).equals("F") || sexo.substring(0, 1).equals("M"))
			return true;
		System.out.println("Entrada no v�lida, ingrese de nuevo.");
		return false;
	}
}
