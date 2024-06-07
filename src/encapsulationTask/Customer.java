package encapsulationTask;

import java.util.Arrays;
import java.util.Objects;

public class Customer {

	private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private Car[] rentedCars;
    private int rentedCarCount;

    public Customer(String customerId, String name, String email, String phoneNumber) {
  
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.rentedCars = new Car[10]; 
        this.rentedCarCount = 0;
    }

    public String getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(String customerId) {
    	if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
    	
		this.customerId = customerId;
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
		this.name = name;
	}
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
		if (email == null || !email.contains("@")) {
	        throw new IllegalArgumentException("Invalid email address");
	        }
		
		this.email = email;
	}
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    public Car[] getRentedCars() {
        return rentedCars;
    }

	public void setRentedCars(Car[] rentedCars) {
		this.rentedCars = rentedCars;
	}

	public void addRentedCar(Car car) {
       if (rentedCarCount < rentedCars.length) {
            rentedCars[rentedCarCount++] = car;
        } else {
            throw new IllegalStateException("Cannot rent more cars");
        }
    }

    public void removeRentedCar(Car car) {
    	for (int i = 0; i < rentedCarCount; i++) {
            if (rentedCars[i].equals(car)) {
                rentedCars[i] = rentedCars[--rentedCarCount];
                rentedCars[rentedCarCount] = null;
                return;
            }
        }
        throw new IllegalArgumentException("Car not found in rented cars");
    }
    
    public String getCustomerDetails() {
        StringBuilder details = new StringBuilder("Customer ID: " + customerId + ", Name: " + name + ", Email: " + email + ", Rented Cars: ");
        for (int i = 0; i < rentedCarCount; i++) {
            details.append(rentedCars[i].getLicensePlate()).append(" ");
        }
        return details.toString();
    }

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", rentedCars=" + Arrays.toString(rentedCars) + ", rentedCarCount=" + rentedCarCount
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(rentedCars);
		result = prime * result + Objects.hash(customerId, email, name, phoneNumber, rentedCarCount);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber)
				&& rentedCarCount == other.rentedCarCount && Arrays.equals(rentedCars, other.rentedCars);
	}
    
    
}

