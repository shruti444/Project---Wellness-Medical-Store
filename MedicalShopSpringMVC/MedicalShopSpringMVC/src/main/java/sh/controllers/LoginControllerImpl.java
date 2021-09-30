package sh.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sh.entities.Customer;
import sh.entities.ItemPrice;
import sh.models.Login;
import sh.services.LoginService;

@Controller
public class LoginControllerImpl {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("command", new Login());
		return "login";
	}
	
	@RequestMapping("/auth")
	public String authenticate(Login l, HttpSession session) {
		Customer customer = loginService.fetchCustomer(l.getEmail());
		if(!customer.getPassword().equals(l.getPassword()) || l.getEmail().isEmpty() || l.getPassword().isEmpty())
			return "failure";
		session.setAttribute("customer", customer);
		if(customer.getEmail().equals("admin@pizzashop.com"))
			return "redirect:orders";
		if(session.getAttribute("cart") == null)
			session.setAttribute("cart", new ArrayList<ItemPrice>());
		return "redirect:types";
	}
	
	@RequestMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("command", new Customer());
		return "signup";
	}
	
	@RequestMapping("/register")
	public String register(Customer customer) {
		loginService.insertCustomer(customer);
		return "redirect:login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
