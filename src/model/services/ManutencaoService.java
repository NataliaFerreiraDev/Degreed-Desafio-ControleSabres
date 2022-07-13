package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Manutencao;

public class ManutencaoService {
	
	public List<Manutencao> findAll(){
		List<Manutencao> manutencoes = new ArrayList<>();
		
		try {
			manutencoes.add(new Manutencao(1, 3, "17-03-2003", "C-3PO"));
			manutencoes.add(new Manutencao(2, 3, "17-04-2003", "C-3PO"));
			manutencoes.add(new Manutencao(3, 2, "17-09-2003", "C-3PO"));
			manutencoes.add(new Manutencao(4,5,  "17-12-2003", "C-3PO"));			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
		return manutencoes;
	}
	

}
