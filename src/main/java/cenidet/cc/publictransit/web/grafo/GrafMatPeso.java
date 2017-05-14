package cenidet.cc.publictransit.web.grafo;

public class GrafMatPeso {
	
	public static int INFINITO = 0xFFFF;
	private int [][] matPeso;
	private Vertice[] verts;
	private int numVerts;
	
	public GrafMatPeso(int mx){
		matPeso = new int[mx][mx];
		verts = new Vertice[mx];
		for (int i = 0; i < mx; i++) {
			for (int j = 0; j < mx; j++) {
				matPeso[i][j] = INFINITO;
			}
		}
		numVerts = 0;			
	}
	
	public void nuevoVertice(Vertice vertice){
		if((vertice != null) && ( ! existe(vertice))){
			vertice.asigVert(numVerts);
			verts[numVerts++] = vertice;
		}
	}
	
	public boolean existe(Vertice vertice){		
		if(vertice != null){			
			for (int i = 0; i < numVerts; i++) {
				if(verts[i].equals(vertice)){
					return true;
				}
			}
		}		
		return false;
	} 
	
	public int buscar(Vertice vertice){		
		if(vertice != null){			
			for (int i = 0; i < numVerts; i++) {
				if(verts[i].equals(vertice)){
					return i;
				}
			}
		}		
		return -1;
	} 
	
	
	public void nuevoArco(Vertice origen, Vertice destino, int peso){		
		int vOrigen = buscar(origen);
		int vDestino = buscar(destino);		
		if((vOrigen >= 0) && (vDestino >= 0)){
			matPeso[vOrigen][vDestino] = peso;
		}		
	}	
	
	public int getPesoArco(Vertice origen,Vertice destino){
		int posicionOrigen = buscar(origen);
		int posicionDestino = buscar(destino);
		
		if((posicionOrigen >= 0) && (posicionDestino >= 0)){
			return matPeso[posicionOrigen][posicionDestino];		
		}		
		return -1;
	}
	
	// Retorna el número de vertices
	public int numeroDeVertices(){
		return numVerts;
	}
	
	// Retorna el array de vertices
	public Vertice[] vertices(){
		return verts;
	}	
	
	public int[][] getMatPeso(){
		return matPeso;
	}

}
