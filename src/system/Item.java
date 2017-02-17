package system;

public class Item {
	private String name;
	private float sellPrice;
	private float buyPrice;
	private float minBuy;
	private float minSell;
	private float quantity;
	public Item(String name,float sellPrice,float buyPrice,float minBuy,float minSell,float quantity){
		this.quantity=quantity;this.name=name;this.sellPrice=sellPrice;this.buyPrice=buyPrice;this.minBuy=minBuy;this.minSell=minSell;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSellPrice() {
		return this.sellPrice;
	}
	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}
	public float getBuyPrice() {
		return this.buyPrice;
	}
	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}
	public float getMinBuy() {
		return this.minBuy;
	}
	public void setMinBuy(float minBuy) {
		this.minBuy = minBuy;
	}
	public float getMinSell() {
		return this.minSell;
	}
	public void setMinSell(float minSell) {
		this.minSell = minSell;
	}
	public float getQuantity() {
		return this.quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
}
