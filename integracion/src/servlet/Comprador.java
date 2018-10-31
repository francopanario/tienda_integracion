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



@WebServlet("/Comprador")
public class Comprador extends HttpServlet {
	
	private static final long serialVersionUID = -2974964705278096050L;

	public Comprador() {
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
		
		if ("comprar".equalsIgnoreCase(action)) {
			String codBarra = request.getParameter("codBarra");	
			request.setAttribute("codBarra", codBarra);
			request.getRequestDispatcher("./carrito.jsp").forward(request, response);
		}
		
		//**********************************************************************************FACTURA
		//**********************************************************************************
		//**********************************************************************************
		else if ("nuevaFactura".equalsIgnoreCase(action)) {
			Random rand = new Random();
			int  n = rand.nextInt(999999999) + 111111111;
			String username = Controlador.getInstancia().getUsername();
			String password = Controlador.getInstancia().getPassword();
			String codBarra = request.getParameter("codBarra");
			String cantidad = request.getParameter("cantidad");
			String medio = request.getParameter("medio");
			String numeroTienda = "2";
			JSONObject obj = new JSONObject();
			try {
				obj.put("username", username);
			} catch (JSONException e1) {				
				e1.printStackTrace();
			}
			try {
				obj.put("codBarra", codBarra);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			try {
				obj.put("codBarra", cantidad);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}			
			try {
				obj.put("numeroTienda", numeroTienda);
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			try {
				System.out.print(obj.getString("username"));
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			//obj.
			
			//System.out.print("JSON ");
			//obj.getString(username);
			//System.out.print(obj.toString(username, obj));
			Controlador.getInstancia().consultarStock(obj);
			Controlador.getInstancia().nuevaFactura(String.valueOf(n), username, password, codBarra, cantidad, medio);
			Usuario usuario = null;
			try {
				usuario = Controlador.getInstancia().existeUsuario(username, password);
			} catch (UsuarioException e) {
				
				e.printStackTrace();
			}
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("./vistaComprador.jsp").forward(request, response);				
		}
		
		else if ("Reclamar".equalsIgnoreCase(action)) {
			String facturaId = request.getParameter("facturaId");
			request.setAttribute("facturaId", facturaId);			
			request.getRequestDispatcher("./ingresarReclamo.jsp").forward(request, response);
		}
		
		else if ("ingresarReclamo".equalsIgnoreCase(action)) {
			Random rand = new Random();
			int  n = rand.nextInt(999999999) + 111111111;
			String id = Integer.toString(n);
			String reclamo = request.getParameter("reclamo");
			String facturaId = request.getParameter("facturaId");			
			try {
				Controlador.getInstancia().ingresarReclamo(id,reclamo,true,"abierto",facturaId);
			} catch (FacturaException e) {
				e.printStackTrace();
			}
			dispatch("comReclamos.jsp", request, response);						
		}
		
		/*else if ("admUsuarios".equalsIgnoreCase(action)) {
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
		}*/	
		
	}
	/*
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
	
	else if ("editarProducto".equalsIgnoreCase(action)) {
		String codBarra = request.getParameter("codBarra");
		String nombre =  request.getParameter("nombre");
		String precio = request.getParameter("precio");
		request.setAttribute("codBarra", codBarra);
		request.getRequestDispatcher("./editarMisProductos.jsp").forward(request, response);			
	}
	
	else if ("modificarProducto".equalsIgnoreCase(action)) {
		String codBarra = request.getParameter("codBarra");
		String nombre =  request.getParameter("nombre");
		String estado =  request.getParameter("estado");
		float precio = Float.parseFloat(request.getParameter("precio"));			
		Controlador.getInstancia().modificarProducto(codBarra, nombre, precio, estado);
		request.setAttribute("codBarra", codBarra);
		request.getRequestDispatcher("./venMisProductos.jsp").forward(request, response);			
	}*/

	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (jsp != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	
}
