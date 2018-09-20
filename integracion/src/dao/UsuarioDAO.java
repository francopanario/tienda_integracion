package dao;

import hbt.HibernateUtil;
import negocio.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClubEntity;
import entities.UsuarioEntity;


public class UsuarioDAO {

	/** Yo soy un DAO, asi que no tengo estado, mas que las variable que necesito para instanciarme.
	 *  Nunca voy a tener un método de negocio dentro mio
	 * */
	private static UsuarioDAO instancia;
	
	private UsuarioDAO() {}
	
	public static UsuarioDAO getInstance() {
		if(instancia == null)
			instancia = new UsuarioDAO();
		return instancia;
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
