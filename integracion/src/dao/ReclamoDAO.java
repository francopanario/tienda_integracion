package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.FacturaEntity;
import entities.ReclamoEntity;
import entities.UsuarioEntity;
import exceptions.FacturaException;
import exceptions.UsuarioException;
import hbt.HibernateUtil;
import negocio.Factura;
import negocio.Usuario;

public class ReclamoDAO {

private static ReclamoDAO instancia;
	
	
	private ReclamoDAO() {}
	
	
	public static ReclamoDAO getInstancia() {
		if(instancia == null)
			instancia = new ReclamoDAO();
		return instancia;
	}
	
	public void grabar(negocio.Reclamo reclamo) throws FacturaException{
		ReclamoEntity re = new ReclamoEntity(reclamo.getReclamo_id(),reclamo.getDetalles(),reclamo.isActivo(),reclamo.getEstado());
		FacturaEntity factura = FacturaDAO.getInstancia().getFacturaByID(reclamo.getFactura().getFacturaID());
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		re.setFactura(factura);
		session.save(re);
		session.getTransaction().commit();
		session.close();
	}

}
