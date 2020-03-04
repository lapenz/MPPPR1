package MPP.Project1.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public abstract class Model<T> implements IModel<T> {

	
	@Override
	public void save() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
		session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
		session.close();
	    
	}
	
	
	@Override
	public void update() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    
		session.beginTransaction();
        session.saveOrUpdate(this);
        session.getTransaction().commit();
        
        session.close();
		
	}
	@Override
	public void delete() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    
		session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
        
        session.close();
		
	}
	@Override
	public T find(int id)  {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    
		Query q = session.createQuery("FROM "+ this.getClass().getName() + " where id = " + id);
        
        T obj = (T) q.uniqueResult();
        
        session.close();
        
        return obj;
	}
	
	@Override
	public List<T> findAll() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("FROM "+ this.getClass().getName());
        
        List<T> objs = q.list();
        
        session.close();
        
        return objs;
        
        
	}
}
