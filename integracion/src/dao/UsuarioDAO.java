package dao;

import hbt.HibernateUtil;
import negocio.Producto;
import negocio.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClubEntity;
import entities.ProductoEntity;
import entities.UsuarioEntity;
import exceptions.ClubException;
import exceptions.ProductoException;
import exceptions.UsuarioException;


public class UsuarioDAO {
	
	
	private static UsuarioDAO instancia;
	
	
	
	private UsuarioDAO() {}
	
	public static UsuarioDAO getInstancia() {
		if(instancia == null)
			instancia = new UsuarioDAO();
		return instancia;
	}
	
	public Usuario findByID(String usuario_id) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity ue = (UsuarioEntity) session.createQuery("from UsuarioEntity where usuario_id = ?");
		if (ue!=null){
			return new Usuario(ue);			
		}else {
			throw new UsuarioException("El usuario no existe, verifique el dni");
		}
	}
	
	
	public UsuarioEntity findById(String usuario_id) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity ue = (UsuarioEntity) session.createQuery("from UsuarioEntity where usuario_id = ?");
		if(ue != null){
			return ue;
		}
		else 
			throw new UsuarioException("El Usuario solicitado no existe");
	}
	
	public void grabar(Usuario Usuario){
		UsuarioEntity je = new UsuarioEntity(Usuario.getUsuario_id(),Usuario.getUsername(),Usuario.getPassword(),Usuario.getTelefono(),Usuario.getMail(),Usuario.getDireccion(),Usuario.getTipo_usuario());
		System.out.println("asdddddddddddddddddddddddddddddddddd" + je.getDireccion());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(je);
		session.getTransaction().commit();
		session.close();
	}

}
