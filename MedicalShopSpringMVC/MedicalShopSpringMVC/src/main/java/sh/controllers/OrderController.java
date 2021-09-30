package sh.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sh.entities.Customer;
import sh.entities.ItemPrice;
import sh.entities.Order;
import sh.models.Price;
import sh.models.Status;
import sh.services.MenuService;
import sh.services.OrderService;

@Controller
public class OrderController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/addtocart")
	public String addToCart(Price p, HttpSession session, Model m) {
		if(session.getAttribute("cart") == null)
			session.setAttribute("cart", new ArrayList<ItemPrice>());
		List<ItemPrice> cart = (List<ItemPrice>) session.getAttribute("cart");
		cart.add(menuService.fetchItemPrice(p.getPrice()));
		return "redirect:types";
	}
	
	@RequestMapping("/cart")
	public String showCart(Price p, HttpSession session, Model m) {
		return "cart";
	}
	
	@RequestMapping("/placeorder")
	public String placeOrder(HttpSession session) {
		List<ItemPrice> cart = (List<ItemPrice>) session.getAttribute("cart");
		Customer customer = (Customer)session.getAttribute("customer");
		if(customer == null)
			return "redirect:login";
		Order order = orderService.createOrder(customer, cart);
		orderService.insertOrder(order);
		cart.clear();
		return "redirect:types";
	}
	
	@RequestMapping("/orders")
	public String orders(Status s, Model m) {
		m.addAttribute("status", orderService.fetchStatus());
		m.addAttribute("command", new Status());
		m.addAttribute("orders", orderService.fetchOrders(s.getStatus()));
		return "orders";
	}
	
	@RequestMapping("/orderdetails")
	public String orderDetails(@RequestParam("id") int id, Model m) {
		m.addAttribute("command", new Status());
		m.addAttribute("order", orderService.fetchOrder(id));
		return "orderdetails";
	}
	
	@RequestMapping("/updateorder")
	public String updateOrder(@RequestParam("id") int id, Status s, Model m) {
		Order o = orderService.fetchOrder(id);
		o.setStatus(s.getStatus());
		orderService.updateOrder(o);
		return "redirect:orders";
	}
}
