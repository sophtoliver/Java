//MP2, Sophia M. Toliver, CIS 340, TTH 4:30 pm


public class Devices {

	private String sku = "";
	private String name = "";
	private boolean status = true;
	
	public Devices () {
	
	}//Devices
	
	public Devices (String sku) {
		this.sku = sku;
	}//Devices
	
	public Devices (String sku, String name) {
		this.sku = sku;
		this.name = name;
	}//Devices
	
	public Devices (String sku, String name, boolean status) {
		this.sku = sku;
		this.name = name;
		this.status = status;
	}//Devices
	
	public String getSku () {
		return sku;
	}//getSku
	
	public void setSku (String sku) {
		this.sku = sku;
	}//setSku
	
	public String getName () {
		return name;
	}//getName
	
	public void setName (String name) {
		this.name = name;
	}//setName
	
	public String getStatus () {
		
		if (status == true) {
		return ("Available");	
		}//if
		else {
			return ("Checked Out");
		}//else
		
	}//getStatus
	
	public void setStatus (boolean status) {
		this.status = status;		
	}//setStatus
	
	
}//Devices 
