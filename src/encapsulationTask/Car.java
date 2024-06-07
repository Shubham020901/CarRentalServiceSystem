package encapsulationTask;

import java.util.Objects;

public class Car {

	private String licensePlate;
    private String model;
    private String brand;
    private int year;
    private boolean available;
    private String color;  

    public Car(String licensePlate, String model, String brand, int year, boolean available, String color) {
		super();
		this.licensePlate = licensePlate;
		this.model = model;
		this.brand = brand;
		this.year = year;
		this.available = true;
		this.color = color;
	}

    public String getLicensePlate() {
        return licensePlate;
    }

	public void setLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty");
        }
        this.licensePlate = licensePlate;
    }

	 public String getModel() {
	        return model;
	    }
	
    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be a positive number");
        }
        this.year = year;
    }

    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

   public boolean isAvailable() {
        return available;
    }

    public void markAsRented() {
        this.available = false;
    }

    public void markAsReturned() {
        this.available = true;
    }
    
    public String getCarDetails() {
        return "License Plate: " + licensePlate + ", Model: " + model + ", Brand: " + brand + ", Year: " + year + ", Color: " + color + ", Available: " + available;
    }

	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", model=" + model + ", brand=" + brand + ", year=" + year
				+ ", available=" + available + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, brand, color, licensePlate, model, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return available == other.available && Objects.equals(brand, other.brand) && Objects.equals(color, other.color)
				&& Objects.equals(licensePlate, other.licensePlate) && Objects.equals(model, other.model)
				&& year == other.year;
	}
    
    
}

