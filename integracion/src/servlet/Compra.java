package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Controlador;
import exceptions.UsuarioException;
import negocio.Usuario;

@WebServlet("/Compra")
public class Compra extends HttpServlet{

	
	private static final long serialVersionUID = 8552979138951014098L;
	
	public Compra() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String action = request.getParameter("action");
		String jspPage = "/index.jsp";
		if ((action == null) || (action.length() < 1)) {
			action = "default";
			request.setAttribute("excepcion", "");
			dispatch(jspPage, request, response);
		}
		if ("default".equalsIgnoreCase(action)) {
			jspPage = "/index.jsp";
		} else if ("login".equalsIgnoreCase(action)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Usuario usuario = Controlador.getInstancia().existeUsuario(username,password);
				if (usuario != null ) {
					if (usuario.getTipo_usuario().equalsIgnoreCase("comprador")) {
						action = "default";
						request.setAttribute("excepcion", "");
						dispatch("vistaComprador.jsp", request, response);
					}else {
						action = "default";
						request.setAttribute("excepcion", "");
						dispatch("vistaVendedor.jsp", request, response);
					}
				}
			} catch (UsuarioException e) {				
				action = "default";
				request.setAttribute("excepcion", "");
				dispatch(jspPage, request, response);		
			}			
		}*/		
	}

	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (jsp != null) {
			/*
			 * Env�a el control al JSP que pasamos como par�metro, y con los
			 * request / response cargados con los par�metros
			 */
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	

}
