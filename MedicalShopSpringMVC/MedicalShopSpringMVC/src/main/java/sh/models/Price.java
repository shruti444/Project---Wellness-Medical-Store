package sh.models;

public class Price {
	private int price;
	public Price() {}
	public Price(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Price [price=" + price + "]";
	}
}
