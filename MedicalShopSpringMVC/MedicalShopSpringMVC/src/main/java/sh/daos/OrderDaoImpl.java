package sh.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sh.entities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(order);
	}

	@Override
	public List<Order> fetchOrders(String status) {
		String hql = "from Order where status like :p_status order by orderTime desc";
		List<Order> orders = new ArrayList<Order>();
		Session session = sessionFactory.getCurrentSession();
		Query<Order> query = session.createQuery(hql);
		query.setParameter("p_status", status);
		orders = query.list();
		return orders;
	}

	@Override
	public Order fetchOrder(int orderID) {
		Order order = new Order();
		Session session = sessionFactory.getCurrentSession();
		order = session.find(Order.class, orderID);
		return order;
	}

	@Override
	public List<String> fetchStatus() {
		String hql = "select distinct status from Order";
		List<String> typesList = new ArrayList<String>();
		Session session = sessionFactory.getCurrentSession();
		Query<String> query = session.createQuery(hql);
		typesList = query.list();
		return typesList;
	}

	@Override
	public void updateOrder(Order o) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(o);
	}
}