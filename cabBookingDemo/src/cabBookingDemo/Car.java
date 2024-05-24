package cabBookingDemo;

public class Car {

	private int carId;
	private String carRegistrationNumber;
	private boolean ac;
	private String carType;
	private String carName;
	private int capacity;
	private String driverName;
	private boolean booking_Status;

	public Car(int carId, String carRegistrationNumber, boolean ac, String carType, String carName, int capacity,
			String driverName, boolean booking_Status) {

		this.carId = carId;
		this.carRegistrationNumber = carRegistrationNumber;
		this.ac = ac;
		this.carType = carType;
		this.carName = carName;
		this.capacity = capacity;
		this.driverName = driverName;
		this.booking_Status = booking_Status;
	}

	public int getCarId() {
		return carId;
	}

	public String getRegistrationNumber() {
		return carRegistrationNumber;
	}

	public boolean isAvailable() {
		return booking_Status;
	}

	public void setAvailable(boolean available) {
		this.booking_Status = available;
	}

	public void list_OF_Cars() {
		System.out.println(
				"+------+----------------------+-----+------------+----------------------+----------+--------------------+");
		System.out.println(
				"| Car_ID   | Car Registration No. | AC  | Car Type   | Car Name          | Capacity | Driver Name     |");
		System.out.println(
				"+------+----------------------+-----+------------+----------------------+----------+---------------------+");
		System.out.printf("| %-7s | %-20s | %-3s | %-10s | %-20s | %-8s | %-15s |\n", carId, carRegistrationNumber, ac,
				carType, carName, capacity, driverName);
		System.out.println(
				"+------+----------------------+-----+------------+----------------------+----------+---------------------+");
	}
}
