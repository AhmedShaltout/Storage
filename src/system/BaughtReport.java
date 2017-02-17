package system;

public class BaughtReport {
	private String date;
	private String item;
	private float itemPrice;
	private float quantity;
	private float quantityPrice;
	private String seller;
	public BaughtReport(String date, String item,String seller, float itemPrice, float quantity, float quantityPrice) {
		this.date=date;this.item=item;this.itemPrice=itemPrice;this.quantity=quantity;this.quantityPrice=quantityPrice;this.seller=seller;
	}
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getItem() {
		return this.item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getItemPrice() {
		return this.itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public float getQuantity() {
		return this.quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getQuantityPrice() {
		return this.quantityPrice;
	}
	public void setQuantityPrice(float quantityPrice) {
		this.quantityPrice = quantityPrice;
	}
	public String getSeller() {
		return this.seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
}
