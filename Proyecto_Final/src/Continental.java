public class Continental
{
	public int [][] tablero = new int [7][7];
	int candidateI, candidateJ; // Coordenadas para el espacio en blanco a operar.
	int fichas;
	
	Continental()
	{
		defaultParameters(this.tablero);
		candidateI = 3;
		candidateJ = 3;
		fichas =  32;
	}
	
	private void defaultParameters(int tablero[][])
	{
		tablero[3][3] = -1;
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
	
	public void printBoard(int tablero[][])
	{
		for (int i = 0; i < tablero.length; i++)
		{
			for (int j = 0; j < tablero[i].length; j++)
			{
				if(tablero[i][j] == -1)
					System.out.print("     " );
				else
					System.out.print("  o  " );
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
	
	public void operar(Arbol arbol, Continental etapa, int candidateI, int candidateJ, int fichas)
	{
		/*si se pasa de número de fichas
		 * 	return false;*/
		arbol.insert(new NodoBinario (etapa.tablero));
		etapa.fichas = fichas;
		etapa.printBoard(etapa.tablero);
		boolean exito = false;
		do
		{
			if (etapa.valido(etapa.tablero, candidateI, candidateJ))
			{
				if (etapa.fichas == 1) // Ya se llegó a la solución
				{
					etapa.printBoard(etapa.tablero);
					System.out.println("SOLUCIÓN");
					exito = true;
					return;
				}
				else
				{
					int i = candidateI;
					int j = candidateJ;
					etapa.tablero[i][j] = 1;
					while(true)
					{
						if(etapa.position(tablero, candidateI, candidateJ) == 0)
						{
							j --;
							etapa.tablero[i][j - 1] = -1;
							break;
						}
						if(etapa.position(tablero, candidateI, candidateJ) == 2)
						{
							j ++;
							etapa.tablero[i][j + 1] = -1;
							break;
						}
						if(etapa.position(tablero, candidateI, candidateJ) == 1)
						{
							i --;
							etapa.tablero[i - 1][j] = -1;
							break;
						}
						if(etapa.position(tablero, candidateI, candidateJ) == 3)
						{
							i ++;
							etapa.tablero[i + 1][j] = -1;
							break;
						}
					}
					etapa.tablero[i][j] = -1;
					operar(arbol, etapa, i, j, fichas - 1);
				}
				//Borrar etapa
			}
		} while(etapa.fichas == 1 && !exito); //Solución etapa ya sea la última o ya haya éxito
		return;
	}
	
	
	
	public boolean valido(int tablero[][], int i, int j)
	{
		return this.position(tablero, i, j) > -1 ? true : false;	
	}
	
	public int position(int tablero[][], int i, int j)
	{
		if(tablero[i][j - 1] != -1) //left
			if(tablero[i][j - 2] != -1)
				return 0;
		if(tablero[i - 1][j] != -1) //right
			if(tablero[i - 2][j] != -1)
				return 1;
		if(tablero[i][j + 1] != -1) //up
			if(tablero[i][j + 2] != -1)
				return 2;
		if(tablero[i + 1][j] != -1) //down
			if(tablero[i + 2][j] != -1)
				return 3;
		return -1;
	}
	
	
	public static void main(String[] args) 
	{
		Continental continental = new Continental();
		Arbol arbol = new Arbol();
		arbol.insert(new NodoBinario (continental.tablero));
		//continental.tablero[3][3] = -1;
		continental.operar(arbol, continental, continental.candidateI, continental.candidateJ, continental.fichas);
		
	}
}