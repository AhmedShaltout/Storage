package system;

public class Supplier {
	private String name;
	private String address;
	private String phoneNumber;
	private float amount;
	
	public Supplier(String name,String address,String phoneNumber,float	amount){
		this.address=address;this.name=name;this.phoneNumber=phoneNumber;this.amount=amount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
