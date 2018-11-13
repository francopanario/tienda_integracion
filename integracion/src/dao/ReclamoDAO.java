package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.FacturaEntity;
import entities.ProductoEntity;
import entities.ReclamoEntity;
import entities.UsuarioEntity;
import exceptions.FacturaException;
import exceptions.UsuarioException;
import hbt.HibernateUtil;
import negocio.Factura;
import negocio.Producto;
import negocio.Reclamo;
import negocio.Usuario;

public class ReclamoDAO {

private static ReclamoDAO instancia;
	
	
	public ReclamoDAO() {}
	
	
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
		session.saveOrUpdate(re);
		session.getTransaction().commit();
		session.close();
	}


	public List<Reclamo> getAll() {
		List<Reclamo> reclamos = new ArrayList<>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<ReclamoEntity> list = session.createQuery("from ReclamoEntity").list();
		int i=0;
		for(ReclamoEntity entity: list) {
			reclamos.add(entity.toNegocio(list.get(i)));
			i++;
		}
		return reclamos;		
	}

}
