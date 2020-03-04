package MPP.Project1.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import MPP.Project1.HibernateUtil;

public abstract class Model<T> implements IModel<T> {

	
	@Override
	public void save() {
	    Session session = HibernateUtil.getSession();
		session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
		session.close();
	    
	}
	
	
	@Override
	public void update() {
		Session session = HibernateUtil.getSession();
	    
		session.beginTransaction();
        session.saveOrUpdate(this);
        session.getTransaction().commit();
        
        session.close();
		
	}
	@Override
	public void delete() {
		Session session = HibernateUtil.getSession();
	    
		session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
        
        session.close();
		
	}
	@Override
	public T find(int id)  {
		Session session = HibernateUtil.getSession();
	    
		Query q = session.createQuery("FROM "+ this.getClass().getName() + " where id = " + id);
        
        T obj = (T) q.uniqueResult();
        
//        session.close();
        
        return obj;
	}
	
	@Override
	public List<T> findAll() {
		Session session = HibernateUtil.getSession();
		
		Query q = session.createQuery("FROM "+ this.getClass().getName());
        
        List<T> objs = q.list();
        
//        session.close();
        
        return objs;
        
        
	}
}
