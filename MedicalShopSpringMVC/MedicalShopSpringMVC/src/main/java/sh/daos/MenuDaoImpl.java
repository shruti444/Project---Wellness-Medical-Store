package sh.daos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.entities.Item;
import sh.entities.ItemPrice;

@Repository
public class MenuDaoImpl implements MenuDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> fetchTypes() {
		String hql = "select distinct type from Item";
		List<String> typesList = new ArrayList<String>();
		Session session = sessionFactory.getCurrentSession();
		Query<String> query = session.createQuery(hql);
		typesList = query.list();
		return typesList;
	}

	@Override
	public List<String> fetchCategories(String type) {
		String hql = "select distinct category from Item where type=:p_type";
		List<String> categoryList = new ArrayList<String>();
		Session session = sessionFactory.getCurrentSession();
		Query<String> query = session.createQuery(hql);
		query.setParameter("p_type", type);
		categoryList = query.list();
		return categoryList;
	}

	@Override
	public List<Item> fetchItems(String category) {
		String hql = "from Item where category=:p_category";
		List<Item> items = new ArrayList<Item>();
		Session session = sessionFactory.getCurrentSession();
		Query<Item> query = session.createQuery(hql);
		query.setParameter("p_category", category);
		items = query.list();
		return items;
	}

	@Override
	public Item fetchItem(int itemID) {
		Item item = new Item();
		Session session = sessionFactory.getCurrentSession();
		item = session.find(Item.class, itemID);
		return item;
	}

	@Override
	public List<ItemPrice> fetchItemPrices(int itemID) {
		String hql = "from ItemPrice where itemID=:p_itemID";
		List<ItemPrice> itemPrices = new ArrayList<ItemPrice>();
		Session session = sessionFactory.getCurrentSession();
		Query<ItemPrice> query = session.createQuery(hql);
		query.setParameter("p_itemID", itemID);
		itemPrices = query.list();
		return itemPrices;
	}
	
	@Override
	public ItemPrice fetchItemPrice(int itemPriceID) {
		String hql = "from ItemPrice where itemPriceID=:p_itemPriceID";
		ItemPrice itemPrice = new ItemPrice();
		Session session = sessionFactory.getCurrentSession();
		Query<ItemPrice> query = session.createQuery(hql);
		query.setParameter("p_itemPriceID", itemPriceID);
		itemPrice = query.getSingleResult();
		return itemPrice;
	}
}