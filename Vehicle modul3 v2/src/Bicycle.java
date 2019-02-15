import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

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
		super.setDirection(((super.getDirection() + 360) - ((degrees + 360) % 360)) % 360);
	}

	@Override
	public void turnRight(int degrees) {
		super.setDirection((super.getDirection() + degrees + 360) % 360);	
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

	@Override
	public void accelerate(int speedFactor) {
		if (speedFactor < 0) {
			System.out.println("Invalid factor");
			return;
		}
		else if (getSpeed() == 0)
			setSpeed(0.3*speedFactor);
		else if (getSpeed() * 0.5 * speedFactor > Driveable.MAX_SPEED_BIKE)
			setSpeed(Driveable.MAX_SPEED_BIKE);
		else
			setSpeed(getSpeed() * 0.5 * speedFactor);
		System.out.printf("Vehicle accelerated to %.2f km/h\n", getSpeed());
	}

	@Override
	public void breaks(int speedFactor) {
		if (speedFactor < 0) {
			System.out.println("Invalid factor");
			return;
		}
		else
			setSpeed(getSpeed() / (speedFactor * 0.5));
		System.out.printf("Vehicle slowed down to %.2f km/h\n", getSpeed());
	}
	
	@Override
	public void writeData(PrintWriter out) throws IOException {
		super.writeData(out);
		out.printf(",%d,%D", gears, productionDate);
	}
	
	@Override
	public void readData(Scanner in) throws IOException{
		super.readData(in);
		gears = in.nextInt();
		//productionDate = in.next();
	}
	
}
