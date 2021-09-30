package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MED_PRICING")
public class ItemPrice {
	@TableGenerator(name = "gen", table = "idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column(name = "ID")
	private int itemPriceID;
	//@ManyToOne(fetch = FetchType.EAGER)
	@OneToOne
	@JoinColumn(name = "ITEMID")
	private Item item;
	@Column(name = "SIZES")
	private String sizes;
	@Column(name = "Price")
	private double price;

	public ItemPrice() {
		this.itemPriceID = 0;
		this.item = new Item();
		this.sizes = "";
		this.price = 0;
	}

	public ItemPrice(int itemPriceID, Item item, String sizes, double price) {
		this.itemPriceID = itemPriceID;
		this.item = item;
		this.sizes = sizes;
		this.price = price;
	}

	public int getItemPriceID() {
		return itemPriceID;
	}

	public void setItemPriceID(int itemPriceID) {
		this.itemPriceID = itemPriceID;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemPrice [itemPriceID=" + itemPriceID + ", itemID=" + item.getItemID() + ", sizes=" + sizes
				+ ", price=" + price + "]";
	}
}
