package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ReclamoEntity;
import entities.UsuarioEntity;
import exceptions.UsuarioException;
import hbt.HibernateUtil;
import negocio.Usuario;

public class ReclamoDAO {

private static ReclamoDAO instancia;
	
	
	private ReclamoDAO() {}
	
	
	public static ReclamoDAO getInstancia() {
		if(instancia == null)
			instancia = new ReclamoDAO();
		return instancia;
	}
	
	public void grabar(negocio.Reclamo Reclamo){
		ReclamoEntity re = new ReclamoEntity(Reclamo.getReclamo_id(),Reclamo.getDetalles(),Reclamo.isActivo());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(re);
		session.getTransaction().commit();
		session.close();
	}

}
