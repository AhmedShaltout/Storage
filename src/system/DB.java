package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class DB {
/**======================================== for connection ===================================**/
	
	private static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Storage?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=false","root","");
		}
		catch(SQLException |ClassNotFoundException ex){
			return null;
		}
	}
	
	/**==========================================================================================**/
	
	/**responsible for returning values from the database the result can be null**/
	private static ResultSet select(String sql){
		try{
			return getConnection().createStatement().executeQuery(sql);
		}catch (SQLException | NullPointerException e) {
			return null;
		}
	}
	
	/**responsible for executing Queries if done returns true ,on the other hand false**/
	private static boolean editDataBase(String sql){
		try {
			getConnection().createStatement().execute(sql);
			return true;
		} catch (SQLException | NullPointerException e) {
			return false;
		}
	}
	///////////////////////////////////Suppliers///////////////////////////////////////////
	public static boolean saveSupplier(String name,String address,String phoneNumber,float amount){
		return editDataBase("insert into supplier(name,address,phoneNumber,amount) values('"+name+"','"+address+"','"+phoneNumber+"',"+amount+")");
	}
	
	public static boolean updateSuplier(String name,String address,String phoneNumber,float amount){
		return editDataBase("update supplier set address='"+address+"' , phoneNumber='"+phoneNumber+"', amount="+amount+" where name='"+name+"' ");
	}
	
	public static boolean updateSupplierAmount(String name, float amount){
		return editDataBase("update supplier set amount = (amount+"+amount+") where name='"+name+"'");
	}
	
	public static boolean deleteSupplier(String name){
		return editDataBase("delete from supplier where name='"+name+"'");
	}
	
	public static Supplier getSupplier(String name){
		return createSupplier(select("select * from supplier where name='"+name+"'"));
	}
	
	public static ArrayList<Supplier> getAllSupliers(){
		ResultSet result=select("select * from supplier");
		ArrayList<Supplier> suppliers=new ArrayList<>();
		Supplier supplier;
		while((supplier=createSupplier(result))!=null)
			suppliers.add(supplier);
		return suppliers;
	}
	
	private static Supplier createSupplier(ResultSet result) {
		try {
			result.next();
			return new Supplier(result.getString("name"), result.getString("address"), result.getString("phoneNumber"), result.getFloat("amount"));
		} catch (SQLException | NullPointerException e) {}
		return null;
	}
	
	public static boolean supplierExists(String name){
		return editDataBase("update supplier set name='"+name+"' where name='"+name+"'");
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////System Password///////////////////////////////////////////////////////
	public static String systemPassword(){
		ResultSet result= select("select password from system");
		try {
			result.next();
			return result.getString("password");
		} catch (SQLException|NullPointerException e) {}
		return null;
	}
	
	public static boolean changeSystemPassword(String newPass){
		return editDataBase("update system set password ='"+newPass+"'");
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////Items////////////////////////////////////////////////////////////
	public static boolean saveItem(String name,float sellPrice,float buyPrice,float	minBuy,float minSell,float quantity,String expireDate,String suplaierName){
		if(editDataBase("insert into item(name,sellPrice,buyPrice,minBuy,minSell,quantity) values('"+name+"',"+sellPrice+","+buyPrice+","+minBuy+","+quantity+")")&&
				editDataBase("insert into expire_supplier(item,quantity,expireDate,suplaierName) values('"+name+"',"+quantity+",'"+expireDate+"','"+suplaierName+"')"))
			return true;
		return false;
	}
	
	public static boolean updateItem(String name,float sellPrice,float buyPrice,float minBuy,float minSell){
		return editDataBase("update item set sellPrice="+sellPrice+",buyPrice="+buyPrice+",minBuy="+minBuy+",minSell="+minSell+" where name='"+name+"'");
	}
	
	public static boolean addToItem(String name,float quantity,String expireDate,String suplaierName){
		if(editDataBase("insert into expire_supplier(item,quantity,expireDate,suplaierName) values('"+name+"',"+quantity+",'"+expireDate+"','"+suplaierName+"')")
				&&editDataBase("update item set quantity=(quantity+"+quantity+") where name='"+name+"'"))
			return true;
		return false;
	}
	
	public static boolean deleteItem(String name){
		if(editDataBase("delete from item where name='"+name+"'")&&editDataBase("delete from expire_supplier where item= '"+name+"'"))
			return true;
		return false;
	}
	
	public static boolean deleteQuantity(String name,float quantity){
		if(editDataBase("delete from expire_supplier where item='"+name+"'")&&editDataBase("update item set quantity=(quantity+"+quantity+" where name='"+name+"')"))
			return true;
		return false;
	}
	
	public static Item getItem(String name){
		return createItem(select("select * from item where name='"+name+"'"));
	}
	
	public static ArrayList<Item> getAllItems(){
		ArrayList<Item>items=new ArrayList<>();
		ResultSet result=select("select * from item");
		Item item;
		while((item=createItem(result)) != null)
			items.add(item);
		return items;
	}
	
	private static Item createItem(ResultSet result) {
		try {
			result.next();
			return new Item(result.getString("name"), result.getFloat("sellPrice"), result.getFloat("buyPrice"),
					result.getFloat("minBuy"), result.getFloat("minSell"), result.getFloat("quantity"));
		} catch (SQLException|NullPointerException e) {}
		return null;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////Reports/////////////////////////////////////////////////////////
	public static ArrayList<Report> getDailyReport(){
		return report(LocalDateTime.now().toLocalDate().toString());
	}
	
	public static ArrayList<Report> getMonthlyReport(){
		return report(LocalDateTime.now().minusMonths(1).toLocalDate().toString());
	}
	
	public static ArrayList<Report> getYearlyReport(){
		return report(LocalDateTime.now().minusYears(1).toLocalDate().toString());
	}
	
	private static ArrayList<Report> report(String time){
		ArrayList<Report> reports= new ArrayList<>();
		ResultSet result = select("select * from report where actionDate >='"+time+"'");
		Report report;
			while((report=createReport(result))!=null)
				reports.add(report);
		return reports;
	}
	
	private static Report createReport(ResultSet result) {
		try {
			result.next();
			return new Report(result.getString("actionDate"), result.getString("action"));
		} catch (SQLException|NullPointerException e) {}
		return null;
	}
	
	public static ArrayList<SoldReport> getSoldReportDay(){
		return soldReport(LocalDateTime.now().toLocalDate().toString());
	}
	
	public static ArrayList<SoldReport> getSoldReportMonth(){
		return soldReport(LocalDateTime.now().minusMonths(1).toLocalDate().toString());
	}
	
	public static ArrayList<SoldReport> getSoldReportYear(){
		return soldReport(LocalDateTime.now().minusYears(1).toLocalDate().toString());
	}
	
	private static ArrayList<SoldReport> soldReport(String time) {
		ArrayList<SoldReport> reports= new ArrayList<>();
		ResultSet result = select("select * from sold_report where date >='"+time+"'");
		SoldReport report;
			while((report=createSoldReport(result))!=null)
				reports.add(report);
		return reports;
	}
	
	private static SoldReport createSoldReport(ResultSet result) {
		try {
			result.next();
			return new SoldReport(result.getString("date"),result.getString("item"),result.getFloat("itemPrice")
					,result.getFloat("quantity"),result.getFloat("quantityPrice"));
		} catch (SQLException|NullPointerException e) {}
		return null;
	}
	
	public static ArrayList<BaughtReport> getBaughtReportDay(){
		return baoughtReport(LocalDateTime.now().toLocalDate().toString());
	}
	
	public static ArrayList<BaughtReport> getBaughtReportMonth(){
		return baoughtReport(LocalDateTime.now().minusMonths(1).toLocalDate().toString());
	}
	
	public static ArrayList<BaughtReport> getBaughtReportYear(){
		return baoughtReport(LocalDateTime.now().minusYears(1).toLocalDate().toString());
	}
	
	private static ArrayList<BaughtReport> baoughtReport(String time){
		ArrayList<BaughtReport> reports= new ArrayList<>();
		ResultSet result = select("select * from baught_report where date >='"+time+"'");
		BaughtReport report;
			while((report=createBaughtReport(result))!=null)
				reports.add(report);
		return reports;
	}
	
	private static BaughtReport createBaughtReport(ResultSet result) {
		try {
			result.next();
			return new BaughtReport(result.getString("date"),result.getString("item"),result.getFloat("itemPrice")
					,result.getFloat("quantity"),result.getFloat("quantityPrice"));
		} catch (SQLException|NullPointerException e) {}
		return null;
	}
	///////////////////////////////////////////////////////////////////////////////////
}
