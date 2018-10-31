package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
//import org.json.simple.JSONObject;
import org.json.JSONObject;

import controlador.*;
import exceptions.FacturaException;
import exceptions.UsuarioException;
import negocio.Usuario;
import java.util.Random;



@WebServlet("/Administrador")
public class Administrador extends HttpServlet {
	
	private static final long serialVersionUID = 6683370968438603167L;

	public Administrador() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String jspPage = "/index.jsp";
		
		if ("admUsuarios".equalsIgnoreCase(action)) {
			String dni = request.getParameter("usuarioId");
			request.setAttribute("dni", dni);
			request.getRequestDispatcher("./editarUsuarios.jsp").forward(request, response);						
		}
		
		else if ("modificarUsuario".equalsIgnoreCase(action)) {
			String dni = request.getParameter("usuarioId");
			String username =  request.getParameter("username");
			String mail =  request.getParameter("mail");
			String password =  request.getParameter("password");
			String telefono =  request.getParameter("telefono");
			String direccion =  request.getParameter("direccion");
			String tipo =  request.getParameter("tipo");
			String estado = request.getParameter("estado");
			Controlador.getInstancia().modificarUsuario(dni, username, mail, direccion, telefono, tipo, estado);
			request.setAttribute("dni", dni);
			request.getRequestDispatcher("./admin.jsp").forward(request, response);			
		}	
		
	}
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (jsp != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	
}
