package sh.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MED_ORDERS")
public class Order {
	@TableGenerator(name = "gen", table = "idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column(name = "ID")
	private int orderID;
	@ManyToOne
	@JoinColumn(name = "CustomerId")
	private Customer customer;
	@Column(name = "OrderTime")
	private Date orderTime;
	@Column(name = "STATUS")
	private String status;
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<OrderDetail> orderDetailsList;

	public Order() {
		this.orderID = 0;
		this.customer = new Customer();
		this.orderTime = new Date();
		this.status = "";
		this.orderDetailsList = new ArrayList<OrderDetail>();
	}

	public Order(int orderID, Customer customer, Date orderTime, String status) {
		this.orderID = orderID;
		this.customer = customer;
		this.orderTime = orderTime;
		this.status = status;
		this.orderDetailsList = new ArrayList<OrderDetail>();
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetail> getOrderDetailsList() {
		return orderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetail> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}

	public void addOrderDetail(OrderDetail od) {
		this.orderDetailsList.add(od);
		od.setOrder(this);
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customerID=" + customer.getCustomerID() + ", orderTime=" + orderTime
				+ ", status=" + status + "]";
	}

}