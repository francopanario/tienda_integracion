package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.*;
import exceptions.ProductoException;
import exceptions.UsuarioException;
import hbt.HibernateUtil;

import negocio.*;
import negocio.Usuario;

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
				.setParameter(0, codBarra).uniqueResult();
		if (pe!=null){
			return new Producto(pe);			
		}else {
			throw new ProductoException("El producto no existe, verifique el codigo de barras");
		}
	}	
	
	public Usuario getVendedorAsociado(String codBarra) throws UsuarioException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProductoEntity pe = (ProductoEntity) session.createQuery("from ProductoEntity as uss where uss.codBarra=?")
				.setParameter(0, codBarra).uniqueResult();
		UsuarioEntity ue = UsuarioDAO.getInstancia().findById(pe.getUsuario().getUsuario_id());
		if (ue!=null){
			return new Usuario(ue);			
		}else {
			throw new UsuarioException("El producto no existe, verifique el codigo de barras");
		}
	}	
	
	public ProductoEntity getProductoEntityById(String codBarra) throws ProductoException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProductoEntity pe = (ProductoEntity) session.createQuery("from ProductoEntity where producto_id = ?")
				.setParameter(0, codBarra).uniqueResult();
		if (pe!=null){
			return pe;			
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

	public void bajaProducto(String codBarra) throws ProductoException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProductoEntity pe = (ProductoEntity) session.createQuery("from ProductoEntity where producto_id = ?")
				.setParameter(0, codBarra).uniqueResult();
		if (pe!=null){
			pe.setActivo(false);
			session.beginTransaction();
			session.save(pe);
			session.getTransaction().commit();
			session.close();
		}else {
			throw new ProductoException("El Producto no existe, verifique el codigo de barras");
		}		
	}	

	public void modificarProducto(String codBarra, String nombre, float precio, String estado) throws UsuarioException, ProductoException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProductoEntity pe = (ProductoEntity) session.createQuery("from ProductoEntity where producto_id = ?")
				.setParameter(0, codBarra).uniqueResult();		
		if (pe!=null){
			pe.setNombre(nombre);
			pe.setPrecio(precio);
			String est=estado;
			if (est.equalsIgnoreCase("true")){
				pe.setActivo(true);
			}else {
				pe.setActivo(false);
			}
			session.beginTransaction();
			session.save(pe);
			session.getTransaction().commit();
			session.close();
		}else {
			throw new ProductoException("El Producto no existe, verifique el codigo de barras");
		}
		
	}
	
	public List<Producto> getAll() {
		List<Producto> productos = new ArrayList<>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<ProductoEntity> list = session.createQuery("from ProductoEntity").list();
		int i=0;
		for(ProductoEntity entity: list) {
			productos.add(entity.toNegocio(list.get(i)));
			i++;
		}
		return productos;
	}
	
	public List<Producto> getAllVendedor(String usuario_id) {
		List<Producto> productos = new ArrayList<>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<ProductoEntity> list = (List<ProductoEntity>) session.createQuery("from ProductoEntity p where p.usuario.usuario_id=?").setParameter(0,usuario_id).list();
		int i=0;
		for(ProductoEntity entity: list) {
			productos.add(entity.toNegocio(list.get(i)));
			i++;
		}
		return productos;
	}

}
