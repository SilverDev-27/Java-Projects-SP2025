package mpgCalculator;
import java.util.Scanner;

public class MPGCalculator {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        // Prompt for initial MPG
        System.out.print("Please Enter MPG: ");
        double mpg = scanner.nextDouble();
        double originalMPG = mpg;

        // City or Highway Driving
        System.out.print("Enter Driving Type (true for City, false for Highway): ");
        boolean isCity = scanner.nextBoolean();
        mpg += isCity ? -2 : 5;

        // Rainy or Sunny
        System.out.print("Enter Weather Condition (Rainy/Sunny): ");
        String weather = scanner.next();
        if (weather.equalsIgnoreCase("Rainy")) mpg -= 1;

        // Elevation
        System.out.print("Enter Elevation (S for Steep, H for Hilly, F for Flat): ");
        char elevation = scanner.next().charAt(0);
        switch (Character.toUpperCase(elevation)) {
            case 'S': mpg -= 5; break;
            case 'H': mpg -= 3; break;
            case 'F': break;
            default: System.out.println("Invalid elevation input, assuming Flat.");
        }

        // Weight in Vehicle
        System.out.print("Enter Weight in Vehicle (in lbs): ");
        double weight = scanner.nextDouble();
        mpg -= (weight / 100) * 0.5;

        // Speed Preference
        System.out.println("Select Speed Preference:");
        System.out.println("1. Under Speed Limit (+2 MPG)");
        System.out.println("2. At Speed Limit (No Change)");
        System.out.println("3. 5% Above Speed Limit (-1 MPG)");
        System.out.println("4. 10% Above Speed Limit (-3 MPG)");
        System.out.println("5. Over 20% Above Speed Limit (-5 MPG)");
        System.out.print("Enter your choice (1-5): ");
        int speedChoice = scanner.nextInt();
        switch (speedChoice) {
            case 1: mpg += 2; break;
            case 2: break;
            case 3: mpg -= 1; break;
            case 4: mpg -= 3; break;
            case 5: mpg -= 5; break;
            default: System.out.println("Invalid choice, assuming at speed limit.");
        }

        // Additional Factor: Tire Pressure
        System.out.print("Enter Tire Pressure in PSI (Recommended: 32-35 PSI): ");
        int tirePressure = scanner.nextInt();
        if (tirePressure < 30) {
            mpg -= 2; // Low tire pressure decreases efficiency
        } else if (tirePressure > 35) {
            mpg -= 1; // Overinflated tires also slightly decrease efficiency
        }

        // Display Report
        System.out.println("\n=== MPG Calculation Report ===");
        System.out.println("Initial MPG: " + originalMPG);
        System.out.println("Driving Type: " + (isCity ? "City (-2 MPG)" : "Highway (+5 MPG)"));
        System.out.println("Weather: " + weather + (weather.equalsIgnoreCase("Rainy") ? " (-1 MPG)" : " (No Change)"));
        System.out.println("Elevation: " + elevation + " (" + (elevation == 'S' ? "-5 MPG" : elevation == 'H' ? "-3 MPG" : "No Change") + ")");
        System.out.println("Vehicle Weight: " + weight + " lbs (-" + ((weight / 100) * 0.5) + " MPG)");
        System.out.println("Speed Choice: " + speedChoice + " (Applied Adjustment)");
        System.out.println("Tire Pressure: " + tirePressure + " PSI (Applied Adjustment)");
        System.out.println("Final MPG: " + mpg);

        scanner.close();
	}
}
