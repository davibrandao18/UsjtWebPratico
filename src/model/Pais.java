package model;


public class Pais {
	private int id;
	private String nome;
	private Long populacao;
	private Double area;
	
	public Pais() {}
	
	public Pais(int id)  {
		this.id = id;
	}
	
	public Pais(int id, String nome, Long populacao, Double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public Double getArea() {
		return area;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

	public void setArea(Double area) {
		this.area = area;
	}
	
	public String paisComMaisHabitantes() {
		return "pais";
	}
	
	public String paisComMenorArea() {
		return "pais";
	}


	@Override
	public String toString() {
		return 	"Nome: " + getNome() +
				"   Populacao: " + getPopulacao() +
				"   Area: " + getArea();
		
	}
	

}
