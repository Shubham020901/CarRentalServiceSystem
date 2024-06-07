package encapsulationTask;

import java.time.LocalDate;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     CarRentalService service = new CarRentalService();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	        	System.out.println("Welcome to the Car Rental Management System:");
	            System.out.println("Select an option:");
	            System.out.println("1. Add Car");
	            System.out.println("2. Add Customer");
	            System.out.println("3. Rent Car");
	            System.out.println("4. Return Car");
	            System.out.println("5. Get Car Details");
	            System.out.println("6. Get Customer Details");
	            System.out.println("7. Exit");
	            System.out.println("Enter your choice:");
	            
	            int choice = sc.nextInt();
	            sc.nextLine(); 

	            switch (choice) {
	                case 1:
	                    Car car = new Car(null, null, null, choice, false, null);
	                    car.setLicensePlate("MH15CJ5650");
	                    car.setModel("Fortuner");
	                    car.setBrand("Toyota");
	                    car.setYear(2020);
	                    car.setColor("White");
	                    service.addCar(car);
	                    System.out.println("Car added successfully");
	                    break;
	                    
	                case 2:
	                	Customer customer = new Customer(null, null, null, null);
	                    customer.setCustomerId("01");
	                    customer.setName("Shubham Jagtap");
	                    customer.setEmail("shubhamj9100@gmail.com");
	                    customer.setPhoneNumber("7057544659");
	                    service.addCustomer(customer);
	                    System.out.println("Customer added successfully");
	                    break;
	                    
	                case 3:
	                	System.out.println("Which car do you want to rent? (0 for first car, 1 for second car, etc.)");
              			int carIndex = sc.nextInt();
              			System.out.println("Which customer is renting the car? (0 for first customer, 1 for second customer, etc.)");
              			int customerIndex = sc.nextInt();
              			service.rentCar(carIndex, customerIndex, LocalDate.now());
              			System.out.println("Car rented successfully on " + LocalDate.now());
              			break;
	                	
	                case 4:
	                	System.out.println("Which car do you want to return? (0 for first car, 1 for second car, etc.)");
              			carIndex = sc.nextInt();
              			service.returnCar(carIndex, LocalDate.now().minusDays(1));
              			System.out.println("Car returned successfully on " + LocalDate.now().minusDays(1));
              			break;
              
	                case 5:
	                	 System.out.println("Enter car index for get details:");
	                     int carIndex1 = sc.nextInt();
	                     System.out.println(service.getCarDetails(carIndex1));
	                     break;
	                     
	                case 6:
	                     System.out.println("Enter customer index for get details:");
	                     int customerIndex1 = sc.nextInt();
	                     System.out.println(service.getCustomerDetails(customerIndex1));
	                     break;
              
	                case 7:
	                    System.out.println("Exiting...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	}
}




