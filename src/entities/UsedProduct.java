package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	private Date manufactureDate;
	
	public UsedProduct() {
		super();	
	}
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public final String priceTag() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/yyyy");		
		return name + " (Used) $ " +  String.format("%.2f", price) + " (Manufactured date: " + sdf.format(manufactureDate) + ")";  
	}
	
	
}
