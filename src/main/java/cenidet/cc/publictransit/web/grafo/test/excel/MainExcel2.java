package cenidet.cc.publictransit.web.grafo.test.excel;

import java.util.ArrayList;

import cenidet.cc.publictransit.dao.StopDAO;
import cenidet.cc.publictransit.dto.Stop;
import cenidet.cc.publictransit.grafo.refactor.Grafo;

public class MainExcel2 {

	public static void main(String[] args) throws Exception{
		
		StopDAO stopDAO = StopDAO.getInstance();		
		ArrayList<Stop> verticesGrafo = stopDAO.getVerticesGrafo();
		
		Grafo grafo = new Grafo(verticesGrafo);		
		grafo.imprimirMatriz();
					
	}
	

	

	
}
