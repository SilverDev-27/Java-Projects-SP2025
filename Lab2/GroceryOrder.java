package grocerOrder;
import java.util.Scanner;
public class GroceryOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		final double TAX_RATE = 0.05;
		
		int produceCount = 0, meatCount = 0, bakeryCount = 0;
		double produceTotal = 0, meatTotal = 0, bakeryTotal = 0;
		char again;
		
		do {
			System.out.println("\nGrocery Menu");
            System.out.println("1. Produce Item");
            System.out.println("2. Meat Item");
            System.out.println("3. Bakery Item");
            System.out.print("Please enter your selection: ");
            
            int choice = scanner.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.print("Invalid choice. Please enter 1, 2, or 3: ");
                choice = scanner.nextInt();
		}
            
            double cost = 0;
            do{
                System.out.print("Please enter cost: ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Invalid input. Enter a number between 0.01 and 999.0: ");
                    scanner.next();
                }
                cost = scanner.nextDouble();
            } while (cost < 0.01 || cost > 999.0);
            
            switch (choice) {
                case 1: produceCount++; produceTotal += cost; break;
                case 2: meatCount++; meatTotal += cost; break;
                case 3: bakeryCount++; bakeryTotal += cost; break;
            }
            
            System.out.print("Again (Y/N)? ");
            again = scanner.next().toUpperCase().charAt(0);
        } while (again == 'Y');
        
        double foodCost = produceTotal + meatTotal + bakeryTotal;
        double tax = foodCost * TAX_RATE;
        double totalCost = foodCost + tax;
        int itemCount = produceCount + meatCount + bakeryCount;
        double averageItemCost = (itemCount == 0) ? 0 : foodCost / itemCount;
        
        System.out.println("\nHere is your order:");
        System.out.println("Produce\tMeat\tBakery");
        System.out.printf("Counts:\t%d\t%d\t%1d\n", produceCount, meatCount, bakeryCount);
        System.out.printf("Totals:\t$%.2f\t$%.2f\t$%.2f\n", produceTotal, meatTotal, bakeryTotal);
        System.out.printf("Averages:\t$%.2f\t$%.2f\t$%.2f\n", 
                          produceCount == 0 ? 0 : produceTotal / produceCount,
                          meatCount == 0 ? 0 : meatTotal / meatCount,
                          bakeryCount == 0 ? 0 : bakeryTotal / bakeryCount);
        System.out.printf("\nFood Cost:\t$%.2f\n", foodCost);
        System.out.printf("Tax:\t\t$%.2f\n", tax);
        System.out.printf("Total Cost:\t$%.2f\n", totalCost);
        System.out.printf("Item Count:\t%d\n", itemCount);
        System.out.printf("Average Item Cost:\t$%.2f\n", averageItemCost);
        
        scanner.close();
	}
}
