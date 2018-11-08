import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Nicolás David Espejo Bernal
 *
 * 7/11/2018
 */
public class MainClass 
{
	
	static void imprimirPostres(String[] n)
	{
		for(int i = 0; i < n.length; i++)
		{
			if(n[i] == null)
				System.out.print("[Vacío]   ");
			else
				System.out.print("[" + n[i] + "]   ");
		}
	}
	
	/**
	 * Busca el valor ingresado en el vector de Strings, si lo encuentra retorna el índice, si no retorna -1;
	 * @param postres
	 * @param n
	 * @return
	 */
	static int buscarPostre(String[] postres, String n)
	{
		for(int i = 0; i < postres.length; i++)
			if(n.equalsIgnoreCase(postres[i]))
				return i;
		return -1;
	}
	
	/**
	 * Verifica que el número del índice ingrsado esté en el rango del tamaño de la lista.
	 */
	static int checkDelete(ListaEnlazada lista)
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in) );
		int n = 0;
		try 
		{
			n = Integer.parseInt(br.readLine());
			while(!(n > 0 && n < lista.size))
			{
				System.out.println("Ingrese nuevamente un índice válido:");
				n = Integer.parseInt(br.readLine());
			}
					
		} catch (Exception ex) {}
		return n;
	}
	
	/**
	 * Busca el primer espacio vacío del vector y retorna el índice
	 * @param array
	 * @return
	 */
	static int espacioVacio(String [] array)
	{
		for(int i = 0; i < array.length; i++)
			if(array[i] == null)
				return i;
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		// Listas para cada valor del vector 'postres'
		ListaEnlazada lista0 = new ListaEnlazada();
		ListaEnlazada lista1 = new ListaEnlazada();
		ListaEnlazada lista2 = new ListaEnlazada();
		ListaEnlazada lista3 = new ListaEnlazada();
		ListaEnlazada lista4 = new ListaEnlazada();
		ListaEnlazada lista5 = new ListaEnlazada();
		
		String postres[] = new String[6];
		postres[0]= "Arroz con leche";		
		
		lista0.addFirst(postres[0]);
		lista0.insertAtEnd("100g de arroz redondo");
		lista0.insertAtEnd("1 trozo de cáscara de limón y naranja");
		lista0.insertAtEnd("1 rama de canela");
		lista0.insertAtEnd("Canela en polvo");
		lista0.insertAtEnd("70g de azúcar");
		lista0.insertAtEnd("10g de mantequilla");
		
		int opc = 0;
		String n = "";
	
		while(opc != 6)
		{
			System.out.println("\nLista de postres:");
			imprimirPostres(postres);
			System.out.println("\n1. Mostrar ingredientes postre.");
			System.out.println("2. Instertar ingredientes postre.");
			System.out.println("3. Eliminar ingrediente postre.");
			System.out.println("4. Ingresar nuevo postre.");
			System.out.println("5. Eliminar postre.");
			System.out.println("6. Salir.");
			try
			{
				opc = Integer.parseInt(br.readLine());
			} catch(Exception ex) {}
			switch(opc)
			{
				case 1:
					System.out.println("Ingrese nombre postre:");
					try
					{
						n = br.readLine();
					} catch(Exception ex) {}
					switch(buscarPostre(postres, n))
					{
						case 0:
							lista0.printList();
						break;
						case 1:
							lista1.printList();
						break;
						case 2:
							lista2.printList();
						break;
						case 3:
							lista3.printList();
						break;
						case 4:
							lista4.printList();
						break;
						case 5:
							lista5.printList();
						break;
						default:
							System.out.println("Postre no encontrado.");
						break;
					}
				break;
				case 2:
					System.out.println("Ingrese nombre del postre para añadir:");
					try
					{
						n = br.readLine();
					
					switch(buscarPostre(postres, n))
					{
						case 0:
							System.out.println("Ingrese elemento a añadir:");
							lista0.insertAtEnd(br.readLine());
						break;
						case 1:
							System.out.println("Ingrese elemento a añadir:");
							lista1.insertAtEnd(br.readLine());
						break;
						case 2:
							System.out.println("Ingrese elemento a añadir:");
							lista2.insertAtEnd(br.readLine());
						break;
						case 3:
							System.out.println("Ingrese elemento a añadir:");
							lista3.insertAtEnd(br.readLine());
						break;
						case 4:
							System.out.println("Ingrese elemento a añadir:");
							lista4.insertAtEnd(br.readLine());
						break;
						case 5:
							System.out.println("Ingrese elemento a añadir:");
							lista5.insertAtEnd(br.readLine());
						break;
						default:
							System.out.println("Postre no encontrado.");
						break;
					} } catch(Exception ex) {}
				break;
				case 3:
					System.out.println("Ingrese nombre del postre para eliminar ingrediente:");
					try
					{
						n = br.readLine();
					
					switch(buscarPostre(postres, n))
					{
						case 0:
							System.out.println("Ingrese el número del elemento a eliminar:");
							lista0.deleteIndex(checkDelete(lista0));
						break;
						case 1:
							System.out.println("Ingrese el número del elemento a eliminar:");
							lista1.deleteIndex(checkDelete(lista1));
						break;
						case 2:
							System.out.println("Ingrese el número del elemento a eliminar:");
							lista2.deleteIndex(checkDelete(lista2));
						break;
						case 3:
							System.out.println("Ingrese el número del elemento a eliminar:");
							lista3.deleteIndex(checkDelete(lista3));
						break;
						case 4:
							System.out.println("Ingrese el número del elemento a eliminar:");
							lista4.deleteIndex(checkDelete(lista4));
						break;
						case 5:
							System.out.println("Ingrese el número del elemento a eliminar:");
							lista5.deleteIndex(checkDelete(lista5));
						break;
						default:
							System.out.println("Postre no encontrado.");
						break;
					} } catch(Exception ex) {}
				break;
				case 4:
					int index = espacioVacio(postres);
					if(index == -1)
					{
						System.out.println("Lista llena. Intente borrar elementos.");
						break;
					}
					else
					{
						System.out.println("Ingrese nombre del postre que desea ingresar: ");
						try
						{
							n = br.readLine();
							switch(index)
							{
								case 0:
									postres[index] = n;
									lista0.addFirst(n);
								break;
								case 1:
									postres[index] = n;
									lista1.addFirst(n);
								break;
								case 2:
									postres[index] = n;
									lista2.addFirst(n);
								break;
								case 3:
									postres[index] = n;
									lista3.addFirst(n);
								break;
								case 4:
									postres[index] = n;
									lista4.addFirst(n);
								break;
								case 5:
									postres[index] = n;
									lista5.addFirst(n);
								break;
							}
							
						} catch (Exception ex) {}
					}
				break;
				case 5:
					System.out.println("Ingrese nombre de postre que desea eliminar: ");
					try
					{
						n = br.readLine();
						int i = buscarPostre(postres, n); 
						switch(i)
						{
							case 0:
								postres[i] = null;
								lista0.clearList();
							break;
							case 1:
								postres[i] = null;
								lista1.clearList();
							break;
							case 2:
								postres[i] = null;
								lista2.clearList();
							break;
							case 3:
								postres[i] = null;
								lista3.clearList();
							break;
							case 4:
								postres[i] = null;
								lista4.clearList();
							break;
							case 5:
								postres[i] = null;
								lista5.clearList();
							break;
							default:
								System.out.println("Postre no encontrado");
							break;
						}
					} catch (Exception ex) {}
				break;
				default:
					System.out.println("Valor inválido. Intente de nuevo.");
				break;
			}
			n = "";
		}
	}

}
