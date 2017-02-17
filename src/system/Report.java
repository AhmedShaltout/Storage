package system;

public class Report {
	private String actionDate;
	private String action;
	public Report(String actionDate,String action){
		this.action=action;this.actionDate=actionDate;
	}
	public String getActionDate() {
		return this.actionDate;
	}
	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}
	public String getAction() {
		return this.action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
}
