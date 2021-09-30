package sh.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.entities.Customer;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(customer);
	}

	@Override
	public Customer fetchCustomer(String email) {
		Customer customer = new Customer();
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> q = session.createQuery("from Customer c where c.email = :p_email");
		q.setParameter("p_email", email);
		try {
			customer = q.getSingleResult();
		} catch (Exception e) {}
		return customer;
	}
}
