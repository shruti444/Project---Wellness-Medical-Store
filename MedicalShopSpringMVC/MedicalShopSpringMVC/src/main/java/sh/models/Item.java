package sh.models;

public class Item {
	private int item;
	public Item() {}
	public Item(int item) {
		this.item = item;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Item [item=" + item + "]";
	}
}
