package sh.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MED_CUSTOMERS")
public class Customer {
	@TableGenerator(name = "gen", table = "idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column(name = "ID")
	private int customerID;
	@Column(name = "Name")
	private String name;
	@Column(name = "Password")
	private String password;
	@Column(name = "Mobile")
	private String mobile;
	@Column(name = "Address")
	private String address;
	@Column(name = "Email")
	private String email;
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Order> ordersList;

	public Customer() {
		this.customerID = 0;
		this.name = "";
		this.password = "";
		this.mobile = "";
		this.address = "";
		this.email = "";
		this.ordersList = new ArrayList<Order>();
	}

	public Customer(int customerID, String name, String password, String mobile, String address, String email) {
		this.customerID = customerID;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.ordersList = new ArrayList<Order>();
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", password=" + password + ", mobile=" + mobile
				+ ", address=" + address + ", email=" + email + "]";
	}

}
