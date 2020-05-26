package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pAcao = request.getParameter("acao");
		int pId = Integer.parseInt(request.getParameter("id"));
		String pNome = request.getParameter("nome");
		
		//instanciar o javabean
		Pais pais = new Pais();
		pais.setId(pId);
		pais.setNome(pNome);
		
		//instanciar o service
		PaisService ps = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		System.out.println("Servlet: ação="+pAcao);
		switch(pAcao) {
			case"Criar": {
				pais.setPopulacao(Long.parseLong(request.getParameter("populacao")));
				pais.setArea(Double.parseDouble(request.getParameter("area")));
				
				System.out.println("servlet: "+pais.toString());
				
				ps.criar(pais);
				ArrayList<Pais> lista = new ArrayList<>();
				lista.add(pais);
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarPaises.jsp");
				break;
			}
			case"Excluir": {
				ps.excluir(pais);
				ArrayList<Pais> lista = (ArrayList<Pais>)session.getAttribute("lista");
				lista.remove(busca(pais, lista));
				session.setAttribute("lista", lista);
				view = request.getRequestDispatcher("ListarPaises.jsp");
				break;
			}
			case"Alterar": {
				pais.setPopulacao(Long.parseLong(request.getParameter("populacao")));
				pais.setArea(Double.parseDouble(request.getParameter("area")));
				
				ps.atualizar(pais);
				ArrayList<Pais> lista = (ArrayList<Pais>)session.getAttribute("lista");
				int pos = busca(pais, lista);
				lista.remove(pos);
				lista.add(pos, pais);
				session.setAttribute("lista", lista);
				request.setAttribute("pais", pais);
				view = request.getRequestDispatcher("VisualizarPais.jsp");
				break;
			}
			case"Visualizar": {
				pais = ps.carregar(pais);
				request.setAttribute("pais", pais);
				view = request.getRequestDispatcher("VisualizarPais.jsp");
				break;
			}
			case"Editar": {
				pais = ps.carregar(pais);
				request.setAttribute("pais", pais);
				view = request.getRequestDispatcher("AlterarPais.jsp");
			}
		}
		
		view.forward(request, response);
		
	}
	
	public int busca(Pais pais, ArrayList<Pais> lista) {
		Pais to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == pais.getId()){
				return i;
			}
		}
		return -1;
	}

}
