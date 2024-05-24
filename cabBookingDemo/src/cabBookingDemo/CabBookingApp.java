package cabBookingDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CabBookingApp {
	private ArrayList<Car> cars = new ArrayList<>();
	private ArrayList<Booking> bookings = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private static final long BOOKING_INTERVAL_MS = 2 * 60 * 60 * 1000; // 2 hours in milliseconds

	public static void main(String[] args) {
		CabBookingApp app = new CabBookingApp();
		app.initializeCars();
		app.run();
	}

	private void initializeCars() {
		cars.add(new Car(1, "TN39DB6557", true, "Hatch", "Hundai I 20", 4, "George Marayan", true));
		cars.add(new Car(2, "TN39DB6558", true, "Sedan", "Verna", 4, "Leo Das", true));
		cars.add(new Car(3, "TN39DB6559", true, "Mpv", "Innova", 7, "Adi", true));
		cars.add(new Car(4, "TN39DB2255", true, "Luxury", "Kia Carens", 7, "amal Davis", true));

	}

	private void run() {
		while (true) {
			displayMenu();
			int option = scanner.nextInt();
			handleMenuOption(option);
		}
	}

	private void displayMenu() {
		System.out.println("1. Book a car");
		System.out.println("2. View all bookings");
		System.out.println("3. View available cars");
		System.out.println("4. Exit");
		System.out.print("Choose an option: ");
	}

	private void handleMenuOption(int option) {
		switch (option) {
		case 1:
			bookCar();
			break;
		case 2:
			viewAllBookings();
			break;
		case 3:
			viewAvailableCars();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	private void bookCar() {
		scanner.nextLine();
		String customerName = getCustomerInput("Enter your Name:");
		String mobileNumber = getCustomerInput("Enter your phone Number:");
		String pickupLocation = getCustomerInput("Enter your from Location:");
		String dropLocation = getCustomerInput("Enter your drop Location:");
		int approximateKM = Integer.parseInt(getCustomerInput("Enter approximate Kilometer:"));
		int carId = Integer.parseInt(getCustomerInput("Enter the Car Id which you have preferred:"));
		String dateTimeStr = getCustomerInput("Enter date and time in the format dd-MM-yyyy HH:mm:");
		Date dateTime = parseDateTime(dateTimeStr);

		if (dateTime != null && isCarAvailable(carId, dateTime)) {
			Booking booking = new Booking(customerName, mobileNumber, pickupLocation, dropLocation, approximateKM,
					carId, dateTime);
			bookings.add(booking);
			int bookingId = generateRandomBookingId();
			System.out.println("Booking successful!");
			System.out.println("+--------------------+--------------------+");
			System.out.printf("| %-18s | %-18d |\n", "Booking ID", bookingId);
			System.out.println("+--------------------+--------------------+");
			System.out.printf("| %-18s | %-18s |\n", "Customer Name", customerName);
			System.out.printf("| %-18s | %-18s |\n", "Pickup Location", pickupLocation);
			System.out.printf("| %-18s | %-18s |\n", "Drop Location", dropLocation);
			System.out.printf("| %-18s | %-18d |\n", "Car ID", carId);
			System.out.printf("| %-18s | %-18s |\n", "Date and Time", dateTimeStr);
			System.out.println("+--------------------+--------------------+");

		} else {
			System.out.println("Selected car is not available on the chosen date.");
		}
	}

	private String getCustomerInput(String prompt) {
		System.out.println(prompt);
		return scanner.nextLine();
	}

	private Date parseDateTime(String dateTimeStr) {
		while (true) {
			try {
				Date date = DATE_FORMAT.parse(dateTimeStr);
				Date currentDate = new Date();
				if (date.before(currentDate) || date.equals(currentDate)) {
					System.out.println("The entered date and time is in the past. Please enter a valid date and time.");
					dateTimeStr = getCustomerInput("Enter date and time in the format dd-MM-yyyy HH:mm:");
				} else {
					return date;
				}
			} catch (ParseException e) {
				System.out
						.println("Invalid date format. Please enter the date and time in the format dd-MM-yyyy HH:mm.");
				dateTimeStr = getCustomerInput("Enter date and time in the format dd-MM-yyyy HH:mm:");
			}
		}
	}

	private boolean isCarAvailable(int carId, Date dateTime) {
		for (Booking booking : bookings) {
			if (booking.getCarId() == carId) {
				long timeDifference = Math.abs(dateTime.getTime() - booking.getDateTime().getTime());
				if (timeDifference < BOOKING_INTERVAL_MS) {
					return false;
				}
			}
		}
		return true;
	}

	private int generateRandomBookingId() {
		Random random = new Random();
		return 10000 + random.nextInt(90000);
	}

	private void viewAllBookings() {
		System.out.println("All bookings:");
		for (Booking booking : bookings) {
			System.out.println(booking);
		}
	}

	private void viewAvailableCars() {
		System.out.println("Available cars:");
		for (Car car : cars) {
			if (car.isAvailable()) {
				car.list_OF_Cars();
			}
		}
	}
}