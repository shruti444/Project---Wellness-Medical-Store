package sh.daos;

import java.util.List;

import sh.entities.Item;
import sh.entities.ItemPrice;

public interface MenuDao {

	List<String> fetchTypes();

	List<String> fetchCategories(String type);

	List<Item> fetchItems(String category);

	Item fetchItem(int itemID);

	List<ItemPrice> fetchItemPrices(int itemID);
	
	ItemPrice fetchItemPrice(int itemPriceID);

}