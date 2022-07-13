package model.entities;

public class Manutencao {
	
	private Integer idManutencao;
	private Integer idSabre;
	private String dataManutencao;
	private String responsavel;
	
	public Manutencao() {
	}

	public Manutencao(Integer idManutencao, Integer idSabre, String dataManutencao, String responsavel) {
		this.idManutencao = idManutencao;
		this.idSabre = idSabre;
		this.dataManutencao = dataManutencao;
		this.responsavel = responsavel;
	}

	public Integer getIdManutencao() {
		return idManutencao;
	}
	
	public void setIdManutencao(Integer idManutencao) {
		this.idManutencao = idManutencao;
	}
	
	public String getDataManutencao() {
		return dataManutencao;
	}
	
	public void setDataManutencao(String dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Integer getIdSabre() {
		return idSabre;
	}

	public void setIdSabre(Integer idSabre) {
		this.idSabre = idSabre;
	}

}
