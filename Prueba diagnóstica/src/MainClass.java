import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 10/08/2018
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Manejo_arrays parte1 = new Manejo_arrays();
		//parte1.punto1();
		//parte1.punto2();
		//parte1.punto3(7);
		
		int valor = 1, opc = 1;
		do  {
			System.out.println("Ingrese valor.");
			valor = sc.nextInt();
			switch (valor)
			{
				case 1:
					parte1.punto1();
					System.out.println("\nDigite 1 para volver al menú, 0 para salir.");
					opc = sc.nextInt();
					if (opc == 0)
						valor = 0;	
					break;
				case 2:
					parte1.punto2();
					break;
				case 3:
					parte1.punto3(7);
					break;
				default: 
					System.out.println("Valor inválido. Digite 1 para volver al menú ó 0 para salir.");
					valor = sc.nextInt();
					break;
			}
		} while (valor >= 1 && valor <= 3);
			
		//Recursiones parte2 = new Recursiones();
		//parte2.punto1();
		//parte2.punto2(10, 40);
	}

}
