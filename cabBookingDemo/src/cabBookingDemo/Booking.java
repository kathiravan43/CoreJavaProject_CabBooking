package cabBookingDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
	private String customerName;

	private String mobileNumber;
	private String pickupLocation;
	private String dropLocation;
	private int approximateKM;
	private int carId;
	private Date dateTime;
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");

	public Booking(String customerName, String mobileNumber, String pickupLocation, String dropLocation,
			int approximateKM, int carId, Date dateTime) {
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.approximateKM = approximateKM;
		this.carId = carId;
		this.dateTime = dateTime;

	}

	public int getCarId() {
		return carId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public String toString() {
		return "Booking{" + "customerName='" + customerName + '\'' + ", mobileNumber='" + mobileNumber + '\''
				+ ", pickupLocation='" + pickupLocation + '\'' + ", dropLocation='" + dropLocation + '\''
				+ ", approximateKM=" + approximateKM + ", carId=" + carId + ", date=" + DATE_FORMAT.format(dateTime)
				+ '}';
	}
}