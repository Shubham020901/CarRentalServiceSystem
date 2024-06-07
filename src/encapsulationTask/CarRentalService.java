package encapsulationTask;

import java.time.LocalDate;

public class CarRentalService {

	 private Car[] cars;
	    private Customer[] customers;
	    private Rental[] rentals;
	    private int carCount;
	    private int customerCount;
	    private int rentalCount;

	    public CarRentalService() {
	        this.cars = new Car[10]; 
	        this.customers = new Customer[10]; 
	        this.rentals = new Rental[10]; 
	        this.carCount = 0;
	        this.customerCount = 0;
	        this.rentalCount = 0;
	    }
	    
	    public Car[] getCars() {
	        return cars;
	    }

	    public Customer[] getCustomers() {
	        return customers;
	    }

	    public Rental[] getRentals() {
	        return rentals;
	    }

	    public void addCar(Car car) {
	        for (int i = 0; i < carCount; i++) {
	            if (cars[i].getLicensePlate().equals(car.getLicensePlate())) {
	                throw new IllegalArgumentException("This is Duplicate license plate");
	            }
	        }
	        if (carCount < cars.length) {
	            cars[carCount++] = car;
	        } else {
	            throw new IllegalStateException("Car array is full");
	        }
	    }

	    public void addCustomer(Customer customer) {
	        for (int i = 0; i < customerCount; i++) {
	            if (customers[i].getCustomerId().equals(customer.getCustomerId())) {
	                throw new IllegalArgumentException("This is Duplicate customer ID");
	            }
	        }
	        if (customerCount < customers.length) {
	            customers[customerCount++] = customer;
	        } else {
	            throw new IllegalStateException("Customer array is full");
	        }
	    }

	    public void rentCar(int carIndex, int customerIndex, LocalDate rentalDate) {
	        if (carIndex >= carCount || customerIndex >= customerCount) {
	            throw new IllegalArgumentException("Invalid car or customer index");
	        }
	        Rental rental = new Rental(cars[carIndex], customers[customerIndex], rentalDate);
	        if (rentalCount < rentals.length) {
	            rentals[rentalCount++] = rental;
	        } else {
	            throw new IllegalStateException("Cannot add more rentals");
	        }
	    }
	    
	    public void returnCar(int carIndex, LocalDate returnDate) {
	        if (carIndex >= carCount) {
	            throw new IllegalArgumentException("Invalid car index");
	        }
	        for (int i = 0; i < rentalCount; i++) {
	            if (rentals[i].getCar().equals(cars[carIndex]) && rentals[i].getReturnDate() == null) {
	                rentals[i].returnCar(returnDate);
	                return;
	            }
	        }
	        throw new IllegalArgumentException("Car not rented or already returned");
	    }

	    public String getCarDetails(int carIndex) {
	   
	    	 if (carIndex < 0 || carIndex >= carCount) {
	            throw new IllegalArgumentException("Invalid car index");
	        }
	        return cars[carIndex].getCarDetails();
	    }

	    public String getCustomerDetails(int customerIndex) {
	    
	    	 if (customerIndex < 0 || customerIndex >= customerCount) {
	            throw new IllegalArgumentException("Invalid customer index");
	        }
	        return customers[customerIndex].getCustomerDetails();
	    }    
}


