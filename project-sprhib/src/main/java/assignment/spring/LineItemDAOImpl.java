package assignment.spring;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LineItemDAOImpl implements LineItemsDAO{

	
	private SessionFactory sessionFactory;
		
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
		
	@Override
	public void save(LineItems li) {
		new HibernateTemplate(sessionFactory).save(li);
	}

	@Override
	public void update(LineItems li) {
		new HibernateTemplate(sessionFactory).update(li);
	}

	@Override
	public void delete(long id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
	}

	@Override
	public LineItems get(long id) {
		return new HibernateTemplate(sessionFactory).load(LineItems.class, id);
	}

	@Override
	public List<LineItems> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItems li");
	}


	
}
