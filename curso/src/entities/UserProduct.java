package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class UserProduct extends Product{
		
	private LocalDate manufactureDate;
	
	public UserProduct() {
		super();
	}
	public UserProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String toString() {
		return super.getName()
				+" (used) $ "
				+String.format("%.2f", super.getPrice())
				+"(Manufacture date: "
				+manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+")";
	}

}
