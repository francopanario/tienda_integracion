package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ProductoEntity;
import entities.UsuarioEntity;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import hbt.HibernateUtil;
import negocio.Jugador;
import negocio.Producto;

public class ProductoDAO {
	
	
	private static ProductoDAO instancia;
	
	
	private ProductoDAO () {}
	
	
	public static ProductoDAO getInstancia() {
		if(instancia == null)
			instancia = new ProductoDAO();
		return instancia;	
	}
	
	
	public Producto getProductoById(String codBarra) throws ProductoException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProductoEntity pe = (ProductoEntity) session.createQuery("from ProductoEntity where producto_id = ?")
				.setParameter(0, codBarra);
		if (pe!=null){
			return new Producto(pe);			
		}else {
			throw new ProductoException("El producto no existe, verifique el codigo de barras");
		}
	}
	
	public void grabar(Producto producto){		
		ProductoEntity pe = new ProductoEntity(producto.getCodBarra(), producto.getNombre(), producto.getPrecio(),producto.isActivo());
		UsuarioEntity usuario = null;
		try {
			usuario = UsuarioDAO.getInstancia().findById(producto.getUsuario().getUsuario_id());
		} catch (UsuarioException e) {			 
			e.printStackTrace();
		}
		pe.setUsuario(usuario);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(pe);
		session.getTransaction().commit();
		session.close();
	}	

}
