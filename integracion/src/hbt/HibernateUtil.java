package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.ClubEntity;
import entities.*;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(JugadorEntity.class);
             config.addAnnotatedClass(UsuarioEntity.class);
             config.addAnnotatedClass(ClubEntity.class);
             config.addAnnotatedClass(ProductoEntity.class);
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
