package assignment.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class hibernateClient {
	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration()
								.addAnnotatedClass(Customer.class)
								.buildSessionFactory();
		
		Session ses = sf.openSession();
		Transaction trans = ses.beginTransaction();
		
		Customer c1 = new Customer ("Hemant", 22, "jodhpur", "ambaji");
		
		
		ses.save(c1);
		
		trans.commit();
		ses.close();
		sf.close();
		System.out.println(c1);
	}
}
