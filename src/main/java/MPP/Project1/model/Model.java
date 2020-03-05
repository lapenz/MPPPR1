package MPP.Project1.model;

import java.util.List;

import javax.persistence.EntityManager;

import MPP.Project1.HibernateUtil;

public abstract class Model<T> implements IModel<T> {

	
	@Override
	public void save() {
	    EntityManager em = HibernateUtil.getEntityManager();
	    em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
	    
	}
	
	
	@Override
	public void update() {
		EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(this);
        em.getTransaction().commit();
		
	}
	@Override
	public void delete() {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
	    em.remove(this);
	    em.getTransaction().commit();
		
	}
	@Override
	public T find(int id)  {
        
		EntityManager em = HibernateUtil.getEntityManager();
		T obj = (T) em.find(this.getClass(), id);
        return obj;
	}
	
	@Override
	public T findFirst(String column, String value)  {
		EntityManager em = HibernateUtil.getEntityManager();

		T obj = (T) em.createQuery("select t from " + this.getClass().getName() + " t where " + column + "=" + "'"+value+"'").getSingleResult();
		
		return obj;
	}
	
	@Override
	public List<T> findAll() {
		EntityManager em = HibernateUtil.getEntityManager();

		List<T> obj = em.createQuery("select t from " + this.getClass().getName() + " t").getResultList();
		
		return obj;
        
        
	}
}
