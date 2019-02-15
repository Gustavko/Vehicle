import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Car extends Vehicle {
	private int power;
	private Date productionDate;
	
	Car(){
		productionDate = new Date();
	}
	
	Car(String color, String name, String serialNr, int model, int price, int power, int speed){
		super(color, name, serialNr, model, price, speed);
		this.power = power;
		productionDate = new Date();
	}

	@Override
	public void setAllFields() {
		super.setAllFields();
		System.out.print("Power: ");
		this.power = input.nextInt();
		System.out.println();
		input.close();
	}
	
	@Override
	public void turnRight(int degrees) {
			super.setDirection((super.getDirection() + degrees + 360) % 360);
	}
	
	@Override
	public void turnLeft(int degrees) {
			super.setDirection(((super.getDirection() + 360) - ((degrees + 360) % 360)) % 360);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	
	@Override
	public String toString() {
		return super.toString() + String.format("		Power: %d	Production date: ", getPower()) + getProductionDate();
	}

	@Override
	public void accelerate(int speedFactor) {
		if (speedFactor < 0) {
			System.out.println("Invalid factor");
			return;
		}
		else if (getSpeed() == 0)
			setSpeed(0.5 * speedFactor);
		else if (getSpeed()*speedFactor > Driveable.MAX_SPEED_CAR)
			setSpeed(Driveable.MAX_SPEED_CAR);
		else
			setSpeed(getSpeed()*speedFactor);
		System.out.printf("Vehicle accelerated to %.2f km/h\n", getSpeed());
		
	}

	@Override
	public void breaks(int speedFactor) {
		if (speedFactor < 0) {
			System.out.println("Invalid factor");
			return;
		}
		else
			setSpeed(getSpeed()/speedFactor);
		System.out.printf("Vehicle slowed down to %.2f km/h\n", getSpeed());
	}
	
	@Override
	public void writeData(PrintWriter out) throws IOException {
		super.writeData(out);
		out.printf(",%d,%D", power, productionDate);
	}
	
	@Override
	public void readData(Scanner in) throws IOException{
		super.readData(in);
		power = in.nextInt();
		//productionDate = in.next()
	}

}
