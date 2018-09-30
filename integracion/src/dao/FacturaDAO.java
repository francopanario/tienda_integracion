package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.*;

import exceptions.*;

import hbt.HibernateUtil;
import negocio.*;


public class FacturaDAO {

private static FacturaDAO instancia;
	
	
	private FacturaDAO () {}
	
	
	public static FacturaDAO getInstancia() {
		if(instancia == null)
			instancia = new FacturaDAO();
		return instancia;	
	}
	
	
	public Factura getFacturaById(String factura_id) throws FacturaException{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		FacturaEntity fa = (FacturaEntity) session.createQuery("from FacturaEntity where factura_id = ?")
				.setParameter(0, factura_id).uniqueResult();
		if (fa!=null){
			return new Factura(fa);			
		}else {
			throw new FacturaException("La factura no existe, verifique el codigo de factura");
		}
	}
	
	public void grabar(Factura factura){		
		FacturaEntity fa = new FacturaEntity(factura.getFacturaID());
		UsuarioEntity comprador = null;
		UsuarioEntity vendedor = null;
		ProductoEntity articulo=null;
		try {
			comprador = UsuarioDAO.getInstancia().findById(factura.getComprador().getUsuario_id());
			vendedor= UsuarioDAO.getInstancia().findById(factura.getVendedor().getUsuario_id());
			articulo=ProductoDAO.getInstancia().getProductoEntityById(factura.getArticulo().getCodBarra());
		} catch (UsuarioException e) {			 
			e.printStackTrace();
		} catch (ProductoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fa.setArticulo(articulo);
		fa.setComprador(comprador);
		fa.setVendedor(vendedor);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(fa);
		session.getTransaction().commit();
		session.close();
	}	
	
}