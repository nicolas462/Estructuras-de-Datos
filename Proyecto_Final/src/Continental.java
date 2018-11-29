public class Continental
{
	public int [][] tablero = new int [7][7];
	int m = 31; // número máximo de movimientos
	int n = 7; // tamaño del tablero
	int solucion[] = new int [m];
	
	Continental()
	{
		defaultParameters(this.tablero);
	}
	
	/**
	 * Se establecen los valores predeterminados de la tabla.
	 * Donde:
	 * -1 Equivale a una casilla no válida.
	 * 0 Equivale a una casilla desocupada.
	 * 1 Equivale a una casilla ocupada.
	 * @param tablero
	 */
	private void defaultParameters(int tablero[][])
	{
		for (int i = 0; i < tablero.length; i++)
			for(int j = 0; j < tablero[0].length; j++)
				tablero[i][j] = 1;
		tablero[3][3] = 0;
		tablero[0][0] = -1;
		tablero[0][1] = -1;
		tablero[0][5] = -1;
		tablero[0][6] = -1;
		tablero[1][0] = -1;
		tablero[1][1] = -1;
		tablero[1][5] = -1;
		tablero[1][6] = -1;
		tablero[5][0] = -1;
		tablero[5][1] = -1;
		tablero[5][5] = -1;
		tablero[5][6] = -1;
		tablero[6][0] = -1;
		tablero[6][1] = -1;
		tablero[6][5] = -1;
		tablero[6][6] = -1;
	}
	
	/**
	 * Función para imprimir en pantalla el tablero
	 * @param tablero
	 */
	public static void printBoard(int tablero[][])
	{
		for (int i = 0; i < tablero.length; i++)
		{
			for (int j = 0; j < tablero[i].length; j++)
			{
				if(tablero[i][j] < 1)
					System.out.print("     " );
				else
					System.out.print("  o  " );
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
	
	public void operacion(int k, int t[][], boolean encontrado, String sol[])
	{
		printBoard(t);
		//System.out.println(k);
		//do
		//{
			if (fin(k, t))
			{
				encontrado = true;
				return;
			}
			else
			{
				for (int i = 0; i < 7; i++)
					for (int j = 0; j < 7; j++)
					{
						
						if (valido(i, j, 0, t, encontrado)) // A la izquierda
						{
							k ++;
							//System.out.println("Izquierda " + k);
							//origen x, origen y, destino x, destino y, comido x, comido y
							sol[k] = i + "-" + j + "-" + i + "-" + (j - 2) + "-" + i + "-" + (j - 1);
							t = nuevaTabla(t, sol[k]); // Actualizar tablero
							operacion(k, t, encontrado, sol);
						}
						if (valido(i, j, 1, t, encontrado)) // Hacia arriba
						{
							k ++;
							//System.out.println("Arriba " + k);
							//origen x, origen y, destino x, destino y, comido x, comido y
							sol[k] = i + "-" + j + "-" + (i - 2) + "-" + j + "-" + (i - 1) + "-" + j;
							t = nuevaTabla(t, sol[k]); // Actualizar tablero
							operacion(k, t, encontrado, sol);
						}
						if (valido(i, j, 2, t, encontrado)) // A la derecha
						{
							k ++;
							//System.out.println("Derecha " + k);
							//origen x, origen y, destino x, destino y, comido x, comido y
							sol[k] = i + "-" + j + "-" + i + "-" + (j + 2) + "-" + i + "-" + (j + 1);
							t = nuevaTabla(t, sol[k]); // Actualizar tablero
							operacion(k, t, encontrado, sol);
						}
						if (valido(i, j, 3, t, encontrado)) // Hacia abajo
						{
							k ++;
							//System.out.println("Abajo " + k);
							//origen x, origen y, destino x, destino y, comido x, comido y
							sol[k] = i + "-" + j + "-" + (i + 2) + "-" + j + "-" + (i + 1) + "-" + j;
							t = nuevaTabla(t, sol[k]); // Actualizar tablero
							operacion(k, t, encontrado, sol);
						}
					}
				if (!encontrado) // Cancelar anotación
				{
					t = restaurarTabla(t, sol[k]);
					k--;
					System.out.println("Tabla restaurada");
					printBoard(t);
					//k --;
				}
			}
		//} while(!encontrado);
		
	}
	
	public static int [][] restaurarTabla (int t[][], String sol)
	{
		String temp [] = sol.split("-"); //coordenadas
		//Restablecer origen
		t[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;
		//Restablecer destino
		t[Integer.parseInt(temp[2])][Integer.parseInt(temp[3])] = 0;
		//Restablecer ficha comida
		t[Integer.parseInt(temp[4])][Integer.parseInt(temp[5])] = 1;
		return t;
	}
	
	public static int [][] nuevaTabla (int t[][], String sol)
	{
		String temp [] = sol.split("-"); //coordenadas
		//Quitar origen
		t[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 0;
		//Ocupar destino
		t[Integer.parseInt(temp[2])][Integer.parseInt(temp[3])] = 1;
		//Quitar ficha comida
		t[Integer.parseInt(temp[4])][Integer.parseInt(temp[5])] = 0;
		return t;
	}
	
	public static boolean valido(int i, int j, int mov, int t[][], boolean e)
	{
		if (mov == 0) //izquierda
			if((j - 1 > 0) && (t[i][j] == 1) && (t[i][j - 1] == 1)
					 && (j - 2 > 0) && (t[i][j - 2] == 0) && (!e)) 
				return true;
		if (mov == 1) // arriba
			if ((i - 1 > 0) && (t[i - 1][j] == 1) && (t[i][j] == 1)
					 && (i - 2 > 0) && (t[i - 2][j] == 0) && (!e)) return true;
		if (mov == 2) // derecha
			if ((j + 1 < 7) && (t[i][j + 1] == 1) && (t[i][j] == 1)
					 && (j + 2 < 7) && (t[i][j + 2] == 0) && (!e)) return true;
		if (mov == 3) // abajo
			if ((i + 1 < 7) && (t[i + 1][j] == 1) && (t[i][j] == 1)
					 && (i + 2 < 7) && (t[i + 2][j] == 0) && (!e)) return true;
		return false;
	}
	
	/**
	 * Retorna true si el número de movimientos llega a 31 y la ficha sobrante está en el medio
	 * @param k
	 * @param t
	 * @return
	 */
	public static boolean fin(int k, int t[][])
	{
		return (k == 31 && t[3][3] == 1) ? true : false;
	}
	
	public static void main(String[] args) 
	{
		Continental continental = new Continental();
		String solucion [] = new String [31]; 
		continental.operacion(0, continental.tablero, false, solucion);
		//Arbol arbol = new Arbol();
		//arbol.insert(new NodoBinario (continental.tablero));
		//continental.tablero[3][3] = -1;
		//continental.operar(arbol, continental, continental.candidateI, continental.candidateJ, continental.fichas);
		
	}
}