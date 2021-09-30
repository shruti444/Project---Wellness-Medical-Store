package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MED_ORDERDETAILS")
public class OrderDetail {
	@TableGenerator(name = "gen", table = "idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column(name = "ID")
	private int orderDetailID;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderId")
	private Order order;
	//@ManyToOne
	@OneToOne
	@JoinColumn(name = "PRICEID")
	private ItemPrice price;

	public OrderDetail() {
		this.orderDetailID = 0;
		this.order = new Order();
		this.price = new ItemPrice();
	}

	public OrderDetail(int orderDetailID, Order order, ItemPrice price) {
		this.orderDetailID = orderDetailID;
		this.order = order;
		this.price = price;
	}

	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ItemPrice getPrice() {
		return price;
	}

	public void setPrice(ItemPrice price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailID=" + orderDetailID + ", orderID=" + order.getOrderID() + ", priceID="
				+ price.getItemPriceID() + "]";
	}

}