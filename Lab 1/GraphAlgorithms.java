
// En caso de que no exista un arco entre los vertice i y j, el valor inicial 
// de la matriz de distancias debe ser Integer.MAX_VALUE 

public class GraphAlgorithms {

    public static int[][] Roy_Warshall(MatrizAdyacenciaDigrafo G){

	// Crear Matriz de distancias 
	int n = G.V();
	int[][] D = new int[n][n];
		
	
	for(int d = 0; d < n; d++){
		for (int d2 = 0; d2 < n; d2++){
			if (d2 == d){
				D[d][d2] = 0;			
			}
			else {
				D[d][d2] = G.valor(d, d2);				
			}
		}
	} 

	for(int k = 0; k < n; k++){
		for (int i = 0; i < n; i++){
			if ((i!=k) && (D[i][k]==1)){
				for (int j = 0; j < n; j++){
					D[i][j] = D[i][j] + D[k][j];
					if (D[i][j] > 1){
						D[i][j] = 1;					
					}		
				}
			}	
		}	
	}

	
	return D;
    }	
}
