package system;

public class SoldReport{
	private String date;
	private String item;
	private String buyer;
	private float itemPrice;
	private float quantity;
	private float quantityPrice;
	public SoldReport(String date, String item,String buyer, float itemPrice, float quantity, float quantityPrice) {
		this.date=date;this.item=item;this.itemPrice=itemPrice;this.quantity=quantity;this.quantityPrice=quantityPrice;this.buyer=buyer;
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
	public String getBuyer() {
		return this.buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
}
