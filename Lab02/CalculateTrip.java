package calculateTrip;
import java.util.Scanner;
public class CalculateTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		// Get user first name
		String firstName = "";
		while (firstName.isBlank()) {
			System.out.print("Please enter your First Name: ");
			firstName = scanner.nextLine().trim();
		}
		
		// Get MPG (1-99)
		int mpg = 0;
		while (mpg < 1 || mpg > 99) {
			System.out.print("Please enter the MPG of your car (1-99): ");
			while (!scanner.hasNextInt()) {
				System.out.print("Invalid input. Enter an integer (1-99): ");
				scanner.next(); // Clears invalid input
			}
			mpg = scanner.nextInt();
		}
		
		// Get miles to be traveled (1-999)
		int miles = 0;
		while (miles < 1 || miles > 999) {
			System.out.print("Please enter the miles to be traveled (1-999): ");
			while (!scanner.hasNextInt()) {
				System.out.print("Invalid input. Enter an integer (1-999): ");
				scanner.next(); // Clears invalid input
			}
			miles = scanner.nextInt();
		}
		
		// Get price per gallon (1.0-9.99)
		double pricePerGallon = 0;
		while (pricePerGallon < 1.0 || pricePerGallon > 9.99) {
			System.out.print("What is the price per gallon (1.0-9.99): ");
			while (!scanner.hasNextDouble()) {
				System.out.print("Invalid input. Enter a number (1.0-9.99): ");
				scanner.next(); // Clears invalid input		
				}
		pricePerGallon = scanner.nextDouble();
		}
		
		// Calculate trip cost
		double tripCost = (miles / (double) mpg) * pricePerGallon;
		
		// Display results
		System.out.println("\nHello, " + firstName + "! Thank your for providing your information!\n");
		System.out.printf("Car MPG:\t\t\t%d\n",  mpg);
		System.out.printf("Miles to Drive:\t\t\t%d\n", miles);
		System.out.printf("Price per gallon of gas:\t$%.2f\n", pricePerGallon);
		System.out.printf("Your trip will cost:\t$%.2f\n", tripCost);
		
		scanner.close();
	}

}
