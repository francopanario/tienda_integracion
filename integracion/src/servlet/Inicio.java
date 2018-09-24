package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import controlador.*;
/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inicio() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		System.out.println("SAFDGHFNGHFNgdmh");
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String jspPage = "/index.jsp";
		
		if ((action == null) || (action.length() < 1)) {
			action = "default";
			request.setAttribute("excepcion", "");
			dispatch(jspPage, request, response);
		}
		if ("default".equalsIgnoreCase(action)) {
			jspPage = "/index.jsp";
		} else if ("login".equalsIgnoreCase(action)) {

			String usuario = request.getParameter("usuario");
			String contrasena = request.getParameter("password");
			Controlador.getInstancia().nuevoUsuario("asdasdasd", "asdasdasdsa", "asdas", "asdsa", "asdasd", "asdsa", "asdsa",true );
			//HACER EL LOGIN
			
			//HACER EL DISPATCH PARA VISTA COMPRADOR O VISTA VENDEDOR
			dispatch("vistaVendedor.jsp", request, response);
		}
		else if ("altaCliente".equalsIgnoreCase(action)) {
			String email = request.getParameter("email");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String password = request.getParameter("password");
			
			//HACER EL ALTA CLIENTE
		}
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
