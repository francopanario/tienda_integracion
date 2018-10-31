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

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import controlador.*;
import exceptions.FacturaException;
import exceptions.UsuarioException;
import negocio.Usuario;
import java.util.Random;
import mail.GoogleMail;



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
				//System.out.println(usuario.getTipo_usuario());
				if (usuario != null && usuario.isActivo()) {
					Controlador.getInstancia().setearUsuario(username, password);
					if (usuario.getTipo_usuario().equalsIgnoreCase("comprador")) {
						action = "default";
						request.setAttribute("usuario", usuario);
						dispatch("vistaComprador.jsp", request, response);
					}
					if (usuario.getTipo_usuario().equalsIgnoreCase("vendedor")) {
						action = "default";
						request.setAttribute("usuario_id", usuario.getUsuario_id());
						dispatch("vistaVendedor.jsp", request, response);
					}
					if(usuario.getTipo_usuario().equalsIgnoreCase("administrador")) {
						action = "default";
						request.setAttribute("usuario", usuario);
						dispatch("admin.jsp", request, response);
					}
				}else {
					action = "default";					
					dispatch("index.jsp", request, response);
				}
			} catch (UsuarioException e) {				
				action = "default";
				request.setAttribute("error", "Usuario o contraseña invalida");
				dispatch("/index.jsp", request, response);		
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
			Controlador.getInstancia().setearUsuario(username, password);
			try {
				GoogleMail.Send("tienda.integracion", "tienda123", mail, "Bienvenido a la Tienda!", "Hola "+username+"! , bievenido a la tienda. Felices compras!." );
			} catch (MessagingException | javax.mail.MessagingException e1) {
				e1.printStackTrace();
			}
			
			
			if (tipo_usuario.equalsIgnoreCase("comprador")) {
				dispatch("vistaComprador.jsp", request, response);
			}else {
				dispatch("vistaVendedor.jsp", request, response);
			}
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
