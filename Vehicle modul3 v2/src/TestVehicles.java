import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class TestVehicles {
  public static void main(String[] args) {
	  TestVehicles vtest = new TestVehicles();
      
    try {
      vtest.menuLoop(args[0], args[1]);
    } catch(IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    } catch(CloneNotSupportedException e) {
      System.out.println("CloneNotSupportedException");
      System.exit(1);
    } catch(InputMismatchException ex) {
    	System.out.println("Invalid input");
    	System.exit(1); 
    } catch (ClassNotFoundException ex) {
    	System.out.println(ex.getMessage());
  	  System.out.println("ClassNotFoundException");
	  		System.exit(1);
	} catch (IllegalAccessException ex) {
  	  System.out.println("IllegalAccessException");
	  		System.exit(1);
	} catch (InstantiationException ex) {
		  System.out.println("InstantiationException");
		  	System.exit(1);}
  }

  private void menuLoop(String fromFile, String toFile) throws IOException, CloneNotSupportedException, InputMismatchException, 
  												InstantiationException, IllegalAccessException, ClassNotFoundException{
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    Vehicle vehicle;
    
    File file = new File(fromFile);
	  Scanner in = new Scanner(file).useLocale(Locale.US);
    in.useDelimiter(",");
    
    System.out.println("Read from file: ");
    while (in.hasNext()) {
    	String className = in.next();
    	String color = in.next(); 
    	String name = in.next();
    	String serialNr = in.next();
    	int model = in.nextInt();
    	int price = in.nextInt();
    	int powerOrGears = in.nextInt();
    	int speed = in.nextInt();
    	if (className.equals("Car"))
    		arr.add(new Car(color, name, serialNr, model, price, powerOrGears, speed));
    	if (className.equals("Bicycle"))
    		arr.add(new Bicycle(color, name, serialNr, model, price, powerOrGears, speed));
    	System.out.println(arr.get(arr.size()-1).toString());
    	if(in.hasNextLine())
    		in.nextLine();
    	
    }
    
    arr.add(new Car("Black", "Volvo", "1010-11", 2010, 85000,163, 0));
    arr.add(new Bicycle("yellow", "Diamant", "BC100", 1993,4000,10, 0));
    arr.add(new Car("red", "Ferrari Testarossa", "A112", 1996, 1200000, 350, 0));
    arr.add(new Bicycle("pink", "DBS", "42", 1994, 5000, 10, 0));

    while(true) {
      System.out.println("1...................................New car");
      System.out.println("2...............................New bicycle");
      System.out.println("3......................Find vehicle by name");
      System.out.println("4..............Show data about all vehicles");
      System.out.println("5.......Change direction of a given vehicle");
      System.out.println("6.........................Test clone method");
      System.out.println("7..................Test driveable interface");
      System.out.println("8..............................Exit program");
      System.out.println(".............................Your choice?");
      int choice = scan.nextInt();

      switch (choice) {
      case 1:
    	  arr.add(newCar());
        break;
      case 2:
    	  arr.add(newBicycle());
        break;
      case 3:
    	  {String vehicleName = " ";
			if (arr.size() == 0) 
				System.out.println("No vehicles registered, returning to menu\n");
			else {
				System.out.print("Name of vehicle: ");
				scan.nextLine();
				vehicleName = scan.nextLine();
			}
			int numberOfVehicles = 0;
			for (int a = 0; a < arr.size(); a++) {
				if (vehicleName.equals(arr.get(a).getName())) {
					System.out.println(arr.get(a).toString());
					System.out.println();
					numberOfVehicles++;
				}
				if ((a + 1) == arr.size() && numberOfVehicles == 0)
					System.out.println("Couldn't find vehicle\n");
			}
    	  }
        break;
      case 4:{
    	  if (arr.size() == 0)
				System.out.println("No vehicles registered, returning to menu");
			for (int a = 0; a < arr.size(); a++)
					System.out.println(arr.get(a).toString());
			System.out.println();
    	  }
        break;
      case 5:{
    	  String vehicleName = " ";
			if (arr.size() == 0)
				System.out.println("No vehicles registered, returning to menu\n");
			else {
				System.out.print("Name of vehicle: ");
				scan.nextLine();
				vehicleName = scan.nextLine();
			}
			int numberOfCars = 0;
			for (int a = 0; a < arr.size(); a++) {
				if (vehicleName.equals(arr.get(a).getName())) {
					numberOfCars++;
					System.out.print("Direction (L/R): ");
					String direction = scan.next();
					System.out.print("Degrees: ");
					int degrees = scan.nextInt();
					switch (direction) {
						case "L": arr.get(a).turnLeft(degrees);
								System.out.printf("Vehicle has turned %d degrees to the left\n\n", degrees);
							break;
						case "R": arr.get(a).turnRight(degrees);
								System.out.printf("Vehicle has turned %d degrees to the right\n\n", degrees);
							break;
						default: System.out.println("Invalid direction, returning to menu\n");
					}
				}
				else if(a + 1 == arr.size() && numberOfCars == 0)
					System.out.println("Couldn't find vehicle\n");
			}
		}
        break;
      case 6:{
			Car car1 = new Car("White", "Ferrari", "1234", 2018, 1000000000, 700, 0);
			Car car2 = (Car) car1.clone();
			Calendar newDate = Calendar.getInstance();
			newDate.set(2018, 3, 15);
			car2.setBuyingDate(newDate);
			System.out.println(car1.toString() + "\n" + car2.toString() + "\n");
		}
    	  break;
      case 7:{
    	  Car car1 = new Car("White", "Ferrari", "1234", 2018, 1000000000, 700, 0);
			Bicycle bicycle1 = new Bicycle("Blue", "Merida", "4321", 5, 5000, 24, 0);
			System.out.println("Car: ");
			car1.accelerate(10);
			car1.accelerate(35);
			car1.accelerate(35);
			car1.breaks(5);
			car1.breaks(7);
			car1.stop();
			
			System.out.println("\nBicycle: ");
			bicycle1.accelerate(8);
			bicycle1.accelerate(60);
			bicycle1.breaks(10);
			bicycle1.breaks(3);
			bicycle1.stop();
			System.out.println();
      }
    	  break;
      case 8:{ 
    	  File toVehicleFile = new File(toFile);
    	  PrintWriter output = new PrintWriter(toVehicleFile);
    	  Collections.sort(arr);
    	  System.out.println("Written to file (Sorted by price): ");
    	  while(arr.size() > 0) {
    		  if (arr.get(0).getClass().getName() == "Car") {
    			  Car a = (Car) arr.get(0);
    			  System.out.println(a.toString());
    			  output.printf("Car,%s,%s,%s,%d,%d,%d,%.2f", a.getColor(), a.getName(), a.getSerialNr(),
    					  a.getModel(), a.getPrice(), a.getPower(), a.getSpeed());
    			  if (arr.size() != 1)
    				  output.println(",");
    			  arr.remove(0);
    		  }
    		  else {
    			  Bicycle a = (Bicycle) arr.get(0);
    			  System.out.println(a.toString());
    			  output.printf("Bicycle,%s,%s,%s,%d,%d,%d,%.2f", a.getColor(), a.getName(), a.getSerialNr(),
    					  a.getModel(), a.getPrice(), a.getGears(), a.getSpeed());
    			  if (arr.size() != 1)
    				  output.println(",");
    			  arr.remove(0);
    		  }
    	  }
    	  output.close();
    	  scan.close();
    	  in.close();
          System.exit(0);
  	    }
      
      default:
        System.out.println("Wrong input!");
      }
      
     }
    }
  

    static Car newCar() {
		Scanner carIn = new Scanner(System.in);
		System.out.print("Color: ");
		String color = carIn.nextLine();
		System.out.print("Name: ");
		String name = carIn.nextLine();
		System.out.print("Serial number: ");
		String serialNr = carIn.nextLine();
		System.out.print("Model: ");
		int model = carIn.nextInt();
		System.out.print("Price: ");
		int price = carIn.nextInt();
		System.out.print("Power: ");
		int power = carIn.nextInt();
		System.out.println();
		Car car = new Car(color, name, serialNr, model, price, power, 0);
		return car;	
	}
  
  static Bicycle newBicycle() {
		Scanner bicIn = new Scanner(System.in);
		System.out.print("Color: ");
		String color = bicIn.nextLine();
		System.out.print("Name: ");
		String name = bicIn.nextLine();
		System.out.print("Serial number: ");
		String serialNr = bicIn.nextLine();
		System.out.print("Model: ");
		int model = bicIn.nextInt();
		System.out.print("Price: ");
		int price = bicIn.nextInt();
		System.out.print("Gears: ");
		int gears = bicIn.nextInt();
		System.out.println();
		Bicycle bicycle = new Bicycle(color, name, serialNr, model, price, gears, 0);
		return bicycle;
	}

}
