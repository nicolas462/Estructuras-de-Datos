/**
 * 
 */
import java.io.*;

/**
 * @author Nicolás David Espejo Bernal
 *
 * 29/08/2018
 */
public class Escritura {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	
			FileWriter file = new FileWriter("magico.txt");
			String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };
			for (String linea: lineas)
				file.write(linea + "\n");
			
			file.close();
		} catch (Exception ex) {}
	}

}
