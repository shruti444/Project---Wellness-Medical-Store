package sh.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.daos.LoginDao;
import sh.entities.Customer;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;
	@Override
	@Transactional
	public void insertCustomer(Customer customer) {
		loginDao.insertCustomer(customer);
	}

	@Override
	@Transactional
	public Customer fetchCustomer(String email) {
		return loginDao.fetchCustomer(email);
	}
}
