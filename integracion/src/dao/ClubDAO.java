package dao;

import hbt.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClubEntity;
import exceptions.ClubException;

public class ClubDAO {

	private static ClubDAO instancia;
	
	private ClubDAO() {}
	
	public static ClubDAO getInstance() {
		if(instancia == null)
			instancia = new ClubDAO();
		return instancia;
	}

	public ClubEntity findByID(Integer idClub) throws ClubException {
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
	}
}
