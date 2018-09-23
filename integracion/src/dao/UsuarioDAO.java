package dao;

import hbt.HibernateUtil;
import negocio.Producto;
import negocio.Usuario;

import javax.management.Query;

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
	
	/*public ClubEntity findByID(Integer idClub) throws ClubException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClubEntity ce = (ClubEntity) session.createQuery("from ClubEntity where id = ?")
					.setParameter(0, idClub)
					.uniqueResult();
		if(ce != null){
			return ce;
		}
		else 
			throw new ClubException("El club solicitado no existe");
	}*/
	
	public UsuarioEntity findById(String usuario_id) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity ue = (UsuarioEntity) session.createQuery("from UsuarioEntity where usuario_id = ?")
				.setParameter(0, usuario_id).uniqueResult();
		if(ue != null){
			return ue;
		}
		else 
			throw new UsuarioException("El Usuario solicitado no existe");
	}
	
	public void grabar(Usuario Usuario){
		UsuarioEntity ue = new UsuarioEntity(Usuario.getUsuario_id(),Usuario.getUsername(),Usuario.getPassword(),Usuario.getTelefono(),Usuario.getMail(),Usuario.getDireccion(),Usuario.getTipo_usuario(),Usuario.isActivo());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(ue);
		session.getTransaction().commit();
		session.close();
	}
	
	public void bajaUsuario(String usuario_id) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity ue = (UsuarioEntity) session.createQuery("from UsuarioEntity where usuario_id = ?")
				.setParameter(0, usuario_id).uniqueResult();
		if (ue!=null){			
			ue.setActivo(false);
			session.beginTransaction();
			session.save(ue);
			session.getTransaction().commit();
			session.close();
		}else {
			throw new UsuarioException("El usuario no existe, verifique el codigo de barras");
		}		
	}


	public Usuario getUsuarioById(String usuario_id) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity ue = (UsuarioEntity) session.createQuery("from UsuarioEntity where usuario_id = ?")
				.setParameter(0, usuario_id).uniqueResult();
		if (ue!=null){
			return new Usuario(ue);			
		}else {
			throw new UsuarioException("El usuario no existe, verifique el codigo de barras");
		}
	}


	public void activarUsuario(String usuario_id) throws UsuarioException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		UsuarioEntity ue = (UsuarioEntity) session.createQuery("from UsuarioEntity where usuario_id = ?")
				.setParameter(0, usuario_id).uniqueResult();
		if (ue!=null){			
			ue.setActivo(true);
			session.beginTransaction();
			session.save(ue);
			session.getTransaction().commit();
			session.close();
		}else {
			throw new UsuarioException("El usuario no existe, verifique el codigo de barras");
		}	
	}


	public void modificarUsuario(String usuario_id, String username, String mail, String direccion, String telefono, String tipo_usuario,
			boolean b) throws UsuarioException {SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			UsuarioEntity ue = (UsuarioEntity) session.createQuery("from UsuarioEntity where usuario_id = ?")
					.setParameter(0, usuario_id).uniqueResult();
			if (ue!=null){
				ue.setTipo_usuario(tipo_usuario);
				ue.setUsername(username);
				ue.setTelefono(telefono);
				ue.setMail(mail);
				ue.setDireccion(direccion);
				ue.setActivo(b);
				session.beginTransaction();
				session.save(ue);
				session.getTransaction().commit();
				session.close();
			}else {
				throw new UsuarioException("El usuario no existe, verifique el codigo de barras");
			}		
	}


	
	
}
