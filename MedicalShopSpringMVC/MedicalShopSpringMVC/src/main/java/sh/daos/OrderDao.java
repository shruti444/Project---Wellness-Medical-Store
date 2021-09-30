package sh.daos;

import java.util.List;

import sh.entities.Order;

public interface OrderDao {

	void insertOrder(Order order);

	List<Order> fetchOrders(String status);

	Order fetchOrder(int orderID);

	List<String> fetchStatus();

	void updateOrder(Order o);

}