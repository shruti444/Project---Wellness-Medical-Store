package sh.services;

import java.util.List;

import sh.entities.Customer;
import sh.entities.ItemPrice;
import sh.entities.Order;

public interface OrderService {

	void insertOrder(Order order);

	List<Order> fetchOrders(String status);

	Order fetchOrder(int orderID);

	Order createOrder(Customer customer, List<ItemPrice> cart);

	List<String> fetchStatus();

	void updateOrder(Order o);

}