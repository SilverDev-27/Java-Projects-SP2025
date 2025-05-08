package stockTransaction;
import java.util.Scanner;
public class StockTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Constants for transaction fees
		final double BUY_TRANSACTION_FEE = 15.00;
		final double SELL_TRANSACTION_FEE = 10.00;
		
		// Scanner for user input
		Scanner scanner = new Scanner(System.in);
		
		// Getting user input with validation
		System.out.print("What's your name? ");
		String yourName = scanner.nextLine().trim();
		while (yourName.isEmpty()) {
			System.out.print("Name cannot be blank. Enter your name: ");
			yourName = scanner.nextLine().trim();
		}
		
		System.out.print("What stock are you purvhasing? ");
		String stockSymbol = scanner.nextLine().trim().toUpperCase();
		while (stockSymbol.isEmpty()) {
			System.out.print("Stock symbol cannot be blank. Enter stock symbol: ");
			stockSymbol = scanner.nextLine().trim().toUpperCase();
		}
		
		int numberShares = 0;
		while (numberShares < 1 || numberShares > 1000) {
			System.out.print("How many shares bought (1-1000)? ");
			while (!scanner.hasNextInt()) {
				System.out.print("Invalid input. Enter a whole number between 1 and 1000: ");
				scanner.next();
			}
			numberShares = scanner.nextInt();
		}
		
		double buyPrice = 0;
		while (buyPrice <= 0) {
			System.out.print("Buy Price? ");
			while (!scanner.hasNextDouble()) {
				System.out.print("Invalid input. Enter a positive number: ");
				scanner.next();
			}
			buyPrice = scanner.nextDouble();
		}
		
		double sellPrice = 0;
		while (sellPrice <= 0) {
			System.out.print("Sale price? ");
			while (!scanner.hasNextDouble()) {
				System.out.print("Invalid input. Enter a positive number: ");
				scanner.next();
			}
			sellPrice = scanner.nextDouble();
		}
		
		// Calculations
		double amountPaid = numberShares * buyPrice;
		double amountSold = numberShares * sellPrice;
		double totalFees = BUY_TRANSACTION_FEE + SELL_TRANSACTION_FEE;
		double netProfit = amountSold - amountPaid - totalFees;
		
		// Display Results
		System.out.println("\n\t\tStatement of " + stockSymbol + " Transactions for " + yourName);
		System.out.printf("\nNumber of shares purchased (max 1000):\t\t%d", numberShares);
		System.out.printf("\nAmount of purchase:\t\t\t\t$%.2f", amountPaid);
		System.out.printf("\nAmount of sale:\t\t\t\t$%.2f", amountSold);
		System.out.printf("\nTransaction fees paid:\t\t\t$%.2f", totalFees);
		System.out.printf("\nNet profit:\t\t\t\t\t$%.2f\n", netProfit);
		
		scanner.close();
	}

}
