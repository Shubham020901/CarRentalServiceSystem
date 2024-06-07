package encapsulationTask;

import java.time.LocalDate;
import java.util.Objects;

public class Rental {

	private Car car;
    private Customer customer;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public Rental(Car car, Customer customer, LocalDate rentalDate) {
        if (rentalDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Rental date cannot be in the future");
        }
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = null;
       car.markAsRented();
       customer.addRentedCar(car);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
        return customer;
    }

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

    public void returnCar(LocalDate returnDate) {
        if (returnDate.isBefore(rentalDate)) {
            throw new IllegalArgumentException("Return date cannot be before rental date");
        }
        this.returnDate = returnDate;
        car.markAsReturned();
        customer.removeRentedCar(car);
    
    }

	@Override
	public String toString() {
		return "Rental [car=" + car + ", customer=" + customer + ", rentalDate=" + rentalDate + ", returnDate="
				+ returnDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(car, customer, rentalDate, returnDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rental other = (Rental) obj;
		return Objects.equals(car, other.car) && Objects.equals(customer, other.customer)
				&& Objects.equals(rentalDate, other.rentalDate) && Objects.equals(returnDate, other.returnDate);
	}
    
 
}
   