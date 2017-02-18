package system;

import java.util.ArrayList;

public class Manager {
	//////////////////Password///////////////////
	public static boolean login(String password){
		return password.equals(DB.systemPassword());
	}
	public static boolean changePassword(String newPassword){
		return DB.changeSystemPassword(newPassword);
	}
	////////////////////////////////////////////
	//////////////////Item/////////////////////
	public static boolean addNewItem(String name,float sellPrice,float buyPrice,float minBuy,float minSell,float quantity,String expireDate,String suplaierName){
		if(DB.saveItem(name, sellPrice, buyPrice, minBuy, minSell, quantity, expireDate, suplaierName)){
			Manager.saveReport("تمت اضافه صنف جديد بنجاح. ( الاسم:"+name+" \\ الكميه:"+quantity+" \\ المورد:"+suplaierName+" )");
			Manager.saveBuyReport(name, suplaierName, quantity, quantity, quantity);
			return true;
		}
		return false;
	}
	public static boolean addQuantityToExistingItem(String name,float quantity,float itemPrice,float quantityPrice,String expireDate,String supplierName){
		if(DB.addToItem(name, quantity, expireDate, supplierName)){
			Manager.saveBuyReport(name, supplierName, itemPrice, quantity, quantityPrice);
			Manager.saveReport("تمت اضافه كميه : "+quantity+" الي صنف :"+name+" من المورد : "+supplierName+"");
			return true;
		}
		return false;
	}
	public static Item getItem(String name){
		return DB.getItem(name);
	}
	public static ArrayList<Item> getAllItems(){
		return DB.getAllItems();
	}
	public static boolean exists(String name){
		return DB.itemExists(name);
	}
	public static boolean addSupplier(String name,String address,String phoneNumber,float amount){
		if(DB.saveSupplier(name, address, phoneNumber, amount)){
			saveReport("تمت اضافه موزع جديد. الاسم :"+name+"");
			return true;
		}
		return false;
	}
	public static boolean updateSupplierAmount(String name,float amount){
		return DB.updateSupplierAmount(name, amount);
	}
	public static Supplier getSupplier(String name){
		return DB.getSupplier(name);
	}
	public static ArrayList<Supplier> getAllSupliers(){
		return DB.getAllSupliers();
	}
	public static ArrayList<Report> getDailyReport(){
		return DB.getDailyReport();
	}
	public static ArrayList<Report> getMonthlyReport(){
		return DB.getMonthlyReport();
	}
	public static ArrayList<Report> getYearlyReport(){
		return DB.getYearlyReport();
	}
	public static ArrayList<BaughtReport> getDailyBaught(){
		return DB.getBaughtReportDay();
	}
	public static ArrayList<BaughtReport> getMonthlyBaught(){
		return DB.getBaughtReportMonth();
	}
	public static ArrayList<BaughtReport> getYearlyBaught(){
		return DB.getBaughtReportYear();
	}
	public static ArrayList<SoldReport>getDailySold(){
		return DB.getSoldReportDay();
	}
	public static ArrayList<SoldReport>getMonthlySold(){
		return DB.getSoldReportMonth();
	}
	public static ArrayList<SoldReport>getYearlySold(){
		return DB.getSoldReportYear();
	}
	private static void saveReport(String report) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				DB.addReport(report);
			}
		}).start();
	}
	private static void saveBuyReport(String item,String seller,float itemPrice,float quantity,float quantityPrice){
		new Thread(new Runnable() {
			@Override
			public void run() {
				DB.addBuyReport(item, seller, itemPrice, quantity, quantityPrice);
			}
		}).start();
	}
	
}
