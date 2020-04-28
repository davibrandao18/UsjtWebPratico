package service;

import model.Pais;
import dao.PaisDAO;


public class PaisService {
	PaisDAO dao = new PaisDAO();
	
	public int criar(Pais pais) {
		System.out.println("deu certo a criação");
		return dao.criar(pais);
	}
	
	public void atualizar(Pais pais){
		dao.atualizar(pais);
	}
	
	public void excluir(Pais pais){
		dao.deletar(pais);
	}
	
	public Pais carregar(Pais pais){
		return dao.carregar(pais);
	}

}
