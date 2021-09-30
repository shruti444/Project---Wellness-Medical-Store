package sh.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.daos.OrderDao;
import sh.entities.Customer;
import sh.entities.ItemPrice;
import sh.entities.Order;
import sh.entities.OrderDetail;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	@Transactional
	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
	}

	@Override
	@Transactional
	public List<Order> fetchOrders(String status) {
		return orderDao.fetchOrders(status);
	}

	@Override
	@Transactional
	public Order fetchOrder(int orderID) {
		return orderDao.fetchOrder(orderID);
	}

	@Override
	@Transactional
	public Order createOrder(Customer customer, List<ItemPrice> cart) {
		Order order = new Order();
		order.setCustomer(customer);
		List<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>();
		for(ItemPrice price:cart)
			orderDetailsList.add(new OrderDetail(0, order, price));
		order.setOrderDetailsList(orderDetailsList);
		order.setOrderTime(Date.from(Instant.now()));
		order.setStatus("Pending");
		customer.getOrdersList().add(order);
		return order;
	}

	@Override
	@Transactional
	public List<String> fetchStatus() {
		return orderDao.fetchStatus();
	}

	@Override
	@Transactional
	public void updateOrder(Order o) {
		orderDao.updateOrder(o);
	}
}
