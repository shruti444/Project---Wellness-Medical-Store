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
import sh.models.Category;
import sh.models.Item;
import sh.models.Price;
import sh.models.Type;
import sh.services.MenuService;
import sh.services.OrderService;

@Controller
public class ItemController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/categories")
	public String categories(Type t, Model m) {
		m.addAttribute("command", new Category());
		m.addAttribute("type", t.getType());
		m.addAttribute("categories", menuService.fetchCategories(t.getType()));
		return "categories";
	}
	
	@RequestMapping("/items")
	public String items(Category c, Model m) {
		m.addAttribute("command", new Item());
		m.addAttribute("items", menuService.fetchItems(c.getCategory()));
		return "items";
	}
	
	@RequestMapping("/types")
	public String types(Model m) {
		m.addAttribute("command", new Type());
		m.addAttribute("types", menuService.fetchTypes());
		return "types";
	}
	
	@RequestMapping("/item")
	public String item(Item i, Model m) {
		m.addAttribute("command", new Price());
		m.addAttribute("item", menuService.fetchItem(i.getItem()));
		return "item";
	}
}
