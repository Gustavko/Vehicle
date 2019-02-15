import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
public abstract class Vehicle implements Comparable<Vehicle>, Cloneable{
	private String color;
	private String name;
	private String serialNr;
	private int model;
	private int price;
	private int direction;
	private double speed;
	private Calendar buyingDate;
	protected Scanner input;
	
	Vehicle(){
	}
	
	Vehicle(String color, String name, String serialNr, int model, int price, int speed){
		this.color = color;
		this.name = name;
		this.serialNr = serialNr;
		this.model = model;
		this.price = price;
		this.buyingDate = Calendar.getInstance();
		this.speed = speed;
	}
	
	public void setAllFields() {
		input = new Scanner(System.in);
		System.out.print("Color: ");
		this.color = input.next();
		System.out.print("\nName: ");
		this.name = input.next();
		System.out.print("\nSerial number: ");
		this.serialNr = input.next();
		System.out.print("\nModel: ");
		this.model = input.nextInt();
		System.out.print("\nPrice: ");
		this.price = input.nextInt();
		System.out.println();
		input.close();
	}
	public abstract void turnLeft(int degrees);
	
	public abstract void turnRight(int degrees);
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNr() {
		return serialNr;
	}

	public void setSerialNr(String serialNr) {
		this.serialNr = serialNr;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Calendar getBuyingDate() {
		return buyingDate;
	}

	public void setBuyingDate(Calendar buyingDate) {
		this.buyingDate = buyingDate;
	}
	
	public int compareTo(Vehicle a){
		if (this.getPrice() > a.getPrice())
			return 1;
		if (this.getPrice() < a.getPrice())
			return -1;
		else
			return 0;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Vehicle a = (Vehicle)super.clone(); 
		a.setBuyingDate((Calendar)buyingDate.clone());
		return super.clone();
	}
	
	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return String.format("Name: %s	Color: %s	Serial number: %s	Model: %d	Price: %d	Direction: %d	Speed: %.2f	Buying date: ", 
				getName(), getColor(), getSerialNr(), getModel(), getPrice(), getDirection(), getSpeed()) + format1.format(getBuyingDate().getTime());
	}

}