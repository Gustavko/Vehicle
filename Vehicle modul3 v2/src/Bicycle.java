import java.util.Date;

public class Bicycle extends Vehicle {
	private int gears;
	private Date productionDate;
	
	Bicycle(){
		productionDate = new Date();
	}
	
	Bicycle(String color, String name, String serialNr, int model, int price, int gears, int speed){
		super(color, name, serialNr, model, price, speed);
		this.gears = gears;
		productionDate = new Date();
	}
	
	@Override
	public void setAllFields() {
		super.setAllFields();
		//input = new Scanner(System.in);
		System.out.print("Gears: ");
		this.gears = input.nextInt();
		System.out.println();
		input.close();
	}

	@Override
	public void turnLeft(int degrees) {
		System.out.printf("The bicycle has turned %d degrees to the left", degrees);
	}

	@Override
	public void turnRight(int degrees) {
		System.out.printf("The bicycle has turned %d degrees to the right", degrees);	
	}
	
	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

	public Date getProductionDate() {
		return productionDate;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("		Gears: %d	Production date: ", getGears()) + getProductionDate();
	}

}
