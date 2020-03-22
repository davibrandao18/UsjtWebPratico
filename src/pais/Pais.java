package pais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	public Pais() {}
	
	public Pais(int id, String nome, long populacao, double area) {
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

	public long getPopulacao() {
		return populacao;
	}

	public double getArea() {
		return area;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	public String paisComMaisHabitantes() {
		return "pais";
	}
	
	public String paisComMenorArea() {
		return "pais";
	}
	
	//Conexao banco de dados
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtendo conexao com o banco de dados
	public Connection obtemConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/vendas?useTimezone=true&serverTimezone=America/Sao_Paulo&user=root&password=''");
	}
	
	//Atualizar
	public void atualizar() {
		String sqlUpdate = "UPDATE cliente SET nome=?, fone=?, email=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conexao = obtemConexao();
				PreparedStatement stm = conexao.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.setInt(4, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void inserirPais() {
		String sqlInsert = "INSERT INTO pais (id,nome,populacao,area) VALUES (0, ?, ?, ?)";
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
