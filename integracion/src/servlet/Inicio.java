package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import java.sql.SQLException;


import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import controlador.*;
import exceptions.UsuarioException;
import negocio.Producto;
import negocio.Usuario;
import java.util.Random;



@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Inicio() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Usuario usuario = Controlador.getInstancia().existeUsuario(username,password);
				if (usuario != null ) {
					Controlador.getInstancia().setearUsuario(username, password);
					if (usuario.getTipo_usuario().equalsIgnoreCase("comprador")) {
						action = "default";
						request.setAttribute("usuario", usuario);
						System.out.print(request.getAttribute(usuario.getUsername()));
						dispatch("vistaComprador.jsp", request, response);
					}else {
						action = "default";
						request.setAttribute("usuario_id", usuario.getUsuario_id());
						dispatch("vistaVendedor.jsp", request, response);
					}
				}
			} catch (UsuarioException e) {				
				action = "default";
				request.setAttribute("excepcion", "");
				dispatch(jspPage, request, response);		
			}			
		}
		else if ("altaCliente".equalsIgnoreCase(action)) {
			String mail         = request.getParameter("mail");
			String username     = request.getParameter("username");
			String telefono     = request.getParameter("telefono");
			String password     = request.getParameter("password");
			String usuario_id   = request.getParameter("dni");
			String direccion    = request.getParameter("direccion");
			String tipo_usuario = request.getParameter("tipo_usuario");			
			Controlador.getInstancia().nuevoUsuario(usuario_id, username, password, telefono, mail, direccion, tipo_usuario, true);
			if (tipo_usuario.equalsIgnoreCase("comprador")) {
				dispatch("vistaComprador.jsp", request, response);
			}else {
				dispatch("vistaVendedor.jsp", request, response);
			}
		}
		
		else if ("nuevaFactura".equalsIgnoreCase(action)) {
			Random rand = new Random();
			int  n = rand.nextInt(999999999) + 111111111;
			String usuario = Controlador.getInstancia().getUsername();
			String password = Controlador.getInstancia().getPassword();
			String codBarra = request.getParameter("codBarra");
			Controlador.getInstancia().nuevaFactura(String.valueOf(n), usuario, password, codBarra);
			dispatch("vistaComprador.jsp", request, response);
		}
		
		else if ("subirProducto".equalsIgnoreCase(action)) {
			Random rand = new Random();
			int  n = rand.nextInt(999999999) + 111111111;
			String usuario = Controlador.getInstancia().getUsername();
			String password = Controlador.getInstancia().getPassword();
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			Controlador.getInstancia().nuevoProducto(String.valueOf(n), nombre, Float.valueOf(precio), usuario, password);
			dispatch("vistaVendedor.jsp", request, response);
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
