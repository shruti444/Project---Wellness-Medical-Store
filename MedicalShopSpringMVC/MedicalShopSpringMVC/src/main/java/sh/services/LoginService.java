package sh.services;

import sh.entities.Customer;

public interface LoginService {

	void insertCustomer(Customer customer);

	Customer fetchCustomer(String email);

}