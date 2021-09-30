package sh.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.daos.MenuDao;
import sh.entities.Item;
import sh.entities.ItemPrice;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	
	@Override
	@Transactional
	public List<String> fetchTypes() {
		return menuDao.fetchTypes();
	}

	@Override
	@Transactional
	public List<String> fetchCategories(String type) {
		return menuDao.fetchCategories(type);
	}

	@Override
	@Transactional
	public List<Item> fetchItems(String category) {
		return menuDao.fetchItems(category);
	}

	@Override
	@Transactional
	public Item fetchItem(int itemID) {
		return menuDao.fetchItem(itemID);
	}

	@Override
	@Transactional
	public List<ItemPrice> fetchItemPrices(int itemID) {
		return menuDao.fetchItemPrices(itemID);
	}
	
	@Override
	@Transactional
	public ItemPrice fetchItemPrice(int itemPriceID) {
		return menuDao.fetchItemPrice(itemPriceID);
	}
}
