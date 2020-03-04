package MPP.Project1;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		try{
			loadSessionFactory();
		}catch(Exception e){
			System.err.println("Exception while initializing hibernate util.. ");
			e.printStackTrace();
		}
	}

	public static void loadSessionFactory(){

		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public static Session getSession() throws HibernateException {

		Session retSession=null;
	    	try {
	    		retSession = sessionFactory.openSession();
	    	}catch(Throwable t){
			System.err.println("Exception while getting session.. ");
			t.printStackTrace();
	    	}
	    	if(retSession == null) {
	    		System.err.println("session is discovered null");
	    	}

	    	return retSession;
    }
}