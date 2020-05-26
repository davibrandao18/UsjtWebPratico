package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

public class EditarPais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int pId = Integer.parseInt(request.getParameter("id"));
		
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setId(pId);
		//instanciar o service
		PaisService ps = new PaisService();
		
		RequestDispatcher view = null;
		
		pais = ps.carregar(pais);
		request.setAttribute("pais", pais);
		
		view = request.getRequestDispatcher("AlterarPais.jsp");
		view.forward(request, response);
		
	}

}
