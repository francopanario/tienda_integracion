package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClubEntity;
import entities.JugadorEntity;
import entities.ProductoEntity;
import entities.UsuarioEntity;
import exceptions.ClubException;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import hbt.HibernateUtil;
import negocio.Jugador;
import negocio.Producto;

public class ProductoDAO {
	
	
	private static ProductoDAO instancia;
	
	
	private ProductoDAO () {}
	
	
	public static ProductoDAO getIntancia() {
		if(instancia == null)
			instancia = new ProductoDAO();
		return instancia;	
	}
	
	
	public Producto getProductoById(String codBarra) throws ProductoException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProductoEntity pe = (ProductoEntity) session.createQuery("from ProductoEntity where codBarra = ?");
		if (pe!=null){
			return new Producto(pe);			
		}else {
			throw new ProductoException("El producto no existe, verifique el codigo de barras");
		}
	}
	
	public void grabar(Producto producto){		
		ProductoEntity je = new ProductoEntity(producto.getCodBarra(), producto.getNombre(), producto.getPrecio());
		UsuarioEntity usuario = null;
		try {
			usuario = UsuarioDAO.getInstancia().findById(producto.getUsuario().getUsuario_id());
		} catch (UsuarioException e) {			 
			e.printStackTrace();
		}
		je.setUsuario(usuario);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(je);
		session.getTransaction().commit();
		session.close();
	}
	
	

}
