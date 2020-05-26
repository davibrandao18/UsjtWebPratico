package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class VisualizarPais implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
			
		}
		
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setId(id);
		//instanciar o service
		PaisService ps = new PaisService();
		
		RequestDispatcher view = null;
		
		pais = ps.carregar(pais);
		request.setAttribute("pais", pais);
		
		view = request.getRequestDispatcher("VisualizarPais.jsp");
		view.forward(request, response);
	}
	
}
