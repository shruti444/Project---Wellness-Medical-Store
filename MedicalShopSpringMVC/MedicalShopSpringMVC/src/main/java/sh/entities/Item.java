package sh.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "MED_ITEMS")
public class Item {
	@TableGenerator(name = "gen", table = "idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column(name = "ID")
	private int itemID;
	@Column(name = "Name")
	private String name;
	@Column(name = "Type")
	private String type;
	@Column(name = "Category")
	private String category;
	@Column(name = "Description")
	private String description;
	@OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
	private List<ItemPrice> itemPricesList;

	public Item() {
		this.itemID = 0;
		this.name = "";
		this.type = "";
		this.category = "";
		this.description = "";
		this.itemPricesList = new ArrayList<ItemPrice>();
	}

	public Item(int itemID, String name, String type, String category, String description) {
		this.itemID = itemID;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.itemPricesList = new ArrayList<ItemPrice>();
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemPrice> getItemPricesList() {
		return itemPricesList;
	}

	public void setItemPricesList(List<ItemPrice> itemPricesList) {
		this.itemPricesList = itemPricesList;
	}

	@Override
	public String toString() {
		return "Item [itemID=" + itemID + ", name=" + name + ", type=" + type + ", category=" + category
				+ ", description=" + description + "]";
	}
}
