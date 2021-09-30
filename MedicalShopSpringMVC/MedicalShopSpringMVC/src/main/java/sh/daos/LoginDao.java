package sh.daos;

import sh.entities.Customer;

public interface LoginDao {

	void insertCustomer(Customer customer);

	Customer fetchCustomer(String email);

}